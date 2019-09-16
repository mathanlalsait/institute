package com.candid.sma.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "user_roles")
public class UserRole{

	@Id
	@Field("user_role_id")
	@NotNull(message = "User Role Id should not be null")
	private Integer userRoleId;
	private User user;
	
	@Field("role")
	@NotNull(message = "Role should not be null")
	@Size(max = 45, message = "Role should have maximum 45 characters")
	private String role; // ADMIN, USER, ACCOUNT, ... 

	public UserRole() {
	}

	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}