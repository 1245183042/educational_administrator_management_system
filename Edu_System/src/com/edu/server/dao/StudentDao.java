package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Collage;
import com.edu.bean.Course;
import com.edu.bean.CoursePosition;
import com.edu.bean.Grade;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.Teacher;

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
			notice.setNoticeReleaseTime(rs.getString("notice_release_time"));
			notice.setNoticeTarget(rs.getInt("notice_target"));
			notice.setNoticeTitle(rs.getString("notice_title"));
			notices.add(notice);
		}
		Message message = new Message();
		message.setNotices(notices);
		return message;
	}
	public Message courses(Connection conn,Message message) throws SQLException{
		String sql = "SELECT cou_id,cou_classroom,cou_week,cou_sub_id,cou_tea_id,cou_gra_id,cou_maj_id,cou_cp_id,cou_year_term,subject_name,subject_time,"+
				"teacher.teacher_name,grade.grade_year,grade.grade_term,major.major_name,courseposition.cp_position"+
				" FROM course ,subject ,teacher ,grade ,major ,courseposition"+
				" WHERE cou_sub_id = subject_id AND cou_tea_id = teacher_id AND cou_gra_id = grade_id AND cou_cp_id = cp_id AND cou_maj_id = major_id";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Course> courses = new ArrayList<Course>();
		Message message2 = new Message();
		Collage collage = new Collage();
		collage.setCollageName(message.getCollage().getCollageName());
		Grade grade = new Grade();
		grade.setGradeYear(message.getGrade().getGradeYear());
		String yearTerm = message.getCourse().getCouYearTerm();
		String grade2 = message.getGrade().getGradeYear();
		while(rs.next()){
			Course course = new Course();
			if(yearTerm.equals(rs.getString("course.cou_year_term")) && grade2.equals(rs.getString("grade.grade_year"))){
				course.setCouClassroom(rs.getString("course.cou_classroom")+"teacher:"+rs.getString("teacher.teacher_name"));
				course.setCouWeek(rs.getString("course.cou_week"));
				course.setCouYearTerm(rs.getString("subject_name"));
				course.setCouCpId(rs.getInt("cou_cp_id"));
				courses.add(course);
			}
		}
		message2.setCollage(collage);
		message2.setGrade(grade);
		message2.setCourses(courses);
		message2.setStudent(message.getStudent());
		message2.setNotices(message.getNotices());
		return message2;
	}
	public int udStudentDate(Connection conn,Message message) throws SQLException{
		String sql = "update student set student_password = ? where student_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, message.getStudent().getStudentPassword());
		pstmt.setInt(2, message.getStudent().getStudentId());
		int record = pstmt.executeUpdate();
		return record;
	} 
} 
