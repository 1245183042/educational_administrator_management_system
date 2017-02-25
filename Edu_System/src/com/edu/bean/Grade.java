package com.edu.bean;

import java.io.Serializable;

/**
 * 年级表
 * 
 * @author Administrator
 * 
 */
public class Grade implements Serializable {

	private static final long serialVersionUID = -2453875679836729397L;
	private int gradeId;// 主键
	private String gradeYear;// 学年
	private int gradeTerm;// 学期

	public Grade() {
	}

	public Grade(int gradeId, String gradeYear, int gradeTerm) {
		super();
		this.gradeId = gradeId;
		this.gradeYear = gradeYear;
		this.gradeTerm = gradeTerm;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeYear() {
		return gradeYear;
	}

	public void setGradeYear(String gradeYear) {
		this.gradeYear = gradeYear;
	}

	public int getGradeTerm() {
		return gradeTerm;
	}

	public void setGradeTerm(int gradeTerm) {
		this.gradeTerm = gradeTerm;
	}

}
