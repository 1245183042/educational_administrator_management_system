package com.edu.client.view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.edu.bean.CurrentPage;

public class AdminTeacherPane {
	private JPanel teacherPanel;//放在tabbedPane的教师管理标签
	private JPanel teacherInitPanel;//初始面板
	private JPanel addTeacherPanel;//添加教师的面板
	private JPanel upPanel;//条件选择面板
	private JScrollPane downScrollPane;//用来装教师信息表格的面板
	private JTable teacherInfoTable;//教师信息表格
	private JRadioButton Radio1;
	private JRadioButton Radio2;
	private JButton addTeacherButton;
	
	public JPanel getAddTeacherPanel(){
		return addTeacherPanel;
	}
	public JPanel getTeacherInitPanel(){
		return teacherInitPanel;
	}
	
	/*
	 * 单例模式
	 */
	// 定义一个私有构造方法,防止用new实例化
	private AdminTeacherPane(){}
	//定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	private static volatile AdminTeacherPane adminTeacherInstance;
	 //定义一个共有的静态方法，返回该类型实例
	public static AdminTeacherPane getIstance(){
		 // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if(adminTeacherInstance==null){
			//同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (AdminTeacherPane.class) {
				 //未初始化，则初始instance变量
				if(adminTeacherInstance==null){
					adminTeacherInstance=new AdminTeacherPane();
				}
			}
		}
		return adminTeacherInstance;
	}
	
	public JPanel init(){
		//装院系的数组
		String[] colleges = new String[]{
			"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
			"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
			"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
		};
		
		Font font = new Font("宋体",Font.PLAIN,14);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		teacherPanel = new JPanel();
		teacherPanel.setLayout(null);
		teacherPanel.setBounds(0, 0, 910, 520);
		
		//条件选择面板
		upPanel = new JPanel();
		upPanel.setBounds(0, 0, 910, 110);
		upPanel.setLayout(null);
		JLabel titleLable = new JLabel("教师管理");
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
		Radio2 = new JRadioButton();
		Radio2.setBounds(433, 55, 16, 16);
		JLabel teacherIdLabel = new JLabel("职工号");
		teacherIdLabel.setBounds(459, 55, 50, 20);
		teacherIdLabel.setFont(font);
		JTextField teacherIdField = new JTextField();
		teacherIdField.setBounds(514, 55, 170, 20);
		JButton queryButton = new JButton("检索");
		queryButton.setBounds(700, 55, 87, 20);
		queryButton.setFont(font1);
		addTeacherButton = new JButton("添加教师");
		addTeacherButton.setBounds(700, 90, 87, 20);
		addTeacherButton.setFont(font1);
		upPanel.add(titleLable);
		upPanel.add(lineLabel);
		upPanel.add(Radio1);
		upPanel.add(collegeLabel);
		upPanel.add(collegeBox);
		upPanel.add(Radio2);
		upPanel.add(teacherIdLabel);
		upPanel.add(teacherIdField);
		upPanel.add(queryButton);
		upPanel.add(addTeacherButton);
		
		//用来装教师信息表格的面板
		teacherInfoTable = new JTable(new Object[][]{{"信息科学技术学院","1018657425","硼钢","JCheckBox","JCheckBox"}},
						new Object[]{"院系","职工号","姓名","修改信息","删除学生"});
		downScrollPane = new JScrollPane(teacherInfoTable);
		downScrollPane.setBounds(50, 130, 810, 300);
		
		teacherInitPanel = new JPanel();
		teacherInitPanel.setLayout(null);
		teacherInitPanel.setBounds(0, 0, 910, 520);
		teacherInitPanel.add(upPanel);
		teacherInitPanel.add(downScrollPane);
		
		teacherPanel.add(teacherInitPanel);
		
		//监听事件
		addTeacherButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherInitPanel.setVisible(false);
				addTeacherPanel = new AddTeacherPane().init();
				addTeacherPanel.setVisible(true);
				teacherPanel.add(addTeacherPanel);
				AdminView.currentPage = CurrentPage.newTeacher;
			}
		});
		
		return teacherPanel;
	}
}
