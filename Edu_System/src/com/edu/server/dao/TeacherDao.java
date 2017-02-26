package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.edu.bean.Grade;
import com.edu.bean.Major;
import com.edu.bean.Subject;
import com.edu.bean.Teacher;
import com.edu.bean.User;

public class TeacherDao {
   public Vector<String[]> queryTeacherCourse(Connection conn,Teacher teacher,Grade grade,Major major) throws SQLException{
	  Vector<String[]> vector=new Vector<String[]>();
	   PreparedStatement pstmt = conn
		.prepareStatement("select * from Course,subject,teacher,grade,major," +
				"courseposition where course.cou_tea_id=? " +
				"and course.cou_gra_id=? and course.cou_maj_id=?");
	   pstmt.setInt(1,teacher.getUserId());
	   pstmt.setInt(2,grade.getGradeId());
	   pstmt.setInt(3,major.getMajorId());
	   ResultSet rs = pstmt.executeQuery();
	   while(rs.next()){
		   String[] str=new String[5];
		   str[0]=String.valueOf(rs.getInt("cp_id"));//星期几
		   str[1]=String.valueOf(rs.getInt("cp_position"));//第几节
		   str[2]=String.valueOf(rs.getInt("subject_name"));//课程名称
		   str[3]=String.valueOf(rs.getInt("cou_classroom"));//上课地点
		   str[4]=String.valueOf(rs.getInt("cou_week"));//上课周数
		   vector.add(str);
	   }
//	   while(rs.next()){
//		   teacher.setu
//	   }
	return vector;
	   
   }
   
   public boolean teacherWriterScore(Connection conn,Teacher teacher,
		                      Grade grade,Subject subject,Vector<String[]> vector) throws SQLException{
	   PreparedStatement pstmt=conn.prepareStatement("insert into score(sco_id,sco_score," +
	   		"sco_stu_id,sco_sub_id,sco_tea_id,sco_time) values(?,?,?,?,?)");
//	   pstmt.setInt(1,teacher.getUserId());
//	   pstmt.setInt(2,teacher.getUserId());
//	   pstmt.setInt(3,teacher.getUserId());
//	   pstmt.setInt(4,teacher.getUserId());
//	   pstmt.setInt(5,teacher.getUserId());
//	   pstmt.setInt(6,teacher.getUserId());
	return false;
	   
   }
}
