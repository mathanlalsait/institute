package com.candid.sma.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course")

public class Course extends BaseEntity{
	private String courseName;
	
	

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + "]";
	}
	
	
	
	

}
