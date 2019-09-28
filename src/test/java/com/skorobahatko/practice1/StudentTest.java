package com.skorobahatko.practice1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    private static Student student;

    @Before
    public void setUp() throws Exception {
        Group group = new Group(1, "IT");
        List<Exam> exams = new ArrayList<>();
        student = new Student("Ivan", "Ivanov", group, exams);
    }

    @Test
    public void testGetHighestGradeBySubjectPositive() {
        student.getExams().add(new Exam("Databases", 85, 1, 2016));
        student.getExams().add(new Exam("Databases", 70, 2, 2017));
        student.getExams().add(new Exam("Databases", 65, 3, 2017));

        int expected = 85;
        int actual = student.getHighestGradeBySubject("Databases");
        assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetHighestGradeBySubjectNegative() {
        student.getHighestGradeBySubject("Databases");
    }

    @Test
    public void testAddExamPositive() {
        student.addExam(new Exam("Math", 80, 2, 2017));
        int expected = 80;
        int actual = student.getHighestGradeBySubject("Math");
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveExamPositive() {
        Exam exam1 = new Exam("Math", 80, 2, 2017);
        Exam exam2 = new Exam("Math", 90, 3, 2017);
        student.addExam(exam1);
        student.addExam(exam2);
        student.removeExam(exam2);
        int expected = 80;
        int actual = student.getHighestGradeBySubject("Math");
        assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveExamNegative() {
        student.removeExam(new Exam("Math", 80, 2, 2017));
    }

    @Test
    public void testGetExamsCountByGrade() {
        student.getExams().add(new Exam("Databases", 85, 1, 2016));
        student.getExams().add(new Exam("Math", 85, 2, 2017));
        student.getExams().add(new Exam("Software Testing", 85, 3, 2017));

        int expected = 3;
        int actual = student.getExamsCountByGrade(85);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageGradeBySemester() {
        student.getExams().add(new Exam("Databases", 85, 1, 2016));
        student.getExams().add(new Exam("Math", 70, 1, 2017));

        double expected = (85 + 70) / 2.;
        double actual = student.getAverageGradeBySemester(1);
        assertEquals(expected, actual, 0.01);
    }




}
