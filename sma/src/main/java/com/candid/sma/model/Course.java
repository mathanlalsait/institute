package com.candid.sma.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course")

public class Course extends BaseEntity{
	private String courseName;

}
