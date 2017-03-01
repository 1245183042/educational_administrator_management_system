package com.edu.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.edu.bean.Comment;
import com.edu.bean.Course;
import com.edu.bean.Elective;
import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.OperationCode;
import com.edu.bean.Student;
import com.edu.client.model.UserModel;
import com.edu.client.view.LoginView;
import com.edu.client.view.student.StudentCommentView;
import com.edu.client.view.student.StudentCourseView;
import com.edu.client.view.student.StudentScoreView;
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
	private JButton commentButton;
	private JComboBox<String> jComboBox0;
	private JComboBox<String> jComboBox1;
	private JComboBox<String> jComboBox2;
	private JComboBox<String> jComboBox3;
	private JComboBox<String> jComboBox4;
	private JComboBox<String> jComboBox5;
	private JComboBox<String> jComboBox6;
	private JComboBox<String> jComboBox7; 
	private JTextField other2;
	private Message message2;
	private JFrame frame3;
	private Message getMes23;
	private JButton searchesButton2;
	private JComboBox<String> gradeBox2;
	private JComboBox<String> termBox2;
	private JButton electiveButton;
	private Message message;
	private JCheckBox[] checkBoxs;
	private JFrame studentFrame2;
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
	
	public StudentCtrl(JButton commentButton, JComboBox<String> jComboBox0,
			JComboBox<String> jComboBox1, JComboBox<String> jComboBox2,
			JComboBox<String> jComboBox3, JComboBox<String> jComboBox4,
			JComboBox<String> jComboBox5, JComboBox<String> jComboBox6,
			JComboBox<String> jComboBox7, JTextField other2, Message message2,
			JFrame frame3) {
		super();
		this.commentButton = commentButton;
		this.jComboBox2 = jComboBox2;
		this.jComboBox3 = jComboBox3;
		this.jComboBox4 = jComboBox4;
		this.jComboBox5 = jComboBox5;
		this.jComboBox6 = jComboBox6;
		this.jComboBox7 = jComboBox7;
		this.jComboBox0 = jComboBox0;
		this.jComboBox1 = jComboBox1;
		this.other2 = other2;
		this.message2 = message2;
		this.frame3 = frame3;
	}
	public StudentCtrl(Message getMes23, JButton searchesButton2,
			JComboBox<String> gradeBox2, JComboBox<String> termBox2) {
		this.getMes23 = getMes23;
		this.searchesButton2 = searchesButton2;
		this.gradeBox2 = gradeBox2;
		this.termBox2 = termBox2;
	}
	public StudentCtrl(JButton electiveButton, Message message,
			JCheckBox[] checkBoxs, JFrame studentFrame2) {
		this.electiveButton = electiveButton;
		this.message = message;
		this.checkBoxs = checkBoxs;
		this.studentFrame2 = studentFrame2;
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
			String operationCode = OperationCode.RETRIEVE_COURSE;
			getMes2.setIdentify(identify);
			getMes2.setOperationCode(operationCode);
			Course course = new Course();
			String yearTerm = gradeBox.getSelectedItem().toString()+termBox.getSelectedItem().toString();
			course.setCouYearTerm(yearTerm);
			getMes2.setCourse(course);
	try {
			Message getMes = userModel.query(getMes2);
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
					UserModel userModel2 = new UserModel();
					getMes = userModel2.query(message);
					if(getMes.getStudent().getStudentAddress().equals("xiugaichenggong")){
						JOptionPane.showMessageDialog(studentFrame, "修改成功", "错误信息",
								JOptionPane.INFORMATION_MESSAGE);
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
			//返回comment
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
			//comment的提交
		}else if(arg0.getSource().equals(commentButton))
		{
			String commentTeacher = jComboBox0.getSelectedItem().toString().split("-")[0]+"-"+
					jComboBox1.getSelectedItem().toString().split("-")[0]+"-"+
					jComboBox2.getSelectedItem().toString().split("-")[0]+"-"+
					jComboBox3.getSelectedItem().toString().split("-")[0]+"-"+
					jComboBox4.getSelectedItem().toString().split("-")[0]+"-"+
					jComboBox5.getSelectedItem().toString().split("-")[0]+"-"+
					jComboBox6.getSelectedItem().toString().split("-")[0]+"-"+
					jComboBox7.getSelectedItem().toString().split("-")[0];
			Comment comment = new Comment();
			comment.setComLevel(commentTeacher);
			comment.setComContent(other2.getText());
			message2.setComment(comment);
			String identify = Identify.STUDENT;
			message2.setIdentify(identify);
			String opertionCode = OperationCode.CREATE_COMMENT;
			message2.setOperationCode(opertionCode);
			try {
				UserModel userModelComment = new UserModel();
				Message messageComment = new Message();
				try {
					messageComment = userModelComment.query(message2);
					if(messageComment.getStudent().getStudentAddress().equals("pingjiachenggong")){
						JOptionPane.showMessageDialog(frame3, "评价成功", "提示信息",
								JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(frame3, "已经评价", "错误信息",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(arg0.getSource().equals(searchesButton2))
		{
			Course course = new Course();
			String courseYearTerm = gradeBox2.getSelectedItem().toString()+termBox2.getSelectedItem().toString();
			course.setCouYearTerm(courseYearTerm);
			getMes23.setCourse(course);
			String identify = Identify.STUDENT;
			getMes23.setIdentify(identify);
			String opertionCode = OperationCode.RETRIEVE_SCORE;
			getMes23.setOperationCode(opertionCode);
			try {
				UserModel courseUserModel = new UserModel();
				try {
					Message scorMessage = courseUserModel.query(getMes23);
					new StudentScoreView().InitUI(scorMessage);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(arg0.getSource().equals(electiveButton))
		{	
			String identify = Identify.STUDENT;
			message.setIdentify(identify);
			String opertionCode = OperationCode.CREATE_ELECTIVE;
			message.setOperationCode(opertionCode);
			List<Elective> electives = new ArrayList<Elective>();
			for(int i = 0 ;i < message.getElectives().size();i++)
			{	
				if(checkBoxs[i].isSelected())
				{
					electives.add(message.getElectives().get(i));
				}
			}
			message.setElectives(electives);
			try {
				UserModel electiveUM = new UserModel();
				try {
					Message electiveMessage = electiveUM.query(message);
					if(electiveMessage.getStudent().getStudentAddress().equals("xuanxiuchenggong")){
						JOptionPane.showMessageDialog(studentFrame2, "选修成功", "提示信息",
								JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(studentFrame2, "选修失败", "错误信息",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
