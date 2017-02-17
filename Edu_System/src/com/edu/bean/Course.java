package com.edu.bean;
/**
 * 课程表
 * @author Administrator
 *
 */

public class Course {
	private int couId;//主键
	private int couClassroom;//班级号
	private String couWeek;//需要上课的周数
	private int couSubId;//外键，科目表Id
	private int couTeaId;//外键，教师表Id
	private int couGraId;//外键，年级表Id
	private int couMajId;//外键，专业表Id
	private int couCpId;//外键，课程位置表Id
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
