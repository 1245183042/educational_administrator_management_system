package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Administrator;
import com.edu.bean.Collage;
import com.edu.bean.Grade;
import com.edu.bean.Major;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.Student;
import com.edu.bean.Teacher;

public class UserDao {

	/**
	 * 查询管理员
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public Message queryAdmin(Connection conn, Administrator admin)
			throws SQLException {
		PreparedStatement pstmt = conn
				.prepareStatement("select * from administrator where admin_name = ? and admin_password = ?");
		pstmt.setInt(1, Integer.parseInt(admin.getAdminName()));
		pstmt.setString(2, admin.getAdminPassword());
		ResultSet rs = pstmt.executeQuery();
		Administrator getAdmin = new Administrator();
		System.out.println(admin.getAdminPassword());
		while (rs.next()) {
			getAdmin.setAdminId(rs.getInt("admin_id"));
			getAdmin.setAdminName(rs.getInt("admin_name") + "");
			getAdmin.setAdminPassword(rs.getString("admin_password"));
		}
		Message message = new Message();
		message.setAdmin(getAdmin);
		return message;
	}

	/**
	 * 查询学生
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public Message queryStudent(Connection conn, Student student)
			throws SQLException {
		String sql = "select * , collage_name, major_name,grade_year from student,major,grade,collage where stu_maj_id = major_id and stu_gra_id = grade_id and maj_col_id = collage_id and student_id = ? and student_password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, student.getStudentId());
		pstmt.setString(2, student.getStudentPassword());
		ResultSet rs = pstmt.executeQuery();
		Student getStu = new Student();
		Collage collage = new Collage();
		Major major = new Major();
		Grade grade = new Grade();
		while (rs.next()) {
			getStu.setStudentId(rs.getInt("student_id"));
			getStu.setStudentName(rs.getString("student_name"));
			getStu.setStudentPassword(rs.getString("student_password"));
			getStu.setStudentAddress(rs.getString("student_address"));
			getStu.setStudentDormitory(rs.getString("student_dormitory"));
			getStu.setStuClass(rs.getInt("stu_class"));
			getStu.setStudentGender(rs.getString("student_sex"));
			getStu.setStudentRace(rs.getString("student_race"));
			getStu.setStudentPhone(rs.getString("student_phone"));
			collage.setCollageName(rs.getString("collage_name"));
			major.setMajorName(rs.getString("major_name"));
			grade.setGradeYear(rs.getString("grade_year"));
		}
		Message message = new Message();
		message.setStudent(getStu);
		message.setMajor(major);
		message.setCollage(collage);
		message.setGrade(grade);
		return message;
	}
	
	public void deleteStudent(Connection conn,Student student) throws SQLException{
		String sql = "delete from notice where student_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, student.getStudentId());
		int record = pstmt.executeUpdate();
		System.out.println("共" + record + "条记录执行成功！");
	} 
	
//	public void insertStudent(Connection conn,Student student) throws SQLException{
//		String sql = "insert into student(notice_title,notice_content,notice_release_time,notice_target,notice_author) values(?,?,?,?,?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, notice.getNoticeTitle());
//		pstmt.setString(2, notice.getNoticeContent());
//		pstmt.setDate(3, null);
//		pstmt.setInt(4, notice.getNoticeTarget());
//		pstmt.setString(5, notice.getNoticeAuthor());
//		int record = pstmt.executeUpdate();
//		System.out.println("共" + record + "条记录执行成功！");
//		
//	}

	/**
	 * 查询老师
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public Message queryTeacher(Connection conn, Teacher teacher)
			throws SQLException {
		String sql = "select * ,collage_name from teacher,collage where collage.collage_id = teacher_id and teacher_id = ? and teacher_password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, teacher.getTeacherId());
		pstmt.setString(2, teacher.getTeacherPassword());
		ResultSet rs = pstmt.executeQuery();
		Teacher getTea = new Teacher();
		Collage collage = new Collage();
		while (rs.next()) {
			getTea.setTeacherId(rs.getInt("teacher_id"));
			getTea.setTeacherName(rs.getString("teacher_name"));
			getTea.setTeacherPassword(rs.getString("teacher_password"));
			getTea.setTeacherAddress(rs.getString("teacher_address"));
			getTea.setTeacherGender(rs.getString("teacher_gender"));
			getTea.setTeacherRace(rs.getString("teacher_race"));
			getTea.setTeacherPhone(rs.getString("teacher_phone"));
			getTea.setTeacherTitle(rs.getString("teacher_title"));
			collage.setCollageName(rs.getString("collage_name"));
		}
		Message message = new Message();
		message.setTeacher(getTea);
		message.setCollage(collage);
		return message;
	}

	public List<Notice> queryNotice(Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("select * from notice");
		ResultSet rs = pstmt.executeQuery();
		List<Notice> notices = new ArrayList<Notice>();
		while (rs.next()) {
			Notice notice = new Notice();
			notice.setNoticeId(rs.getInt("notice_id"));
			notice.setNoticeTarget(rs.getInt("notice_target"));
			notice.setNoticeTitle(rs.getString("notice_title"));
			notice.setNoticeContent(rs.getString("notice_content"));
			notice.setNoticeAuthor(rs.getString("notice_author"));
			notice.setNoticeReleaseTime(rs.getDate("notice_release_time"));
			notices.add(notice);
		}
		return notices;
	}

	public void insertNotice(Connection conn, Notice notice)
			throws SQLException {
		String sql = "insert into notice(notice_title,notice_content,notice_release_time,notice_target,notice_author) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, notice.getNoticeTitle());
		pstmt.setString(2, notice.getNoticeContent());
		pstmt.setDate(3, null);
		pstmt.setInt(4, notice.getNoticeTarget());
		pstmt.setString(5, notice.getNoticeAuthor());
		int record = pstmt.executeUpdate();
		System.out.println("共" + record + "条记录执行成功！");
	}

	public void deleteNotice(Connection conn, Notice notice)
			throws SQLException {
		String sql = "delete from notice where notice_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, notice.getNoticeId());
		int record = pstmt.executeUpdate();
		System.out.println("共" + record + "条记录执行成功！");
	}

	public void updateNotice(Connection conn, Notice notice)
			throws SQLException {
		String sql = "update notice set notice_title = ?,notice_content = ?,notice_release_time = ?,notice_target = ?,notice_author = ? where notice_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, notice.getNoticeTitle());
		pstmt.setString(2, notice.getNoticeContent());
		pstmt.setDate(3, null);
		pstmt.setInt(4, notice.getNoticeId());
		pstmt.setString(5, notice.getNoticeAuthor());
		pstmt.setInt(6, notice.getNoticeId());
		int record = pstmt.executeUpdate();
		System.out.println("共" + record + "条记录执行成功！");
	}
	
	

}
