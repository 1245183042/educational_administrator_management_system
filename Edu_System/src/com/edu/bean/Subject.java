package com.edu.bean;

/**
 * 科目表
 * 
 * @author Administrator
 * 
 */
public class Subject {

	private int subjectId;// 主键
	private String subjectName;// 科目名称
	private int subjectTime;// 科目学时

	public Subject() {
	}

	public Subject(int subjectId, String subjectName, int subjectTime) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectTime = subjectTime;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectTime() {
		return subjectTime;
	}

	public void setSubjectTime(int subjectTime) {
		this.subjectTime = subjectTime;
	}

}
