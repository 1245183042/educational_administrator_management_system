package com.edu.bean;

import java.io.Serializable;

/**
 * 管理员表
 * 
 * @author Administrator
 * 
 */
public class Administrator implements Serializable {

	private static final long serialVersionUID = -1810065916377235099L;
	private int adminId;
	private String adminName;
	private String adminPassword;

	public Administrator() {
		super();
	}

	public Administrator(int adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
