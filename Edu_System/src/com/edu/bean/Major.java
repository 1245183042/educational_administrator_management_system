package com.edu.bean;
/**
 * רҵ��
 * @author Administrator
 *
 */
public class Major {
	private int majorId;//����
	private String majorName;//רҵ����
	private int majColId;//�����ѧԺ��Id
	public Major(){}
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
