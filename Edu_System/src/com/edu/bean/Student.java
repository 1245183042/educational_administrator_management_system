package com.edu.bean;
/**
 * ѧ����
 * @author Administrator
 *
 */
public class Student {
	private int studentId;//����
	private String studentName;//ѧ������
	private String studentPassword;//����
	private String studentPhone;//�绰
	private String studentAddress;//��ͥסַ
	private String studentDormitory;//�����
	private int stuMajId;//�����רҵ��Id
	private int stuGraId;//������꼶��Id
	private int stuClass;//�༶
	public Student(){}
	public Student(int studentId, String studentName, String studentPassword,
			String studentPhone, String studentAddress,
			String studentDormitory, int stuMajId, int stuGraId, int stuClass) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPassword = studentPassword;
		this.studentPhone = studentPhone;
		this.studentAddress = studentAddress;
		this.studentDormitory = studentDormitory;
		this.stuMajId = stuMajId;
		this.stuGraId = stuGraId;
		this.stuClass = stuClass;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
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
