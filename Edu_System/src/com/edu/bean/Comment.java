package com.edu.bean;

/**
 * ��ʦ���۱�
 * 
 * @author Administrator
 * 
 */

public class Comment {
	
	private int comId;// ����
	private int comStuId;// �����ѧ����Id
	private int comSubId;// �������Ŀ��Id
	private int comTeaId;// �������ʦ��Id
	private String comContent;// ��������
	private int comLevel;// ������Ǽ�(1-4)

	public Comment() {
	}

	public Comment(int comId, int comStuId, int comSubId, int comTeaId,
			String comContent, int comLevel) {
		this.comId = comId;
		this.comStuId = comStuId;
		this.comSubId = comSubId;
		this.comTeaId = comTeaId;
		this.comContent = comContent;
		this.comLevel = comLevel;
	}

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public int getComStuId() {
		return comStuId;
	}

	public void setComStuId(int comStuId) {
		this.comStuId = comStuId;
	}

	public int getComSubId() {
		return comSubId;
	}

	public void setComSubId(int comSubId) {
		this.comSubId = comSubId;
	}

	public int getComTeaId() {
		return comTeaId;
	}

	public void setComTeaId(int comTeaId) {
		this.comTeaId = comTeaId;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public int getComLevel() {
		return comLevel;
	}

	public void setComLevel(int comLevel) {
		this.comLevel = comLevel;
	}

}
