package com.skorobahatko.practice1;

public class Group {

    private int course;
    private String faculty;

    public Group(int course, String faculty) {
        this.course = course;
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Group{" +
                "course='" + course + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }

}
