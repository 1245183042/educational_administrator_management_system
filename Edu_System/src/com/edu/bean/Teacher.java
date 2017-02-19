package com.edu.bean;

import java.io.Serializable;

/**
 * ��ʦ��
 * 
 * @author Administrator
 * 
 */
public class Teacher implements User,Serializable{
	
	private static final long serialVersionUID = -8787488217321949003L;
	
	private int teacherId;// ����
	private String teacherName;// ��ʦ����
	private String teacherPassword;// ��ʦ����
	private String teacherPhone;// ��ʦ�绰
	private String teacherAddress;// ��ͥסַ
	private String teacherTitle;// ��ʦְ��
	private int teaColId;// �����ѧԺ��ID

	public Teacher() {
	}

	public Teacher(int teacherId, String teacherName, String teacherPassword,
			String teacherPhone, String teacherAddress, String teacherTitle,
			int teaColId) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherPassword = teacherPassword;
		this.teacherPhone = teacherPhone;
		this.teacherAddress = teacherAddress;
		this.teacherTitle = teacherTitle;
		this.teaColId = teaColId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherTitle() {
		return teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public int getTeaColId() {
		return teaColId;
	}

	public void setTeaColId(int teaColId) {
		this.teaColId = teaColId;
	}

}
