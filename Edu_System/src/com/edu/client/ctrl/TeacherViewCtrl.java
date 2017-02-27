package com.edu.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TeacherViewCtrl implements ActionListener{
	   JFrame teacherFrame;
	   JTabbedPane teacherTabbedPane;
	   
	   JPanel teacherInformationPanel,teacherCoursePanel,
	            teacherTestResultsPanel,teacherCommentPanel,
	            modifyPasswordPanel;
	   
	   /*
	    * 个人信息组件
	    */
	   JButton teacherReviseButton,teacherSureButton;
	   
	   /*
	    * 教师课程表组件
	    */
	   JComboBox teacherCourseGradeJCBox,teacherCourseMajorJCBox;
	   JTextArea[][] teacherCourseTabels=new JTextArea[5][9];
	   JButton teacherCourseQueryButton;
	   
	//   TextField teacherNumberText,teacherNameText,
//	               teacherPhoneText,teacherAddressText,teacherPositionText,teacherCollegeText;
	   /*
	    * 教师公布考试成绩表的组件
	    */
	   JTextField teacherTestResultTeacherName;//教师名称文本框
	   JComboBox teacherTestResultYearJC,teacherTestResultTermJC,teacherTestResultCourseNameJC,
	                teacherTestResultCourseCharacterJC;//依次是学年、学期、课程名称、课程性质JComboBox;
	   DefaultTableModel teacherTestResultDefaultTable; //教师View中的学生成绩表 
	   JButton teacherTestResultSubmitButton;//提交按钮
	   
	   /*
	    * 添加教师评价的各个组件
	    */
	   JComboBox teacherCommentYearJCBox,teacherCommentTermJCBox,teacherCommentCourseNameJCBox;
	   JTextField teacherCommentStatisticsText,teacherCommentLevelText,
	                  teacherCommentForTeacherText,teacherCommentGradeTermText;
	   DefaultTableModel teacherCommentItmizeStatisticsDefaultTable,teacherCommentInformationDefaultTable;
	   /*
	    * 添加修改密码的各个组件(modifyPasswordPanel)
	    */
	   JTextField modifyPasswordUserNameText,modifyPasswordUserIdText,
	   modifyPasswordOldPasswordText,modifyPasswordNewPasswordText,modifyPasswordEnsureNewPasswordText;
	   JButton modifyPasswordEnsureButton;
	   public TeacherViewCtrl(){
		   
	   }
       public TeacherViewCtrl(JButton teacherCourseQueryButton,JFrame teacherFrame,JTabbedPane teacherTabbedPane,
	   JPanel teacherInformationPanel,JPanel teacherCoursePanel,JPanel teacherTestResultsPanel,
	   JPanel teacherCommentPanel,JPanel modifyPasswordPanel,
	   JButton teacherReviseButton,JButton teacherSureButton,
	   JComboBox teacherCourseGradeJCBox,JComboBox teacherCourseMajorJCBox,
	   JTextArea[][] teacherCourseTabels,
	   JTextField teacherTestResultTeacherName,
	   JComboBox teacherTestResultYearJC,JComboBox teacherTestResultTermJC,JComboBox teacherTestResultCourseNameJC,
	   JComboBox teacherTestResultCourseCharacterJC,
	   DefaultTableModel teacherTestResultDefaultTable,
	   JButton teacherTestResultSubmitButton,
	   JComboBox teacherCommentYearJCBox,JComboBox teacherCommentTermJCBox,JComboBox teacherCommentCourseNameJCBox,
	   JTextField teacherCommentStatisticsText,JTextField teacherCommentLevelText,
	   JTextField teacherCommentForTeacherText,JTextField teacherCommentGradeTermText,
	   DefaultTableModel teacherCommentItmizeStatisticsDefaultTable,DefaultTableModel teacherCommentInformationDefaultTable,
	   JTextField modifyPasswordUserNameText,JTextField modifyPasswordUserIdText,
	   JTextField modifyPasswordOldPasswordText,JTextField modifyPasswordNewPasswordText,JTextField modifyPasswordEnsureNewPasswordText,
	   JButton modifyPasswordEnsureButton){
		   this.teacherFrame=teacherFrame;this.teacherTabbedPane=teacherTabbedPane;
		   this.teacherInformationPanel=teacherInformationPanel;this.teacherCoursePanel=teacherCoursePanel;
		   this.teacherTestResultsPanel=teacherTestResultsPanel;this.teacherCommentPanel=teacherCommentPanel;
	       this.modifyPasswordPanel=modifyPasswordPanel;this.teacherReviseButton=teacherReviseButton;
	       this.teacherSureButton=teacherSureButton;this.teacherCourseGradeJCBox=teacherCourseGradeJCBox;
	       this.teacherCourseMajorJCBox=teacherCourseMajorJCBox;this.teacherCourseTabels=teacherCourseTabels;
           this.teacherTestResultTeacherName=teacherTestResultTeacherName;this.teacherTestResultYearJC=teacherTestResultYearJC;
           this.teacherTestResultTermJC=teacherTestResultTermJC;this.teacherTestResultCourseNameJC=teacherTestResultCourseNameJC;
           this.teacherTestResultCourseCharacterJC=teacherTestResultCourseCharacterJC;
           this.teacherTestResultDefaultTable=teacherTestResultDefaultTable;
           this.teacherTestResultSubmitButton=teacherTestResultSubmitButton;this.teacherCommentYearJCBox=teacherCommentYearJCBox;
           this.teacherCommentTermJCBox=teacherCommentTermJCBox;this.teacherCommentCourseNameJCBox=teacherCommentCourseNameJCBox;
           this.teacherCommentForTeacherText=teacherCommentForTeacherText;this.teacherCommentGradeTermText=teacherCommentGradeTermText;
           this.teacherCommentStatisticsText=teacherCommentStatisticsText;this.teacherCommentLevelText=teacherCommentLevelText;
           this.teacherCommentItmizeStatisticsDefaultTable=teacherCommentItmizeStatisticsDefaultTable;
           this.teacherCommentInformationDefaultTable=teacherCommentInformationDefaultTable;
           this.modifyPasswordUserNameText=modifyPasswordUserNameText;this.modifyPasswordUserIdText=modifyPasswordUserIdText;
           this.modifyPasswordOldPasswordText=modifyPasswordOldPasswordText;this.modifyPasswordNewPasswordText=modifyPasswordNewPasswordText;
           this.modifyPasswordEnsureNewPasswordText=modifyPasswordEnsureNewPasswordText;
           this.modifyPasswordEnsureButton=modifyPasswordEnsureButton;
           this.teacherCourseQueryButton=teacherCourseQueryButton;
       }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
