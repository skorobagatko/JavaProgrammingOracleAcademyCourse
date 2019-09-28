package com.skorobahatko.lecture8_jdbc.simple;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String USER = "test";
    private static final String PASSWORD = "1234";
    private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee(name, age) VALUES (?, ?);";
    private static final String SQL_GET_ALL_EMPLOYEES = "INSERT INTO employee(name, age) VALUES (?, ?);";

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 25));
        employees.add(new Employee("Bob", 30));
        employees.add(new Employee("Jack", 35));

        System.out.println(addEmployeesToDB(employees));
        System.out.println(employees);

        List<Employee> emloyeesFromDB = getAllEmployeesFromDB();

    }

    private static List<Employee> getAllEmployeesFromDB() {
        List<Employee> result = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(SQL_GET_ALL_EMPLOYEES)) {
            result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setAge(age);

                result.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int addEmployeesToDB(List<Employee> employees) {
        int result = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(SQL_INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {
            for (Employee employee : employees) {
                ps.setString(1, employee.getName());
                ps.setInt(2, employee.getAge());
                result += ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    employee.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
