package com.example.CourseManagement_spring;
import org.springframework.stereotype.Component;

@Component
public class Course {
	private int id;
	private String courseName;
    private String courseduration;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseduration() {
		return courseduration;
	}
	public void setCourseduration(String courseduration) {
		this.courseduration = courseduration;
	}
	
	@Override
	public String toString() {
		return "Course [Courseid=" + id + ", courseName=" + courseName + ", CourseDuration=" + courseduration + "]";
	}
    
}