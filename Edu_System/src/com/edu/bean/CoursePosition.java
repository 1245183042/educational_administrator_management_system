package com.edu.bean;

import java.io.Serializable;

/**
 * 课程位置表
 * 
 * @author Administrator
 * 
 */
public class CoursePosition implements Serializable {

	private static final long serialVersionUID = 8663826251035722000L;
	private int cpId;// 主键
	private String cpPosition;// 课表位置名称

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
