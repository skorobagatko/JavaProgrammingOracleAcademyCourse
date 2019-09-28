package com.skorobahatko.practice4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentUtilsTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Johnson", 1));
        students.add(new Student("Bob", "Stewart", 1));
        students.add(new Student("Patrick", "Patrickson", 2));
        students.add(new Student("Fred", "Fredericton", 2));
        students.add(new Student("Jack", "Jackson", 3));
        students.add(new Student("Bill", "Watson", 3));
        students.add(new Student("Bill", "Adams", 3));

        Map<String, Student> studentsMap = StudentUtils.createMapFromList(students);
        for (Map.Entry<String, Student> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        StudentUtils.printStudents(students, 2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        StudentUtils.sortStudentsByName(students);
        students.forEach(System.out::println);
    }

}
