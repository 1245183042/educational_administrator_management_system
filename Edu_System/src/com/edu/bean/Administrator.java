package com.edu.bean;

import java.io.Serializable;

/**
 * 管理员表
 * 
 * @author Administrator
 * 
 */
public class Administrator implements User, Serializable {

	private static final long serialVersionUID = 6896389678256442191L;

	private int amdinId;// 主键
	private String adminName;// 管理员账号
	private String adminPassword;// 密码

	public Administrator() {
	}

	public Administrator(int amdinId, String adminName, String adminPassword) {
		this.amdinId = amdinId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public int getAmdinId() {
		return amdinId;
	}

	public void setAmdinId(int amdinId) {
		this.amdinId = amdinId;
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
