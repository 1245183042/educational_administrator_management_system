package com.edu.bean;

/**
 * ѧԺ��
 * 
 * @author Administrator
 * 
 */
public class College {

	private int collegeId;// ����
	private String collegeName;// ѧԺ����

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
