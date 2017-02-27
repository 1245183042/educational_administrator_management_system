package com.edu.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.edu.bean.Collage;
import com.edu.bean.Course;
import com.edu.bean.Grade;
import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.OperationCode;
import com.edu.bean.Student;
import com.edu.client.model.UserModel;
import com.edu.client.view.LoginView;
import com.edu.client.view.student.StudentCommentView;
import com.edu.client.view.student.StudentCourseView;
import com.edu.client.view.student.StudentView;


public class StudentCtrl implements ActionListener {
	private JButton logoutButton;
	private JFrame frame;
	private Message getMes2;
	private JButton searchesButton;
	private JComboBox<String> gradeBox; 
	private JComboBox<String> termBox;
	private StudentView studentView;
	private JTextField studentIdUPField;
	private JTextField studentPasswordField;
	private JTextField studentNewPasswordField;
	private JTextField studentSurePasswordField;
	private JButton presentPasswordButton;
	private JFrame studentFrame;
	private JButton searchesButton3; 
	private Message getMes22;
	private JComboBox<String> gradeBox3; 
	private JComboBox<String> termBox3;
	
	public StudentCtrl(JButton logoutButton, JFrame frame) {
		this.logoutButton = logoutButton;
		this.frame = frame;
	}
	public StudentCtrl(Message getMes2, JButton searchesButton,
			JComboBox<String> gradeBox, JComboBox<String> termBox,StudentView studentView) {
		super();
		this.getMes2 = getMes2;
		this.searchesButton = searchesButton;
		this.gradeBox = gradeBox;
		this.termBox = termBox;
		this.studentView = studentView;
	}
	public StudentCtrl(JTextField studentIdUPField,
			JTextField studentPasswordField,
			JTextField studentNewPasswordField,
			JTextField studentSurePasswordField,JButton presentPasswordButton,JFrame studentFrame) {
		super();
		this.studentIdUPField = studentIdUPField;
		this.studentPasswordField = studentPasswordField;
		this.studentNewPasswordField = studentNewPasswordField;
		this.studentSurePasswordField = studentSurePasswordField;
		this.presentPasswordButton = presentPasswordButton;
		this.studentFrame = studentFrame;
	}
	public StudentCtrl(JButton searchesButton3, Message getMes22,
			JComboBox<String> gradeBox3, JComboBox<String> termBox3) {
		super();
		this.searchesButton3 = searchesButton3;
		this.getMes22 = getMes22;
		this.gradeBox3 = gradeBox3;
		this.termBox3 = termBox3;
	}
	public void studentCtrl(){
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource().equals(logoutButton))
		{
			frame.setVisible(false);
			new LoginView().iniUI();
		}else if(arg0.getSource().equals(searchesButton))
		{	
			UserModel userModel;
	try {
				userModel = new UserModel();
			String identify = Identify.STUDENT;
			String opertionCode = OperationCode.RETRIEVE_COURSE;
			Message message = new Message(identify,opertionCode,getMes2.getStudent());
			message.setNotices(getMes2.getNotices());
			Course course = new Course();
			Collage collage = new Collage();
			collage.setCollageName(getMes2.getCollage().getCollageName());
			Grade grade = new Grade();
			grade.setGradeYear(getMes2.getGrade().getGradeYear());
			String yearTerm = gradeBox.getSelectedItem().toString()+termBox.getSelectedItem().toString();
			course.setCouYearTerm(yearTerm);
			message.setCourse(course);
			message.setGrade(grade);
			message.setCollage(collage);
	try {
			Message getMes = userModel.query(message);
			studentView.initUI(getMes);
			new StudentCourseView().InitUI(getMes);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(arg0.getSource().equals(presentPasswordButton))
		{	
			int studentIdUP = Integer.parseInt(studentIdUPField.getText().trim());
			String studentPassword = studentPasswordField.getText().trim();
			String studentNewPassword = studentNewPasswordField.getText().trim();
			String studentSurePassword = studentSurePasswordField.getText().trim();
			try {
			if(studentNewPassword.equals(studentSurePassword)){
				Student student = new Student();
				student.setStudentId(studentIdUP);
				student.setStudentPassword(studentPassword);
				String identify = Identify.STUDENT;
				String operationCode = OperationCode.LOGIN;
				Message message = new Message(identify, operationCode,
						student);
				UserModel userModel = new UserModel();
				Message getMes;
				
					getMes = userModel.query(message);
				
				Student getStu = getMes.getStudent();
				if (getStu.getStudentName() == null) {
					JOptionPane.showMessageDialog(studentFrame, "用户名或密码错误", "错误信息",
							JOptionPane.ERROR_MESSAGE);
				} else
				{	
					
					String operationCode2 = OperationCode.UPDATE_STUDENT;
					student.setStudentPassword(studentNewPassword);
					message = new Message(identify, operationCode2,
							student);
					System.out.println("1");
					UserModel userModel2 = new UserModel();
					getMes = userModel2.query(message);
					System.out.println("0");
					if(getMes.getStudent().getStudentAddress().equals("xiugaichenggong")){
						JOptionPane.showMessageDialog(studentFrame, "修改成功", "错误信息",
								JOptionPane.OK_OPTION);
					}else{
						JOptionPane.showMessageDialog(studentFrame, "修改失败", "错误信息",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}else
			{
				JOptionPane.showMessageDialog(studentFrame, "确认密码出错密码不同", "错误信息",
						JOptionPane.ERROR_MESSAGE);
			}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(arg0.getSource().equals(searchesButton3))
		{
			UserModel userModel2;
			try {
				userModel2 = new UserModel();
				String identify = Identify.STUDENT;
				String opertionCode = OperationCode.RETRIEVE_COURSE;
				getMes22.setIdentify(identify);
				getMes22.setOperationCode(opertionCode);
				Course course = new Course();
				String yearTerm = gradeBox3.getSelectedItem().toString()+termBox3.getSelectedItem().toString();
				course.setCouYearTerm(yearTerm);
				getMes22.setCourse(course);
		try {
				Message getMes = userModel2.query(getMes22);
				new StudentCommentView().InitUI(getMes);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
