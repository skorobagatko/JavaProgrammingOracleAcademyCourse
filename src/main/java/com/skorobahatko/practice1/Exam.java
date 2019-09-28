package com.skorobahatko.practice1;

public class Exam {

    private final String subject;
    private final int grade;
    private final int semester;
    private final int year;

    public Exam(String subject, int grade, int semester, int year) {
        this.subject = subject;
        this.grade = grade;
        this.semester = semester;
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }

    public int getSemester() {
        return semester;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "subject='" + subject + '\'' +
                ", grade=" + grade +
                ", semester=" + semester +
                ", year=" + year +
                '}';
    }
}
