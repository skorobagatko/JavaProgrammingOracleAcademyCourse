package com.skorobahatko.practice1;

import java.util.List;
import java.util.NoSuchElementException;

public class Student {

    private final String firstName;
    private final String lastName;
    private final Group group;
    private final List<Exam> exams;

    public Student(String firstName, String lastName, Group group, List<Exam> exams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.exams = exams;
    }

    public int getHighestGradeBySubject(String subject) {
        return exams.stream()
                .filter(e -> e.getSubject().equals(subject))
                .mapToInt(Exam::getGrade)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getExamsCountByGrade(int grade) {
        return (int) exams.stream()
                .filter(e -> e.getGrade() == grade)
                .mapToInt(Exam::getGrade)
                .count();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public double getAverageGradeBySemester(int semester) {
        return exams.stream()
                .filter(e -> e.getSemester() == semester)
                .mapToInt(Exam::getGrade)
                .average()
                .getAsDouble();
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public void removeExam(Exam exam) {
        if (!exams.remove(exam)) throw new NoSuchElementException();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Group getGroup() {
        return group;
    }

    public List<Exam> getExams() {
        return exams;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                ", exams=" + exams +
                '}';
    }
}
