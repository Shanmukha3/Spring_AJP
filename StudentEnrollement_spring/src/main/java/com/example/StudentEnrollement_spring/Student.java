package com.example.StudentEnrollement_spring;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
	private String studentName;
    private String courseid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	@Override
	public String toString() {
		return "Student [StudentID=" + id + ", studentName=" + studentName + ", Courseid=" + courseid + "]";
	}
    
}