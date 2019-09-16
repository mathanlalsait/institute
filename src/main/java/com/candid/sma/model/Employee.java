package com.candid.sma.model;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class Employee extends BaseEntity {

	@NotNull(message = "Full Name should not be null")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String fullName;
	private String email;
	/** Password Should be auto-generated,5 digit random number **/
	private String password;

	@Size(min = 10, message = "Please enter valid mobile number")
	private String primaryMobile;
	private String secondaryMobile;
	private String dob;
	private Integer age;
	private String gender;
	private String refferalType;
	private String refferalInfo;
	private String address;
	private String city;
	private String state;
	/** Below fields should be auto generate while creating new user **/
	private Date createdOn;
	private Date modifiedOn;
	private boolean delete;
	private boolean status;
	private String comments;

	/* private Set<Course> courses; */

	public Employee() {
	}

	public Employee(String fullName, String email) {
		this.fullName = fullName;
		this.email = email;
	}

	


	public Employee(String fullName,
			String email, String primaryMobile,
			String gender) {
		this.fullName = fullName;
		this.email = email;
		this.primaryMobile = primaryMobile;
		this.gender = gender;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimaryMobile() {
		return primaryMobile;
	}

	public void setPrimaryMobile(String primaryMobile) {
		this.primaryMobile = primaryMobile;
	}

	public String getSecondaryMobile() {
		return secondaryMobile;
	}

	public void setSecondaryMobile(String secondaryMobile) {
		this.secondaryMobile = secondaryMobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRefferalType() {
		return refferalType;
	}

	public void setRefferalType(String refferalType) {
		this.refferalType = refferalType;
	}

	public String getRefferalInfo() {
		return refferalInfo;
	}

	public void setRefferalInfo(String refferalInfo) {
		this.refferalInfo = refferalInfo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	/*@Override
	public String toString() {
		return "User [fullName=" + fullName + ", email=" + email + ", password=" + password + ", primaryMobile="
				+ primaryMobile + ", secondaryMobile=" + secondaryMobile + ", dob=" + dob + ", age=" + age + ", gender="
				+ gender + ", refferalType=" + refferalType + ", refferalInfo=" + refferalInfo + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", delete=" + delete + ", status=" + status + ", comments=" + comments + "]";
	}*/
	public String toString() {
		return String.format("User[%s, %s, %s, %s]", fullName, email, primaryMobile, gender);
	}
}
	

