package com.edu.bean;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -7152824057168642835L;

	private User user;
	private String identify;
	private String operationCode;

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
