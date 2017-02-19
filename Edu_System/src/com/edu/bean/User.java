package com.edu.bean;

import java.io.Serializable;

/**
 * 用户根类
 * 
 * @author chen7
 * 
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -6062562346506650477L;
	
	protected int userId;
	protected String userName;
	protected String userPassword;
	

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
