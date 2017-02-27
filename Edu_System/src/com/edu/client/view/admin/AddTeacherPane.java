package com.edu.client.view.admin;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddTeacherPane {
	private JPanel addTeacherPanel;
	private ButtonGroup genderGroup;
	public JPanel init(){
		//装院系的数组
		String[] colleges = new String[]{
			"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
			"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
			"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
		};
		
		Font font = new Font("宋体",Font.PLAIN,14);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
	
		addTeacherPanel = new JPanel();
		addTeacherPanel.setBounds(0, 0, 910, 520);
		addTeacherPanel.setLayout(null);
		
		JLabel topLabel = new JLabel("教师管理");
		topLabel.setBounds(422, 10, 66, 20);
		topLabel.setFont(new Font("微软雅黑",Font.BOLD,16));
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
//		lineLabel.setFont(font1);
		lineLabel.setBounds(152,45,605,3);
		JLabel tipLabel = new JLabel(">>>   添加教师");
		tipLabel.setBounds(152,55,100,20);
		tipLabel.setFont(font1);
		JLabel teacherNameLabel = new JLabel("姓名");
		teacherNameLabel.setBounds(350,100,30,20);
		teacherNameLabel.setFont(font);
		JTextField tercherNameField = new JTextField();
		tercherNameField.setBounds(405,100,100,20);
		tercherNameField.setFont(font);
		JLabel teacherPasswordLabel = new JLabel("初始密码");
		teacherPasswordLabel.setBounds(322,140,60,20);
		teacherPasswordLabel.setFont(font);
		JTextField tercherPasswordField = new JTextField("123456");
		tercherPasswordField.setBounds(405,140,100,20);
		tercherPasswordField.setFont(font);
		tercherPasswordField.setEditable(false);
		JLabel teacherGenderLabel = new JLabel("性别");
		teacherGenderLabel.setBounds(350,180,30,20);
		teacherGenderLabel.setFont(font);
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
		JLabel teacherRaceLabel = new JLabel("民族");
		teacherRaceLabel.setBounds(350,220,30,20);
		teacherRaceLabel.setFont(font);
		JTextField tercherRaceField = new JTextField();
		tercherRaceField.setBounds(405,220,100,20);
		tercherRaceField.setFont(font);
		JLabel teacherPhoneLabel = new JLabel("电话");
		teacherPhoneLabel.setBounds(350,260,30,20);
		teacherPhoneLabel.setFont(font);
		JTextField tercherPhoneField = new JTextField();
		tercherPhoneField.setBounds(405,260,100,20);
		tercherPhoneField.setFont(font);
		JLabel teacherTitleLabel = new JLabel("职称");
		teacherTitleLabel.setBounds(350,300,30,20);
		teacherTitleLabel.setFont(font);
		JTextField tercherTitleField = new JTextField();
		tercherTitleField.setBounds(405,300,100,20);
		tercherTitleField.setFont(font);
		JLabel teacherCollegeLabel = new JLabel("所属学院");
		teacherCollegeLabel.setBounds(322,340,60,20);
		teacherCollegeLabel.setFont(font);
		JComboBox<String> teacherCollegeBox = new JComboBox<String>(colleges);
		teacherCollegeBox.setBounds(405, 340, 170, 20);
		teacherCollegeBox.setFont(font);
		JLabel teacherAddressLabel = new JLabel("家庭住址");
		teacherAddressLabel.setBounds(322,380,60,20);
		teacherAddressLabel.setFont(font);
		JTextField tercherAddressField = new JTextField();
		tercherAddressField.setBounds(405,380,400,20);
		tercherAddressField.setFont(font);
		JButton confirmButton = new JButton("确认添加");
		confirmButton.setBounds(405, 420, 100, 20);
		confirmButton.setFont(font1);
		addTeacherPanel.add(topLabel);
		addTeacherPanel.add(lineLabel);
		addTeacherPanel.add(tipLabel);
		addTeacherPanel.add(teacherNameLabel);
		addTeacherPanel.add(tercherNameField);
		addTeacherPanel.add(teacherPasswordLabel);
		addTeacherPanel.add(tercherPasswordField);
		addTeacherPanel.add(teacherGenderLabel);
		addTeacherPanel.add(manRadiio);
		addTeacherPanel.add(manLabel);
		addTeacherPanel.add(girlRadiio);
		addTeacherPanel.add(girlLabel);
		addTeacherPanel.add(teacherRaceLabel);
		addTeacherPanel.add(tercherRaceField);
		addTeacherPanel.add(teacherPhoneLabel);
		addTeacherPanel.add(tercherPhoneField);
		addTeacherPanel.add(teacherTitleLabel);
		addTeacherPanel.add(tercherTitleField);
		addTeacherPanel.add(teacherCollegeLabel);
		addTeacherPanel.add(teacherCollegeBox);
		addTeacherPanel.add(teacherAddressLabel);
		addTeacherPanel.add(tercherAddressField);
		addTeacherPanel.add(confirmButton);
		return addTeacherPanel;
	}
}
