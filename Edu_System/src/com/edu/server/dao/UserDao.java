package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.bean.Administrator;
import com.edu.bean.College;
import com.edu.bean.Grade;
import com.edu.bean.Major;
import com.edu.bean.Message;
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
	public Student queryStudent(Connection conn, User user) throws SQLException {
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
	 * 查询学生完整信息
	 * 
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public Message queryStudentAll(Connection conn, User user) throws SQLException {
		String sql = "select student_id,student_name,student_password,student_address,student_sex,student_dormitory,"
				+ "stu_class,student_race,student_phone,major_name,grade_name,collage_name from "
				+ "student,major,grade,collage where stu_maj_id = major_id and stu_gra_id = grade_id and "
				+ "maj_col_id = collage_id and student_id = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getUserId());
		ResultSet rs = pstmt.executeQuery();
		Student student = new Student();
		College college = new College();
		Major major = new Major();
		Grade grade = new Grade();
		while (rs.next()) {
			student.setUserId(rs.getInt("student_id"));
			student.setUserName(rs.getString("student_name"));
			student.setUserPassword(rs.getString("student_password"));
			student.setStudentAddress(rs.getString("student_address"));
			student.setStudentDormitory(rs.getString("student_dormitory"));
			student.setStuClass(rs.getInt("stu_class"));
			student.setStudentGender(rs.getString("student_sex"));
			student.setStudentRace(rs.getString("student_race"));
			student.setStudentPhone(rs.getString("student_phone"));
			college.setCollegeName(rs.getString("collage_name"));
			major.setMajorName(rs.getString("major_name"));
			grade.setGradeName(rs.getString("grade_name"));
		}
		Message message = new Message(student, college, grade, major);
		//System.out.println(message.getCollege().getCollegeName());
		return message;
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
