package com.edu.bean;

/**
 * �꼶��
 * 
 * @author Administrator
 * 
 */
public class Grade {

	private int gradeId;// ����
	private String gradeName;// �꼶����

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
