package com.edu.bean;
/**
 * �γ̱�
 * @author Administrator
 *
 */

public class Course {
	private int couId;//����
	private int couClassroom;//�༶��
	private String couWeek;//��Ҫ�Ͽε�����
	private int couSubId;//�������Ŀ��Id
	private int couTeaId;//�������ʦ��Id
	private int couGraId;//������꼶��Id
	private int couMajId;//�����רҵ��Id
	private int couCpId;//������γ�λ�ñ�Id
	public Course(){}
	public Course(int couId, int couClassroom, String couWeek, int couSubId,
			int couTeaId, int couGraId, int couMajId, int couCpId) {
		this.couId = couId;
		this.couClassroom = couClassroom;
		this.couWeek = couWeek;
		this.couSubId = couSubId;
		this.couTeaId = couTeaId;
		this.couGraId = couGraId;
		this.couMajId = couMajId;
		this.couCpId = couCpId;
	}
	public int getCouId() {
		return couId;
	}
	public void setCouId(int couId) {
		this.couId = couId;
	}
	public int getCouClass() {
		return couClassroom;
	}
	public void setCouClass(int couClass) {
		this.couClassroom = couClass;
	}
	public String getCouWeek() {
		return couWeek;
	}
	public void setCouWeek(String couWeek) {
		this.couWeek = couWeek;
	}
	public int getCouSubId() {
		return couSubId;
	}
	public void setCouSubId(int couSubId) {
		this.couSubId = couSubId;
	}
	public int getCouTeaId() {
		return couTeaId;
	}
	public void setCouTeaId(int couTeaId) {
		this.couTeaId = couTeaId;
	}
	public int getCouGraId() {
		return couGraId;
	}
	public void setCouGraId(int couGraId) {
		this.couGraId = couGraId;
	}
	public int getCouMajId() {
		return couMajId;
	}
	public void setCouMajId(int couMajId) {
		this.couMajId = couMajId;
	}
	public int getCouCpId() {
		return couCpId;
	}
	public void setCouCpId(int couCpId) {
		this.couCpId = couCpId;
	}
	
}
