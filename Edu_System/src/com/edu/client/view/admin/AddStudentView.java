package com.edu.client.view.admin;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.edu.util.RandomUtil;

public class AddStudentView {
	private JPanel addStudentPanel;
	
	public void init(){
		//装年级的的数组
		String[] grades = new String[]{
			"2013级","2014级","2015级","2016级"	
		};
		String[] classs = new String[]{
				"1班","2班"
			};
		
		JFrame addNoticeFrame = new JFrame("测试窗口");
		
		addStudentPanel = new JPanel();
		addStudentPanel.setPreferredSize(new Dimension(1136, 620));
		addStudentPanel.setLayout(null);
		
		JLabel topLabel = new JLabel("学生管理");
		topLabel.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JLabel tipLabel = new JLabel(">>>   添加学生");
		tipLabel.setBounds(268,55,100,20);
		JLabel idLabel = new JLabel("学号:");
		idLabel.setBounds(400,110,30,20);
		JLabel studentIdLabel = new JLabel(RandomUtil.getRandom());
		studentIdLabel.setBounds(450, 110, 100, 20);
		JButton getRandom = new JButton("随机");
		getRandom.setBounds(570, 110, 60, 20);
		JLabel studentNameLabel = new JLabel("姓名:");
		studentNameLabel.setBounds(400,150,30,20);
		JTextField studentNameField = new JTextField();
		studentNameField.setBounds(450,150,100,20);
		JLabel studentPasswordLabel = new JLabel("初始密码:");
		studentPasswordLabel.setBounds(370,190,60,20);
		JTextField studentPasswordField = new JTextField("123456");
		studentPasswordField.setBounds(450,190,100,20);
		studentPasswordField.setEditable(false);
		JLabel studentGenderLabel = new JLabel("性别:");
		studentGenderLabel.setBounds(400,230,30,20);
		JTextField studentGenderField = new JTextField();
		studentGenderField.setBounds(450,230,100,20);
		JLabel studentRaceLabel = new JLabel("民族:");
		studentRaceLabel.setBounds(400,270,30,20);
		JTextField studentRaceField = new JTextField();
		studentRaceField.setBounds(450,270,100,20);
		JLabel studentPhoneLabel = new JLabel("电话:");
		studentPhoneLabel.setBounds(400,310,30,20);
		JTextField studentPhoneField = new JTextField();
		studentPhoneField.setBounds(450,310,100,20);
		JLabel studentDormitoryLabel = new JLabel("宿舍地址:");
		studentDormitoryLabel.setBounds(370,350,60,20);
		JTextField studentDormitoryField = new JTextField();
		studentDormitoryField.setBounds(450,350,100,20);
		JLabel studentGradeLabel = new JLabel("年级:");
		studentGradeLabel.setBounds(400,390,30,20);
		JComboBox<String> studentGradeBox = new JComboBox<String>(grades);
		studentGradeBox.setBounds(450, 390, 170, 20);
		JLabel studentMajorLabel = new JLabel("专业:");
		studentMajorLabel.setBounds(400,430,30,20);
		JTextField studentMajorField = new JTextField();
		studentMajorField.setBounds(450,430,170,20);
		JLabel studentClassLabel = new JLabel("班级:");
		studentClassLabel.setBounds(690,430,30,20);
		JComboBox<String> studentClassBox = new JComboBox<String>(classs);
		studentClassBox.setBounds(740, 430, 60, 20);
		JLabel studentAddressLabel = new JLabel("家庭住址:");
		studentAddressLabel.setBounds(370,470,60,20);
		JTextField studentAddressField = new JTextField();
		studentAddressField.setBounds(450,470,600,20);
		JButton confirmButton = new JButton("确认添加");
		confirmButton.setBounds(950, 510, 90, 20);
		addStudentPanel.add(topLabel);
		addStudentPanel.add(lineLabel);
		addStudentPanel.add(tipLabel);
		addStudentPanel.add(idLabel);
		addStudentPanel.add(studentIdLabel);
		addStudentPanel.add(getRandom);
		addStudentPanel.add(studentNameLabel);
		addStudentPanel.add(studentNameField);
		addStudentPanel.add(studentPasswordLabel);
		addStudentPanel.add(studentPasswordField);
		addStudentPanel.add(studentGenderLabel);
		addStudentPanel.add(studentGenderField);
		addStudentPanel.add(studentRaceLabel);
		addStudentPanel.add(studentRaceField);
		addStudentPanel.add(studentPhoneLabel);
		addStudentPanel.add(studentPhoneField);
		addStudentPanel.add(studentDormitoryLabel);
		addStudentPanel.add(studentDormitoryField);
		addStudentPanel.add(studentGradeLabel);
		addStudentPanel.add(studentGradeBox);
		addStudentPanel.add(studentMajorLabel);
		addStudentPanel.add(studentMajorField);
		addStudentPanel.add(studentClassLabel);
		addStudentPanel.add(studentClassBox);
		addStudentPanel.add(studentAddressLabel);
		addStudentPanel.add(studentAddressField);
		addStudentPanel.add(confirmButton);
		
		
		addNoticeFrame.add(addStudentPanel);
		addNoticeFrame.pack();
		addNoticeFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AddStudentView().init();
	}
}
