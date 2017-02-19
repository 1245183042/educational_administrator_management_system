package com.edu.bean;

/**
 * 年级表
 * 
 * @author Administrator
 * 
 */
public class Grade {

	private int gradeId;// 主键
	private String gradeName;// 年级名称

	public Grade() {
	}

	public Grade(int gradeId, String gradeName) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

}
