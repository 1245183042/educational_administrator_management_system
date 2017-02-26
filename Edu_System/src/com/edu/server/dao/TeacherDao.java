package com.edu.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.edu.bean.Comment;
import com.edu.bean.Course;
import com.edu.bean.Grade;
import com.edu.bean.Major;
import com.edu.bean.Score;
import com.edu.bean.Subject;
import com.edu.bean.Teacher;


public class TeacherDao {
   public Vector<String[]> queryTeacherCourse(Connection conn,Course course) throws SQLException{
	  Vector<String[]> vector=new Vector<String[]>();
	   PreparedStatement pstmt = conn
		.prepareStatement("select * from Course,subject,teacher,grade,major," +
				"courseposition where course.cou_tea_id=? " +
				"and course.cou_gra_id=? and course.cou_maj_id=?");
	   pstmt.setInt(1,course.getCouTeaId());
	   pstmt.setInt(2,course.getCouGraId());
	   pstmt.setInt(3,course.getCouMajId());
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
   
   public boolean teacherWriterScore(Connection conn,Vector<Score> vector) throws SQLException{
	   boolean result=true;
	   if(vector==null)
		   result=false;
	   PreparedStatement pstmt=null;
	   Score score=new Score();
	   for(int i=0;i<vector.size();i++){
		   score=vector.get(i);
	   pstmt=conn.prepareStatement("insert into score(sco_id,sco_score," +
  		"sco_stu_id,sco_sub_id,sco_tea_id,sco_time) values(?,?,?,?,?)");
	   pstmt.setDouble(1,score.getScoScore());
	   pstmt.setInt(2,score.getScoStuId());
	   pstmt.setInt(3,score.getScoSubId());
	   pstmt.setInt(4,score.getScoTeaId());
	   pstmt.setString(5,score.getScoTime());
	   pstmt.executeUpdate();
	   }
	return result;
	   
   }
   public ArrayList<String> teacherComment(Connection conn,ArrayList arrayList) throws SQLException{
	   //Comment comment=new Comment();
	   ArrayList<String> com_levelArray=new ArrayList<String>();
	   ArrayList<String> com_commentArray=new ArrayList<String>();
	   int teacherId=Integer.parseInt(arrayList.get(0).toString());//第一个返回teacherId
	   int subjectId=Integer.parseInt(arrayList.get(1).toString());//第二个返回科目Id
	   String year_Trem=arrayList.get(2).toString();//第三个返回学年学期
	   PreparedStatement pstmt=conn.prepareStatement("select * from comment where " +
	   		"com_tea_id=? and com_sub_id=? and com_year_term=?");
	   pstmt.setInt(1,teacherId );
	   pstmt.setInt(2,subjectId);
	   pstmt.setString(3,year_Trem);
	   ResultSet rs=pstmt.executeQuery();
	   while(rs.next()){
		   com_levelArray.add(rs.getString("com_level"));
		   com_commentArray.add(rs.getString("con_comment"));
	   }
	   String[] strs;
	   int leOne = 0,leTwo= 0,leThree= 0,leFour= 0,leFive= 0,leSix= 0,leSeven= 0,leEight= 0;
	   for(int i=0;i<com_levelArray.size();i++){
		   strs=com_levelArray.get(i).split("*");
		   leOne=leOne+Integer.parseInt(strs[0]);
		   leTwo=leTwo+Integer.parseInt(strs[1]);
		   leThree=leThree+Integer.parseInt(strs[2]);
		   leFour=leFour+Integer.parseInt(strs[3]);
		   leFive=leFive+Integer.parseInt(strs[4]);
		   leSix=leSix+Integer.parseInt(strs[5]);
		   leSeven=leSeven+Integer.parseInt(strs[6]);
		   leEight=leEight+Integer.parseInt(strs[7]);
		   
	   }
	   leOne=leOne/com_levelArray.size();leTwo=leTwo/com_levelArray.size();  
	   leThree=leThree/com_levelArray.size(); leFour=leFour/com_levelArray.size(); 
	   leFive=leFive/com_levelArray.size(); leSix=leSix/com_levelArray.size();
	   leSeven=leSeven/com_levelArray.size(); leEight=leEight/com_levelArray.size();
	   
	   String str=String.valueOf(leOne)+"*"+String.valueOf(leTwo)+"*"+String.valueOf(leThree)+"*"+
	   String.valueOf(leFour)+"*"+String.valueOf(leFive)+"*"+
	   String.valueOf(leSix)+"*"+String.valueOf(leSeven)+"*"+String.valueOf(leEight);
	   com_commentArray.add(str);
	   return com_commentArray;/*
	                                                                      返回评价信息和评分，第size()-1都是评价信息，第size()是评分等级，
	                                                                      是一个String，通过“*”拆分
	                            */
   }
   
   public boolean modifyTeacherPassword(Connection conn,Teacher teacher) throws SQLException{
	   boolean result=false;
	   if(teacher!=null){
	   PreparedStatement pstmt=conn.prepareStatement("update teacher set teacher_password=? where teacher_id=?");
	   pstmt.setString(1,teacher.getTeacherPassword());
	   pstmt.setInt(2, teacher.getTeacherId());
	   result=true;
	   }
	return result;
	   
   }
}
