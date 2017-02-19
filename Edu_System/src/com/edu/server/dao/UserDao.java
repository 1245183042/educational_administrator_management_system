package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.bean.Administrator;
import com.edu.bean.Student;
import com.edu.bean.Teacher;
import com.edu.bean.User;

public class UserDao {

	/**
	 * 查询有无该管理员
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User queryAdmin(Connection conn, User user) throws SQLException {
		PreparedStatement pstmt = conn
				.prepareStatement("select * from administrator where admin_name = ?");
		pstmt.setInt(1, user.getUserId());
		ResultSet rs = pstmt.executeQuery();
		Administrator admin = new Administrator();
		while (rs.next()) {
			admin.setUserId(rs.getInt("admin_id"));
			admin.setUserName(rs.getInt("admin_name") + "");
			admin.setUserPassword(rs.getString("admin_password"));
		}
		return admin;
	}

	/**
	 * 查询有无该学生
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User queryStudent(Connection conn, User user) throws SQLException {
		PreparedStatement pstmt = conn
				.prepareStatement("select * from student where student_id = ?");
		pstmt.setInt(1, user.getUserId());
		ResultSet rs = pstmt.executeQuery();
		Student student = new Student();
		while (rs.next()) {
			student.setUserId(rs.getInt("student_id"));
			student.setUserName(rs.getString("student_name"));
			student.setUserPassword(rs.getString("student_password"));
			student.setStudentAddress(rs.getString("student_address"));
			student.setStudentDormitory(rs.getString("student_dormitory"));
			student.setStuMajId(rs.getInt("stu_maj_id"));
			student.setStuGraId(rs.getInt("stu_gra_id"));
			student.setStuClass(rs.getInt("stu_class"));
			student.setStudentGender(rs.getString("student_sex"));
			student.setStudentRace(rs.getString("student_race"));
			student.setStudentPhone(rs.getString("student_phone"));
		}
		return student;
	}

	/**
	 * 查询有无该老师
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User queryTeacher(Connection conn, User user) throws SQLException {
		PreparedStatement pstmt = conn
				.prepareStatement("select * from teacher where teacher_id = ?");
		pstmt.setInt(1, user.getUserId());
		ResultSet rs = pstmt.executeQuery();
		Teacher teacher = new Teacher();
		while (rs.next()) {
			teacher.setUserId(rs.getInt("teacher_id"));
			teacher.setUserName(rs.getString("teacher_name"));
			teacher.setUserPassword(rs.getString("teacher_password"));
			teacher.setTeacherAddress(rs.getString("teacher_address"));
			teacher.setTeacherGender(rs.getString("teacher_gender"));
			teacher.setTeacherRace(rs.getString("teacher_race"));
			teacher.setTeacherPhone(rs.getString("teacher_phone"));
			teacher.setTeacherTitle(rs.getString("teacher_title"));
			teacher.setTeaColId(rs.getInt("tea_col_id"));
		}
		return teacher;
	}

}
