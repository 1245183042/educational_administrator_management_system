package com.edu.bean;
/**
 * ѡ�޿α�
 * @author Administrator
 *
 */
public class Elective {
	private int eleId;//����
	private int eleStatus;//�γ�״̬��0��ѡ��1����ѡ
	private int eleSubId;//�������Ŀ��Id
	private int eleTeaId;//�������ʦ��Id
	private int	eleCpId;//������γ�λ�ñ�Id
	private int eleStuId;//�����ѧ����Id
	private String eleWeek;//�Ͽ�����
	private String eleClassroom;//�Ͽ�
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
