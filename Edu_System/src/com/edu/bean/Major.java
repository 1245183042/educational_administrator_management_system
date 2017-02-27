package com.edu.bean;

import java.io.Serializable;

/**
 * 专业表
 * 
 * @author Administrator
 * 
 */
public class Major implements Serializable{

	private static final long serialVersionUID = -4083929788209020304L;
	private int majorId;// 主键
	private String majorName;// 专业名称
	private int majColId;// 外键，学院表Id

	public Major() {
	}

	public Major(int majorId, String majorName, int majColId) {
		this.majorId = majorId;
		this.majorName = majorName;
		this.majColId = majColId;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public int getMajColId() {
		return majColId;
	}

	public void setMajColId(int majColId) {
		this.majColId = majColId;
	}

}
