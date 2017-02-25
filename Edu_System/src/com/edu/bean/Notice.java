package com.edu.bean;

import java.io.Serializable;
/**
 * 公告表
 */
import java.util.Date;

public class Notice implements Serializable {

	private static final long serialVersionUID = 4523657067310607961L;
	private int noticeId;// 主键
	private String noticeTitle;// 标题
	private String noticeContent;// 内容
	private Date noticeReleaseTime;// 发布时间
	private int noticeTarget;// 接收者：0，全体，1学生，2教师
	private String noticeAuthor;// 作者

	public Notice() {
	}

	public Notice(int noticeId, String noticeTitle, String noticeContent,
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

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
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
