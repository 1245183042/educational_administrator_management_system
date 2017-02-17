package com.edu.bean;
/**
 * 公告表
 */
import java.sql.Clob;
import java.util.Date;

public class Notice {
	private int noticeId;//主键
	private String noticeTitle;//标题
	private Clob noticeContent;//内容
	private Date noticeReleaseTime;//发布时间
	private int noticeTarget;//接收者：0学生，1教师
	private String noticeAuthor;//作者
	
	public Notice(){}
	public Notice(int noticeId, String noticeTitle, Clob noticeContent,
			Date noticeReleaseTime, int noticeTarget, String noticeAuthor) {
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeReleaseTime = noticeReleaseTime;
		this.noticeTarget = noticeTarget;
		this.noticeAuthor = noticeAuthor;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public Clob getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(Clob noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeReleaseTime() {
		return noticeReleaseTime;
	}
	public void setNoticeReleaseTime(Date noticeReleaseTime) {
		this.noticeReleaseTime = noticeReleaseTime;
	}
	public int getNoticeTarget() {
		return noticeTarget;
	}
	public void setNoticeTarget(int noticeTarget) {
		this.noticeTarget = noticeTarget;
	}
	public String getNoticeAuthor() {
		return noticeAuthor;
	}
	public void setNoticeAuthor(String noticeAuthor) {
		this.noticeAuthor = noticeAuthor;
	}
	
	
}
