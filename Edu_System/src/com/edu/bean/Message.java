package com.edu.bean;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -7152824057168642835L;

	private User user;
	private String identify;
	private String operationCode;
	private College college;
	private Grade grade;
	private Major major;

	public Message(User user, College college, Grade grade, Major major) {
		super();
		this.user = user;
		this.college = college;
		this.grade = grade;
		this.major = major;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Message() {
	}

	public Message(String identify, String operationCode) {
		this.identify = identify;
		this.operationCode = operationCode;
	}

	public Message(User user, String identify, String operationCode) {
		this.user = user;
		this.identify = identify;
		this.operationCode = operationCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

}
