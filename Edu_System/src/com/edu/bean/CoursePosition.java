package com.edu.bean;

/**
 * �γ�λ�ñ�
 * 
 * @author Administrator
 * 
 */
public class CoursePosition {

	private int cpId;// ����
	private String cpPosition;// �α�λ������

	public CoursePosition() {
	}

	public CoursePosition(int cpId, String cpPosition) {
		super();
		this.cpId = cpId;
		this.cpPosition = cpPosition;
	}

	public int getCpId() {
		return cpId;
	}

	public void setCpId(int cpId) {
		this.cpId = cpId;
	}

	public String getCpPosition() {
		return cpPosition;
	}

	public void setCpPosition(String cpPosition) {
		this.cpPosition = cpPosition;
	}

}
