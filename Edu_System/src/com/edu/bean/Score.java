package com.edu.bean;

/**
 * �ɼ���
 * 
 * @author Administrator
 * 
 */
public class Score {

	private int scoId;// ����
	private double scoScore;// ����
	private int scoStuId;// �����ѧ����Id
	private int scoSubId;// �������Ŀ��Id
	private int scoTeaId;// �������ʦ��Id
	private String scoTime;// ����ʱ��

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
