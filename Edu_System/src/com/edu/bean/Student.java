package com.edu.bean;

/**
 * 学生表
 * 
 * @author Administrator
 * 
 */
public class Student extends User {

	private static final long serialVersionUID = -742543612237194698L;

	private String studentPhone;// 电话
	private String studentAddress;// 家庭住址
	private String studentDormitory;// 宿舍号
	private int stuMajId;// 外键，专业表Id
	private int stuGraId;// 外键，年级表Id
	private int stuClass;// 班级
	private String studentGender;// 性别
	private String studentRace;// 民族

	public Student() {
	}

	public Student(String studentPhone, String studentAddress,
			String studentDormitory, int stuMajId, int stuGraId, int stuClass,
			String studentGender, String studentRace) {
		super();
		this.studentPhone = studentPhone;
		this.studentAddress = studentAddress;
		this.studentDormitory = studentDormitory;
		this.stuMajId = stuMajId;
		this.stuGraId = stuGraId;
		this.stuClass = stuClass;
		this.studentGender = studentGender;
		this.studentRace = studentRace;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentRace() {
		return studentRace;
	}

	public void setStudentRace(String studentRace) {
		this.studentRace = studentRace;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentDormitory() {
		return studentDormitory;
	}

	public void setStudentDormitory(String studentDormitory) {
		this.studentDormitory = studentDormitory;
	}

	public int getStuMajId() {
		return stuMajId;
	}

	public void setStuMajId(int stuMajId) {
		this.stuMajId = stuMajId;
	}

	public int getStuGraId() {
		return stuGraId;
	}

	public void setStuGraId(int stuGraId) {
		this.stuGraId = stuGraId;
	}

	public int getStuClass() {
		return stuClass;
	}

	public void setStuClass(int stuClass) {
		this.stuClass = stuClass;
	}

}
