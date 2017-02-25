package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Notice;

public class AdminDao {

	public List<Notice> queryNotice(Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("select * from notice");
		ResultSet rs = pstmt.executeQuery();
		List<Notice> notices = new ArrayList<Notice>();
		while (rs.next()) {
			Notice notice = new Notice();
			notice.setNoticeId(rs.getInt("notice_id"));
			notice.setNoticeTitle(rs.getString("notice_title"));
			notice.setNoticeContent(rs.getString("notice_content"));
			notice.setNoticeAuthor(rs.getString("notice_author"));
			notice.setNoticeReleaseTime(rs.getDate("notice_release_time"));
			notices.add(notice);
		}
		return notices;
	}
}
