package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.Student;

public class StudentDao {
	public Message queryNotice(Connection conn) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement("select * from notice");
		ResultSet rs = pstmt.executeQuery();
		List<Notice> notices = new ArrayList<Notice>();
		while(rs.next()){
			Notice notice = new Notice();
			notice.setNoticeAuthor(rs.getString("notice_author"));
			notice.setNoticeContent(rs.getString("notice_content"));
			notice.setNoticeId(rs.getInt("notice_id"));
			notice.setNoticeReleaseTime(rs.getDate("notice_release_time"));
			notice.setNoticeTarget(rs.getInt("notice_target"));
			notice.setNoticeTitle(rs.getString("notice_title"));
			notices.add(notice);
		}
		Message message = new Message();
		message.setNotices(notices);
		return message;
	}
}
