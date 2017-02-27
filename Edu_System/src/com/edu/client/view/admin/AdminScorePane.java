package com.edu.client.view.admin;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminScorePane {
	private JPanel scorePanel;//放在tabbedPane的成绩管理标签
	private JPanel scoreInitPanel;//初始面板
	private JPanel upPanel;//条件选择面板
	private JScrollPane downScrollPane;//用来装学生成绩表格的面板
	private JTable scoreTable;//学生成绩表格
	private JRadioButton Radio1;
	private JRadioButton Radio2;
	
	public JPanel init(){
		//装院系的数组
		String[] colleges = new String[]{
			"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
			"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
			"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
		};
		//装年级的的数组
		String[] grades = new String[]{
			"2013级","2014级","2015级","2016级"	
		};
		//装班级的数组
		String[] classs = new String[]{
			"1班","2班"
		};
		Font font = new Font("宋体",Font.PLAIN,14);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setBounds(0, 0, 910, 520);
		//条件选择面板
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 910, 150);
		upPanel.setLayout(null);
		JLabel titleLable = new JLabel("学生管理");
		titleLable.setBounds(422, 10, 66, 20);
		titleLable.setFont(new Font("微软雅黑",Font.BOLD,16));
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
//		lineLabel.setFont(font1);
		lineLabel.setBounds(152,45,605,3);
		Radio1 = new JRadioButton();
		Radio1.setBounds(152, 55, 16, 16);
		JLabel collegeLabel = new JLabel("院系");
		collegeLabel.setBounds(178,55,30,20);
		collegeLabel.setFont(font);
		JComboBox<String> collegeBox = new JComboBox<String>(colleges);
		collegeBox.setBounds(213,55,190,20);
		collegeBox.setFont(font);
		JLabel majorLabel = new JLabel("专业");
		majorLabel.setBounds(418, 55, 30, 20);
		majorLabel.setFont(font);
		JComboBox<String> majorBox = new JComboBox<String>(colleges);
		majorBox.setBounds(453, 55, 170, 20);
		majorBox.setFont(font);
		JLabel gradeLabel = new JLabel("年级");
		gradeLabel.setBounds(638, 55, 30, 20);
		gradeLabel.setFont(font);
		JComboBox<String> gradeBox = new JComboBox<String>(grades);
		gradeBox.setBounds(673, 55, 70, 20);
		gradeBox.setFont(font);
		JLabel classLabel = new JLabel("班级");
		classLabel.setBounds(758, 55, 30, 20);
		classLabel.setFont(font);
		JComboBox<String> classBox = new JComboBox<String>(classs);
		classBox.setBounds(793, 55, 50, 20);
		classBox.setFont(font);
		Radio2 = new JRadioButton();
		Radio2.setBounds(152, 80, 16, 16);
		JLabel idLabel = new JLabel("学号");
		idLabel.setBounds(178, 80, 30, 20);
		idLabel.setFont(font);
		JTextField idField = new JTextField();
		idField.setBounds(213,80,190,20);
		idField.setFont(font);
		JLabel schoolYearLabel = new JLabel("学年");
		schoolYearLabel.setBounds(178, 110, 30, 20);
		schoolYearLabel.setFont(font);
		JComboBox<String> schoolYearBox = new JComboBox<String>(classs);
		schoolYearBox.setBounds(213, 110, 190, 20);
		schoolYearBox.setFont(font);
		JLabel termLabel = new JLabel("学期");
		termLabel.setBounds(418, 110, 30, 20);
		termLabel.setFont(font);
		JComboBox<String> termBox = new JComboBox<String>(classs);
		termBox.setBounds(453, 110, 80, 20);
		termBox.setFont(font);
		JButton queryButton = new JButton("检索");
		queryButton.setBounds(783, 110, 60, 20);
		queryButton.setFont(font1);
		upPanel.add(titleLable);
		upPanel.add(lineLabel);
		upPanel.add(Radio1);
		upPanel.add(Radio2);
		upPanel.add(collegeLabel);
		upPanel.add(collegeBox);
		upPanel.add(majorLabel);
		upPanel.add(majorBox);
		upPanel.add(gradeLabel);
		upPanel.add(gradeBox);
		upPanel.add(classLabel);
		upPanel.add(classBox);
		upPanel.add(Radio2);
		upPanel.add(idLabel);
		upPanel.add(idField);
		upPanel.add(schoolYearLabel);
		upPanel.add(schoolYearBox);
		upPanel.add(termLabel);
		upPanel.add(schoolYearBox);
		upPanel.add(termBox);
		upPanel.add(queryButton);
		
		//用来装学生成绩表格的面板
		scoreTable = new JTable(new Object[][]{{"1314080903178","林蛋大","高等数学1","高等数学2","高等数学3","高等数学4","JCheckBox"}},
				new Object[]{"学号","姓名","科目一","科目二","科目三","科目四","修改成绩"});
		downScrollPane = new JScrollPane(scoreTable);
		downScrollPane.setBounds(50, 150, 810, 300);
		
		scoreInitPanel = new JPanel();
		scoreInitPanel.setLayout(null);
		scoreInitPanel.setBounds(0, 0, 910, 520);
		scoreInitPanel.add(upPanel);
		scoreInitPanel.add(downScrollPane);
		
		scorePanel.add(scoreInitPanel);
		return scorePanel;
	}
}
