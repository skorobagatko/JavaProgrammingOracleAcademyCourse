package com.skorobahatko.practice4;

import java.util.*;

public class StudentUtils {

    private StudentUtils() {}

    public static Map<String, Student> createMapFromList(List<Student> students) {
        if (students == null) return null;
        Map<String, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getFirstName().concat(" ").concat(student.getLastName()), student);
        }
        return studentMap;
    }

    public static void printStudents(List<Student> students, int course) {
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            if (student.getCourse() == course) {
                System.out.println(student.getFirstName().concat(" ").concat(student.getLastName()));
            }
        }
    }

    public static void sortStudentsByName(List<Student> students) {
        students.sort(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName));
    }

}
