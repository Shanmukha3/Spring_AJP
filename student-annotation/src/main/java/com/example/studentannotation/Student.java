package com.example.studentannotation;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
    private String name;
    private char section;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	@Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", section=" + section + "]";
    }
	
}
