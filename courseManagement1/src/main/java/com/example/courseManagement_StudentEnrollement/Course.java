package com.example.courseManagement_StudentEnrollement;

import org.springframework.stereotype.Component;


@Component
public class Course {

    private int courseId;

    private String courseName;

    private String courseDuration;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                '}';
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;

    }

}
