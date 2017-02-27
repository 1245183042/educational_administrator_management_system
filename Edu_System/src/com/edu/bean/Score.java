package com.edu.bean;

import java.io.Serializable;

/**
 * 成绩表
 * 
 * @author Administrator
 * 
 */
public class Score implements Serializable {

	private static final long serialVersionUID = 4164410766655194995L;
	private int scoId;// 主键
	private double scoScore;// 分数
	private int scoStuId;// 外键，学生表Id
	private int scoSubId;// 外键，科目表Id
	private int scoTeaId;// 外键，教师表Id
	private String scoTime;// 考试时间

	public Score() {
	}

	public Score(int scoId, double scoScore, int scoStuId, int scoSubId,
			int scoTeaId, String scoTime) {
		this.scoId = scoId;
		this.scoScore = scoScore;
		this.scoStuId = scoStuId;
		this.scoSubId = scoSubId;
		this.scoTeaId = scoTeaId;
		this.scoTime = scoTime;
	}

	public int getScoId() {
		return scoId;
	}

	public void setScoId(int scoId) {
		this.scoId = scoId;
	}

	public double getScoScore() {
		return scoScore;
	}

	public void setScoScore(double scoScore) {
		this.scoScore = scoScore;
	}

	public int getScoStuId() {
		return scoStuId;
	}

	public void setScoStuId(int scoStuId) {
		this.scoStuId = scoStuId;
	}

	public int getScoSubId() {
		return scoSubId;
	}

	public void setScoSubId(int scoSubId) {
		this.scoSubId = scoSubId;
	}

	public int getScoTeaId() {
		return scoTeaId;
	}

	public void setScoTeaId(int scoTeaId) {
		this.scoTeaId = scoTeaId;
	}

	public String getScoTime() {
		return scoTime;
	}

	public void setScoTime(String scoTime) {
		this.scoTime = scoTime;
	}

}
