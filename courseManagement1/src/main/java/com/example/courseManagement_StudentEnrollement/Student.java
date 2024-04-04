package com.example.courseManagement_StudentEnrollement;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {

    private int studentId;

    private String name;

    private int enrolledCourseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrolledCourseId() {
        return enrolledCourseId;
    }

    public void setEnrolledCourseId(int enrolledCourseId) {
        this.enrolledCourseId = enrolledCourseId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", enrolledIds=" + enrolledCourseId +
                '}';
    }
}
