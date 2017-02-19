package com.edu.bean;

/**
 * 教师表
 * 
 * @author Administrator
 * 
 */
public class Teacher extends User{
	
	private static final long serialVersionUID = -8787488217321949003L;
	
	private String teacherPhone;// 教师电话
	private String teacherAddress;// 家庭住址
	private String teacherTitle;// 教师职称
	private int teaColId;// 外键，学院表ID
	private String teacherRace;	//民族
	private String teacherGender; //性别

	public Teacher() {
	}

	public Teacher(String teacherPhone, String teacherAddress,
			String teacherTitle, int teaColId, String teacherRace,
			String teacherGender) {
		super();
		this.teacherPhone = teacherPhone;
		this.teacherAddress = teacherAddress;
		this.teacherTitle = teacherTitle;
		this.teaColId = teaColId;
		this.teacherRace = teacherRace;
		this.teacherGender = teacherGender;
	}

	public String getTeacherRace() {
		return teacherRace;
	}

	public void setTeacherRace(String teacherRace) {
		this.teacherRace = teacherRace;
	}

	public String getTeacherGender() {
		return teacherGender;
	}

	public void setTeacherGender(String teacherGender) {
		this.teacherGender = teacherGender;
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
