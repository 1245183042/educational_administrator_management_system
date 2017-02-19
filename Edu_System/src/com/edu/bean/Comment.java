package com.edu.bean;

/**
 * 教师评论表
 * 
 * @author Administrator
 * 
 */

public class Comment {
	
	private int comId;// 主键
	private int comStuId;// 外键，学生表Id
	private int comSubId;// 外键，科目表Id
	private int comTeaId;// 外键，教师表Id
	private String comContent;// 评论内容
	private int comLevel;// 满意度星级(1-4)

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
