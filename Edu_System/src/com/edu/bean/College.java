package com.edu.bean;

import java.io.Serializable;

/**
 * 学院表
 * 
 * @author Administrator
 * 
 */
public class College implements Serializable{

	private static final long serialVersionUID = 20931365245212094L;
	private int collegeId;// 主键
	private String collegeName;// 学院名称

	public College() {
	}

	public College(int collegeId, String collegeName) {
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

}
