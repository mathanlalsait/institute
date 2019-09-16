package com.candid.sma.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {

	@Field("username")
	@NotNull(message = "User Name should not be null")
	@Size(max = 45, message = "Name should have maximum 45 characters")
	private String username;

	@Field("password")
	@NotNull(message = "Password should not be null")
	@Size(max = 20, message = "Password should have maximum 20 characters")
	private String password;

	@Field("enabled")
	@NotNull(message = "Is Username enabled or disabled?")
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0); // ACCOUNT, LIB

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
