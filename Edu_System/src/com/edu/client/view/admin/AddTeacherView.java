package com.edu.client.view.admin;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.edu.util.RandomUtil;

public class AddTeacherView {
	private JPanel addTeacherPanel;
	
	public void init(){
		//装院系的数组
		String[] colleges = new String[]{
			"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
			"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
			"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
		};
		
		JFrame addNoticeFrame = new JFrame("测试窗口");
		
		addTeacherPanel = new JPanel();
		addTeacherPanel.setPreferredSize(new Dimension(1136, 620));
		addTeacherPanel.setLayout(null);
		
		JLabel topLabel = new JLabel("教师管理");
		topLabel.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JLabel tipLabel = new JLabel(">>>   添加教师");
		tipLabel.setBounds(268,55,100,20);
		JLabel idLabel = new JLabel("编号:");
		idLabel.setBounds(400,110,30,20);
		JLabel teacherIdLabel = new JLabel(RandomUtil.getRandom());
		teacherIdLabel.setBounds(450, 110, 100, 20);
		JButton getRandom = new JButton("随机");
		getRandom.setBounds(570, 110, 60, 20);
		JLabel teacherNameLabel = new JLabel("姓名:");
		teacherNameLabel.setBounds(400,150,30,20);
		JTextField tercherNameField = new JTextField();
		tercherNameField.setBounds(450,150,100,20);
		JLabel teacherPasswordLabel = new JLabel("初始密码:");
		teacherPasswordLabel.setBounds(370,190,60,20);
		JTextField tercherPasswordField = new JTextField("123456");
		tercherPasswordField.setBounds(450,190,100,20);
		tercherPasswordField.setEditable(false);
		JLabel teacherGenderLabel = new JLabel("性别:");
		teacherGenderLabel.setBounds(400,230,30,20);
		JTextField tercherGenderField = new JTextField();
		tercherGenderField.setBounds(450,230,100,20);
		JLabel teacherRaceLabel = new JLabel("民族:");
		teacherRaceLabel.setBounds(400,270,30,20);
		JTextField tercherRaceField = new JTextField();
		tercherRaceField.setBounds(450,270,100,20);
		JLabel teacherPhoneLabel = new JLabel("电话:");
		teacherPhoneLabel.setBounds(400,310,30,20);
		JTextField tercherPhoneField = new JTextField();
		tercherPhoneField.setBounds(450,310,100,20);
		JLabel teacherTitleLabel = new JLabel("职称:");
		teacherTitleLabel.setBounds(400,350,30,20);
		JTextField tercherTitleField = new JTextField();
		tercherTitleField.setBounds(450,350,100,20);
		JLabel teacherCollegeLabel = new JLabel("所属学院:");
		teacherCollegeLabel.setBounds(370,390,60,20);
		JComboBox<String> teacherCollegeBox = new JComboBox<String>(colleges);
		teacherCollegeBox.setBounds(450, 390, 170, 20);
		JLabel teacherAddressLabel = new JLabel("家庭住址:");
		teacherAddressLabel.setBounds(370,430,60,20);
		JTextField tercherAddressField = new JTextField();
		tercherAddressField.setBounds(450,430,600,20);
		JButton confirmButton = new JButton("确认添加");
		confirmButton.setBounds(950, 520, 90, 20);
		addTeacherPanel.add(topLabel);
		addTeacherPanel.add(lineLabel);
		addTeacherPanel.add(tipLabel);
		addTeacherPanel.add(idLabel);
		addTeacherPanel.add(teacherIdLabel);
		addTeacherPanel.add(getRandom);
		addTeacherPanel.add(teacherNameLabel);
		addTeacherPanel.add(tercherNameField);
		addTeacherPanel.add(teacherPasswordLabel);
		addTeacherPanel.add(tercherPasswordField);
		addTeacherPanel.add(teacherGenderLabel);
		addTeacherPanel.add(tercherGenderField);
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
		
		
		addNoticeFrame.add(addTeacherPanel);
		addNoticeFrame.pack();
		addNoticeFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AddTeacherView().init();
	}
}
