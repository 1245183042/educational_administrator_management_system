package com.edu.client.view.admin;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddStudentPane {
	private JPanel addStudentPanel;
	private ButtonGroup genderGroup;
	
	public JPanel init(){
		//装年级的的数组
		String[] grades = new String[]{
			"2013级","2014级","2015级","2016级"	
		};
		String[] classs = new String[]{
				"1班","2班"
		};
		Font font = new Font("宋体",Font.PLAIN,14);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		
		addStudentPanel = new JPanel();
		addStudentPanel.setBounds(0, 0, 910, 520);
		addStudentPanel.setLayout(null);
		
		JLabel topLabel = new JLabel("学生管理");
		topLabel.setBounds(422, 10, 66, 20);
		topLabel.setFont(new Font("微软雅黑",Font.BOLD,16));
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
//		lineLabel.setFont(font1);
		lineLabel.setBounds(152,45,605,3);
		JLabel tipLabel = new JLabel(">>>   添加学生");
		tipLabel.setBounds(152,55,100,20);
		tipLabel.setFont(font1);
		JLabel studentNameLabel = new JLabel("姓名");
		studentNameLabel.setBounds(350,100,30,20);
		studentNameLabel.setFont(font);
		JTextField studentNameField = new JTextField();
		studentNameField.setBounds(405,100,100,20);
		studentNameField.setFont(font);
		JLabel studentPasswordLabel = new JLabel("初始密码");
		studentPasswordLabel.setBounds(322,140,60,20);
		studentPasswordLabel.setFont(font);
		JTextField studentPasswordField = new JTextField("123456");
		studentPasswordField.setBounds(405,140,100,20);
		studentPasswordField.setFont(font);
		studentPasswordField.setEditable(false);
		JLabel studentGenderLabel = new JLabel("性别");
		studentGenderLabel.setBounds(350,180,30,20);
		studentGenderLabel.setFont(font);
		JRadioButton manRadiio = new JRadioButton();
		manRadiio.setBounds(405,180,16,16);
		JLabel manLabel = new JLabel("男");
		manLabel.setBounds(426,180,16,20);
		manLabel.setFont(font);
		JRadioButton girlRadiio = new JRadioButton();
		girlRadiio.setBounds(462,180,16,16);
		JLabel girlLabel = new JLabel("女");
		girlLabel.setBounds(483,180,16,20);
		girlLabel.setFont(font);
		genderGroup = new ButtonGroup();
		genderGroup.add(manRadiio);
		genderGroup.add(girlRadiio);
		JLabel studentRaceLabel = new JLabel("民族");
		studentRaceLabel.setBounds(350,220,30,20);
		studentRaceLabel.setFont(font);
		JTextField studentRaceField = new JTextField();
		studentRaceField.setBounds(405,220,100,20);
		studentRaceField.setFont(font);
		JLabel studentPhoneLabel = new JLabel("电话");
		studentPhoneLabel.setBounds(350,260,30,20);
		studentPhoneLabel.setFont(font);
		JTextField studentPhoneField = new JTextField();
		studentPhoneField.setBounds(405,260,100,20);
		studentPhoneField.setFont(font);
		JLabel studentDormitoryLabel = new JLabel("宿舍地址");
		studentDormitoryLabel.setBounds(322,300,60,20);
		studentDormitoryLabel.setFont(font);
		JTextField studentDormitoryField = new JTextField();
		studentDormitoryField.setBounds(405,300,100,20);
		studentDormitoryField.setFont(font);
		JLabel studentGradeLabel = new JLabel("年级");
		studentGradeLabel.setBounds(350,340,30,20);
		studentGradeLabel.setFont(font);
		JComboBox<String> studentGradeBox = new JComboBox<String>(grades);
		studentGradeBox.setBounds(405, 340, 170, 20);
		studentGradeBox.setFont(font);
		JLabel studentMajorLabel = new JLabel("专业");
		studentMajorLabel.setBounds(350,380,30,20);
		studentMajorLabel.setFont(font);
		JTextField studentMajorField = new JTextField();
		studentMajorField.setBounds(405,380,170,20);
		studentMajorField.setFont(font);
		JLabel studentClassLabel = new JLabel("班级");
		studentClassLabel.setBounds(625,380,30,20);
		studentClassLabel.setFont(font);
		JComboBox<String> studentClassBox = new JComboBox<String>(classs);
		studentClassBox.setBounds(680, 380, 60, 20);
		studentClassBox.setFont(font);
		JLabel studentAddressLabel = new JLabel("家庭住址");
		studentAddressLabel.setBounds(322,420,60,20);
		studentAddressLabel.setFont(font);
		JTextField studentAddressField = new JTextField();
		studentAddressField.setBounds(405,420,400,20);
		studentAddressField.setFont(font);
		JButton confirmButton = new JButton("确认添加");
		confirmButton.setBounds(405, 460, 100, 20);
		confirmButton.setFont(font1);
		addStudentPanel.add(topLabel);
		addStudentPanel.add(lineLabel);
		addStudentPanel.add(tipLabel);
		addStudentPanel.add(studentNameLabel);
		addStudentPanel.add(studentNameField);
		addStudentPanel.add(studentPasswordLabel);
		addStudentPanel.add(studentPasswordField);
		addStudentPanel.add(studentGenderLabel);
		addStudentPanel.add(manRadiio);
		addStudentPanel.add(manLabel);
		addStudentPanel.add(girlRadiio);
		addStudentPanel.add(girlLabel);
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
		return addStudentPanel;
	}
}
