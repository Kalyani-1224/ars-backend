package com.codegnan.app.arsbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "full_name")
	@NotBlank(message = "Full Name cannot be left blank")
	private String fullName;

	@Column(name = "email")
	@NotBlank(message = "Email cannot be left blank")
	private String email;

	@Column(name = "password")
	@NotBlank(message = "Password cannot be left blank")
	private String password;

	@Column(name = "role")
	@NotBlank(message = "Role cannot be left blank")
	private String role;

	public User() {
	}

	
	public User(Long userId, String fullName, String email, String password, String role) {
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	
	public Long getUserId() {
		return userId;
	}

	
	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
}