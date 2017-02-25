package com.edu.client.view.admin;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminCoursePane {
	private JPanel coursePanel;//放在tabbedPane的课程表管理标签
	private JPanel upPanel;//条件选择面板
	private JScrollPane downScrollPane;//用来装课程信息表格的面板
	private JTable courseInfoTable;//课程信息表格
	
	public JPanel init(){
		//学年学期数组
		String[] terms = new String[]{
			"2016-2017学年第一学期","2016-2017学年第二学期"	
		};
		coursePanel = new JPanel();
		coursePanel.setLayout(null);
		coursePanel.setBounds(0, 0, 1136, 620);
		//条件选择面板
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 1136, 150);
		upPanel.setLayout(null);
		JLabel titleLable = new JLabel("课程管理");
		titleLable.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JLabel termLabel = new JLabel("学年学期");
		termLabel.setBounds(268,55,60,20);
		JComboBox<String> termBox = new JComboBox<String>(terms);
		termBox.setBounds(333, 55, 170, 20);
		JLabel subjectLabel = new JLabel("课程");
		subjectLabel.setBounds(513,55,30,20);
		JTextField queryField = new JTextField();
		queryField.setBounds(545,55,100,20);
		JComboBox<String> subjectBox = new JComboBox<String>(terms);
		subjectBox.setBounds(647,55,170,20);
		JButton queryButton = new JButton("检索");
		queryButton.setBounds(845,55,87,20);
		JButton addButton = new JButton("添加课程");
		addButton.setBounds(845,80,87,20);
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
		downScrollPane.setBounds(50, 150, 1000, 300);
		
		coursePanel.add(upPanel);
		coursePanel.add(downScrollPane);
		return coursePanel;
	}
}
