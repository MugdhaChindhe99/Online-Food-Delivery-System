package com.cg.ofd.login.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotNull
	@Size(min = 2, message = "userName should have at least 2 character")
	@Column
	private String userName;

	@NotNull
	@Size(min = 4, message = "password should have at least 4 character")
	@Column
	private String password;

	@NotNull
	@Column
	private String role;

	public Login() {
		super();
	}

	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param role
	 */
	public Login(int userId, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Login [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
