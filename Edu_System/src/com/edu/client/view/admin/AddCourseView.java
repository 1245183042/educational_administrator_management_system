package com.edu.client.view.admin;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.edu.util.RandomUtil;

public class AddCourseView {
	private JPanel addCoursePanel;
	/**
	 * 1.科目名称
	 * 2.授课老师
	 * 3.周数
	 * 4.位置	
	 * 5.地点（班级号）
	 * 6.年级
	 * 7.专业
	 */
	
	public void init(){
		String[] weeks = new String[]{
			"1周","1-2周","1-3周","1-4周","1-5周","1-6周","1-7周","1-8周","1-9周","1-10周",
			"1-11周","1-12周","1-13周","1-14周","1-15周","1-16周","1-17周","1-18周","1-19周",
			"1-20周","1-21周","1-22周","1-23周","1-24周","1-25周"	
		};
		String[] days = new String[]{
			"星期天","星期一","星期二","星期三","星期四","星期五","星期六"	
		};
		String[] sections = new String[]{
			"第一、二节","第三、四节","第五、六节","第七、八节","第九、十节"	
		};
		JFrame addCourseFrame = new JFrame("测试窗口");
		
		addCoursePanel = new JPanel();
		addCoursePanel.setPreferredSize(new Dimension(1136, 620));
		addCoursePanel.setLayout(null);
		
		JLabel topLabel = new JLabel("课程管理");
		topLabel.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JLabel tipLabel = new JLabel(">>>   添加新课程");
		tipLabel.setBounds(268,55,100,20);
		
		JLabel subjectNameLabel = new JLabel("科目名称:");
		subjectNameLabel.setBounds(370,110,60,20);
		JTextField subjectNameField = new JTextField();
		subjectNameField.setBounds(450,110,100,20);
		JLabel teacherNameLabel = new JLabel("授课老师:");
		teacherNameLabel.setBounds(370,150,60,20);
		JTextField teacherNameField = new JTextField();
		teacherNameField.setBounds(450,150,100,20);
		JLabel couWeekLabel = new JLabel("周数:");
		couWeekLabel.setBounds(400,190,30,20);
		JComboBox<String> couWeekBox = new JComboBox<String>(weeks);
		couWeekBox.setBounds(450, 190, 100, 20);
		JLabel couTimeLabel = new JLabel("上课时间:");
		couTimeLabel.setBounds(370,230,60,20);
		JComboBox<String> couDayBox = new JComboBox<String>(days);
		couDayBox.setBounds(450, 230, 100, 20);
		JComboBox<String> couSectionBox = new JComboBox<String>(sections);
		couSectionBox.setBounds(560, 230, 100, 20);
		JLabel classroomLabel = new JLabel("上课地点:");
		classroomLabel.setBounds(370,270,60,20);
		JTextField classroomField = new JTextField();
		classroomField.setBounds(450,270,100,20);
		JLabel gradeLabel = new JLabel("年级:");
		gradeLabel.setBounds(400,310,30,20);
		JTextField gradeField = new JTextField();
		gradeField.setBounds(450,310,100,20);
		JLabel majorLabel = new JLabel("专业:");
		majorLabel.setBounds(400,350,30,20);
		JTextField majorField = new JTextField();
		majorField.setBounds(450,350,100,20);
		JButton confirmButton = new JButton("确认添加");
		confirmButton.setBounds(400, 400, 150, 20);
		addCoursePanel.add(topLabel);
		addCoursePanel.add(lineLabel);
		addCoursePanel.add(tipLabel);
		addCoursePanel.add(subjectNameLabel);
		addCoursePanel.add(subjectNameField);
		addCoursePanel.add(teacherNameLabel);
		addCoursePanel.add(teacherNameField);
		addCoursePanel.add(couWeekLabel);
		addCoursePanel.add(couWeekBox);
		addCoursePanel.add(couTimeLabel);
		addCoursePanel.add(couDayBox);
		addCoursePanel.add(couSectionBox);
		addCoursePanel.add(classroomLabel);
		addCoursePanel.add(classroomField);
		addCoursePanel.add(gradeLabel);
		addCoursePanel.add(gradeField);
		addCoursePanel.add(majorLabel);
		addCoursePanel.add(majorField);
		addCoursePanel.add(confirmButton);
		
		addCourseFrame.add(addCoursePanel);
		addCourseFrame.pack();
		addCourseFrame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new AddCourseView().init();
	}
}
