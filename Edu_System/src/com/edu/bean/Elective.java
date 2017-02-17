package com.edu.bean;
/**
 * 选修课表
 * @author Administrator
 *
 */
public class Elective {
	private int eleId;//主键
	private int eleStatus;//课程状态：0可选，1不可选
	private int eleSubId;//外键，科目表Id
	private int eleTeaId;//外键，教师表Id
	private int	eleCpId;//外键，课程位置表Id
	private int eleStuId;//外键，学生表Id
	private String eleWeek;//上课周数
	private String eleClassroom;//上课
	public Elective(){}
	public Elective(int eleId, int eleStatus, int eleSubId, int eleTeaId,
			int eleCpId, int eleStuId,String eleWeek,String eleClassroom) {
		this.eleId = eleId;
		this.eleStatus = eleStatus;
		this.eleSubId = eleSubId;
		this.eleTeaId = eleTeaId;
		this.eleCpId = eleCpId;
		this.eleStuId = eleStuId;
		this.eleWeek = eleWeek;
		this.eleClassroom = eleClassroom;
	}
	public String getEleClassroom(){
		return eleClassroom;
	}
	public void setEleClassroom(String eleClassroom){
		this.eleClassroom = eleClassroom;
	}
	public String getEleWeek(){
		return eleWeek;
	}
	public void setEleWeek(String eleWeek){
		this.eleWeek = eleWeek;
	}
	public int getEleId() {
		return eleId;
	}
	public void setEleId(int eleId) {
		this.eleId = eleId;
	}
	public int getEleStatus() {
		return eleStatus;
	}
	public void setEleStatus(int eleStatus) {
		this.eleStatus = eleStatus;
	}
	public int getEleSubId() {
		return eleSubId;
	}
	public void setEleSubId(int eleSubId) {
		this.eleSubId = eleSubId;
	}
	public int getEleTeaId() {
		return eleTeaId;
	}
	public void setEleTeaId(int eleTeaId) {
		this.eleTeaId = eleTeaId;
	}
	public int getEleCpId() {
		return eleCpId;
	}
	public void setEleCpId(int eleCpId) {
		this.eleCpId = eleCpId;
	}
	public int getEleStuId() {
		return eleStuId;
	}
	public void setEleStuId(int eleStuId) {
		this.eleStuId = eleStuId;
	}
	
}
