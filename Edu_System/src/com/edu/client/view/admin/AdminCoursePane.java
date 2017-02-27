package com.edu.client.view.admin;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminCoursePane {
	private JPanel coursePanel;//放在tabbedPane的课程表管理标签
	private JPanel courseInitPanel;//初始面板
	private JPanel upPanel;//条件选择面板
	private JScrollPane downScrollPane;//用来装课程信息表格的面板
	private JTable courseInfoTable;//课程信息表格
	
	public JPanel init(){
		//学年学期数组
		String[] terms = new String[]{
			"2016-2017学年第一学期","2016-2017学年第二学期"	
		};
		Font font = new Font("宋体",Font.PLAIN,14);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		
		coursePanel = new JPanel();
		coursePanel.setLayout(null);
		coursePanel.setBounds(0, 0, 910, 520);
		//条件选择面板
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 910, 110);
		upPanel.setLayout(null);
		JLabel titleLable = new JLabel("课程管理");
		titleLable.setBounds(422, 10, 66, 20);
		titleLable.setFont(new Font("微软雅黑",Font.BOLD,16));
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
//		lineLabel.setFont(font1);
		lineLabel.setBounds(152,45,605,3);
		JLabel termLabel = new JLabel("学年学期");
		termLabel.setBounds(152,55,60,20);
		termLabel.setFont(font);
		JComboBox<String> termBox = new JComboBox<String>(terms);
		termBox.setBounds(217, 55, 180, 20);
		termBox.setFont(font);
		JLabel subjectLabel = new JLabel("课程");
		subjectLabel.setBounds(402,55,30,20);
		subjectLabel.setFont(font);
		JTextField queryField = new JTextField();
		queryField.setBounds(437,55,100,20);
		JComboBox<String> subjectBox = new JComboBox<String>(terms);
		subjectBox.setBounds(540,55,170,20);
		subjectBox.setFont(font);
		JButton queryButton = new JButton("检索");
		queryButton.setBounds(740,55,87,20);
		queryButton.setFont(font1);
		JButton addButton = new JButton("添加课程");
		addButton.setBounds(740,90,87,20);
		addButton.setFont(font1);
		
		upPanel.add(titleLable);
		upPanel.add(lineLabel);
		upPanel.add(termLabel);
		upPanel.add(termBox);
		upPanel.add(subjectLabel);
		upPanel.add(queryField);
		upPanel.add(subjectBox);
		upPanel.add(queryButton);
		upPanel.add(addButton);
		
		//用来装课程信息表格的面板
		courseInfoTable = new JTable(new Object[][]{{"256400","网络工程导论","增可汗","网络1班","科技楼-203","1-18周,3-4节","JCheckBox","JCheckBox"}},
				new Object[]{"课程ID","科目名称","主讲教师","授课对象","上课地点","上课时间","修改","删除"});
		downScrollPane = new JScrollPane(courseInfoTable);
		downScrollPane.setBounds(50, 130, 810, 300);
		
		courseInitPanel = new JPanel();
		courseInitPanel.setLayout(null);
		courseInitPanel.setBounds(0, 0, 910, 520);
		courseInitPanel.add(upPanel);
		courseInitPanel.add(downScrollPane);
		
		coursePanel.add(courseInitPanel);
		return coursePanel;
	}
}
