package com.edu.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 971346206222851539L;
	private int userId;
	private String userName;
	private String userPassword;

	public User() {
	}

	public User(int userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
