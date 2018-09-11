package com.candid.sma.model;

import java.util.List;

public class Batch extends BaseEntity {
	private String batchName;
	private String batchStatus;
	private List<String> studentsList;

	public Batch() {

	}

	public Batch(String batchName, String batchStatus, List<String> studentsList) {
		this.batchName = batchName;
		this.batchStatus = batchStatus;
		this.studentsList = studentsList;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public List<String> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<String> studentsList) {
		this.studentsList = studentsList;
	}

}
