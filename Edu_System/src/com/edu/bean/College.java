package com.edu.bean;

/**
 * 学院表
 * 
 * @author Administrator
 * 
 */
public class College {

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
