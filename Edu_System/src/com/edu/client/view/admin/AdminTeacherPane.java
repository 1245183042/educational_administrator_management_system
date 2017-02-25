package com.edu.client.view.admin;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminTeacherPane {
	private JPanel teacherPanel;//放在tabbedPane的教师管理标签
	private JPanel upPanel;//条件选择面板
	private JScrollPane downScrollPane;//用来装教师信息表格的面板
	private JTable teacherInfoTable;//教师信息表格
	private JRadioButton Radio1;
	private JRadioButton Radio2;
	
	public JPanel init(){
		//装院系的数组
		String[] colleges = new String[]{
			"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
			"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
			"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
		};
		
		teacherPanel = new JPanel();
		teacherPanel.setLayout(null);
		teacherPanel.setBounds(0, 0, 1136, 620);
		
		//条件选择面板
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 1136, 150);
		upPanel.setLayout(null);
		JLabel titleLable = new JLabel("教师管理");
		titleLable.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		Radio1 = new JRadioButton();
		Radio1.setBounds(268, 55, 16, 16);
		JLabel collegeLabel = new JLabel("院系");
		collegeLabel.setBounds(300,55,30,20);
		JComboBox<String> collegeBox = new JComboBox<String>(colleges);
		collegeBox.setBounds(335,55,170,20);
		Radio2 = new JRadioButton();
		Radio2.setBounds(525, 55, 16, 16);
		JLabel teacherIdLabel = new JLabel("职工号");
		teacherIdLabel.setBounds(557, 55, 40, 20);
		JTextField teacherIdField = new JTextField();
		teacherIdField.setBounds(602, 55, 170, 20);
		JButton queryButton = new JButton("检索");
		queryButton.setBounds(835, 55, 87, 20);
		JButton addButton = new JButton("添加教师");
		addButton.setBounds(835, 90, 87, 20);
		upPanel.add(titleLable);
		upPanel.add(lineLabel);
		upPanel.add(Radio1);
		upPanel.add(collegeLabel);
		upPanel.add(collegeBox);
		upPanel.add(Radio2);
		upPanel.add(teacherIdLabel);
		upPanel.add(teacherIdField);
		upPanel.add(queryButton);
		upPanel.add(addButton);
		
		//用来装教师信息表格的面板
		teacherInfoTable = new JTable(new Object[][]{{"信息科学技术学院","1018657425","硼钢","JCheckBox","JCheckBox"}},
						new Object[]{"院系","职工号","姓名","修改信息","删除学生"});
		downScrollPane = new JScrollPane(teacherInfoTable);
		downScrollPane.setBounds(50, 150, 1000, 300);
		
		teacherPanel.add(upPanel);
		teacherPanel.add(downScrollPane);
		return teacherPanel;
	}
}
