package com.edu.bean;

import java.io.Serializable;

/**
 * 学院表
 * 
 * @author Administrator
 * 
 */
public class Collage implements Serializable {

	private static final long serialVersionUID = 20931365245212094L;

	private int collageId; // 主键
	private String collageName; // 学院名称

	public Collage(int collageId, String collageName) {
		super();
		this.collageId = collageId;
		this.collageName = collageName;
	}

	public Collage() {
	}

	public int getCollageId() {
		return collageId;
	}

	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

}
