package com.edu.bean;

/**
 * ��Ŀ��
 * 
 * @author Administrator
 * 
 */
public class Subject {

	private int subjectId;// ����
	private String subjectName;// ��Ŀ����
	private int subjectTime;// ��Ŀѧʱ

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
