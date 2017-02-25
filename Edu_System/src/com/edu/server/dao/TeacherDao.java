package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.bean.Teacher;
import com.edu.bean.User;

public class TeacherDao {
   public Teacher queryTeacherInformation(Connection conn,User user) throws SQLException{
	   PreparedStatement pstmt = conn
		.prepareStatement("select * from teacher where teacher_name = ?");
	   pstmt.setInt(1, user.getUserId());
	   ResultSet rs = pstmt.executeQuery();
	   Teacher teacher=new Teacher();
//	   while(rs.next()){
//		   teacher.setu
//	   }
	return teacher;
	   
   }
}
