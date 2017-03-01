package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Collage;
import com.edu.bean.Course;
import com.edu.bean.Elective;
import com.edu.bean.Grade;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.Score;

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
		String maj = message.getMajor().getMajorName();
		String yearTerm = message.getCourse().getCouYearTerm();
		String grade2 = message.getGrade().getGradeYear();
		while(rs.next()){
			Course course = new Course();
			if(yearTerm.equals(rs.getString("course.cou_year_term")) && grade2.equals(rs.getString("grade.grade_year")) && maj.equals(rs.getString("major.major_name"))){
				course.setCouClassroom(rs.getString("course.cou_classroom")+":"+rs.getString("teacher.teacher_name")+":"+rs.getInt("cou_sub_id")+":"+rs.getInt("cou_tea_id"));
				course.setCouWeek(rs.getString("course.cou_week"));
				course.setCouYearTerm(rs.getString("subject_name")+":"+yearTerm);
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
	public int addCommentDate(Connection conn,Message message) throws SQLException{
		int ok = 0;
		String sql2 = "SELECT com_sub_id,com_year_term FROM comment";
		PreparedStatement pstmt = conn.prepareStatement(sql2);
		ResultSet rs = pstmt.executeQuery();
		int subId = Integer.parseInt(message.getCourse().getCouClassroom().split(":")[2]);
		System.out.println(subId);
		String yearTerm = message.getCourse().getCouYearTerm().split(":")[1];
		while(rs.next()){
			if((subId == rs.getInt("com_sub_id")) && yearTerm.equals(rs.getString("com_year_term")))
			{
				ok = 1;
			}
		}
		if(ok == 0)
		{
		String sql = "insert into comment(com_stu_id,com_sub_id,com_tea_id,com_comment,com_level,com_year_term) values(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, message.getStudent().getStudentId());
		pstmt.setInt(2, subId);
		pstmt.setInt(3, Integer.parseInt(message.getCourse().getCouClassroom().split(":")[3]));
		pstmt.setString(4, message.getComment().getComContent());
		pstmt.setString(5, message.getComment().getComLevel());
		pstmt.setString(6, message.getCourse().getCouYearTerm().split(":")[1]);
		int record = pstmt.executeUpdate();
		return record;
		}
		else
		{
			return 0;
		}
	}
	public Message score(Connection conn, Message message) throws SQLException {
		String sql = "SELECT * FROM score , subject , teacher WHERE sco_sub_id = subject_id AND sco_tea_id = teacher_id ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int stuid = message.getStudent().getStudentId();
		String yearTerm = message.getCourse().getCouYearTerm();
		ResultSet rs = pstmt.executeQuery();
		List<Score> scores = new ArrayList<Score>();
		while(rs.next())
		{
			if((stuid == rs.getInt("sco_stu_id")) && (yearTerm.equals(rs.getString("sco_time"))))
			{
				Score score = new Score();
				score.setScoScore(rs.getDouble("sco_score"));
				score.setScoTime(rs.getString("subject_name")+":"+rs.getString("teacher_name"));
				scores.add(score);	
			}
		}
		message.setScores(scores);
		return message;
	}
	public Message elective(Connection conn, Message message2) throws SQLException {
		String sql = "SELECT *,courseposition.cp_position, teacher.teacher_name, subject_name FROM elective," +
				"subject , teacher , courseposition WHERE elective.ele_sub_id = subject_id AND " +
				"teacher.teacher_id = elective.ele_tea_id AND elective.ele_cp_id = courseposition.cp_id";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Elective> electives = new ArrayList<Elective>();
		while(rs.next())
		{
			String studentId = new String();
			studentId = String.valueOf(rs.getInt("ele_stu_id"));
			if(studentId.equals("0"))
			{
				Elective elective = new Elective();
				elective.setEleWeek(rs.getString("ele_week"));
				elective.setEleCpId(rs.getInt("ele_cp_id"));
				elective.setEleSubId(rs.getInt("ele_sub_id"));
				elective.setEleTeaId(rs.getInt("ele_tea_id"));
				elective.setEleClassroom(rs.getString("ele_classroom")+":"+rs.getString("teacher.teacher_name")+
						":"+rs.getString("subject_name")+":"+rs.getString("courseposition.cp_position"));
				electives.add(elective);
			}
		}
		message2.setElectives(electives);
		return message2;
	}
	public int addElectiveDate(Connection conn, Message message) throws SQLException {
		int record = 0;
		String sql = "insert into elective(ele_sub_id,ele_tea_id,ele_cp_id,ele_stu_id,ele_week,ele_classroom) values(?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		for(Elective e : message.getElectives())
		{
		pst.setInt(1, e.getEleSubId());
		pst.setInt(2, e.getEleTeaId());
		pst.setInt(3, e.getEleCpId());
		pst.setInt(4, message.getStudent().getStudentId());
		pst.setString(5, e.getEleWeek());
		pst.setString(6, e.getEleClassroom().split(":")[0]);
		record = pst.executeUpdate();
		}
		return record;
	}
} 
