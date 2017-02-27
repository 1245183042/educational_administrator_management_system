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
import javax.swing.table.DefaultTableModel;

import com.edu.client.ctrl.AdminCtrl;

import com.edu.bean.CurrentPage;

public class AdminStudentPane {

	private JPanel studentPanel;//放在tabbedPane的学生管理标签
	private JPanel studentInitPanel;//初始面板
	private JPanel addStudentPanel;//添加学生的面板
	private JPanel upPanel;//条件选择面板
	private JScrollPane downScrollPane;//用来装学生信息表格的面板
	private JTable sutudentInfoTable;//学生信息表格
	private JRadioButton Radio1;
	private JRadioButton Radio2;
	private JButton addStudentButton;
	
	public JPanel getAddStudentPanel(){
		return addStudentPanel;
	}
	public JPanel getStudentInitPanel(){
		return studentInitPanel;
	}
	
	/*
	 * 单例模式
	 */
	// 定义一个私有构造方法,防止用new实例化
	private AdminStudentPane(){}
	//定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	private static volatile AdminStudentPane adminStudentInstance;
	 //定义一个共有的静态方法，返回该类型实例
	public static AdminStudentPane getIstance(){
		 // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if(adminStudentInstance==null){
			//同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (AdminStudentPane.class) {
				 //未初始化，则初始instance变量
				if(adminStudentInstance==null){
					adminStudentInstance=new AdminStudentPane();
				}
			}
		}
		return adminStudentInstance;
	}
	

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
		studentPanel = new JPanel();
		studentPanel.setLayout(null);
		studentPanel.setBounds(0, 0, 910, 520);
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
		Radio1 = new JRadioButton("院系");
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
		JButton queryButton = new JButton("检索");
		queryButton.setBounds(152, 110, 60, 20);
		queryButton.setFont(font1);
		addStudentButton = new JButton("添加学生");
		addStudentButton.setBounds(756, 110, 87, 20);
		addStudentButton.setFont(font1);
		group = new ButtonGroup();
		group.add(Radio1);
		group.add(Radio2);
		DefaultTableModel model = new DefaultTableModel(new String[]{"院系","专业","年级","班级","学号","姓名","修改信息","删除学生"}, 0);
		queryButton.addActionListener(new AdminCtrl(group,idField,model,queryButton));
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
		upPanel.add(queryButton);
		upPanel.add(addStudentButton);
		
		//用来装学生信息表格的面板
		sutudentInfoTable = new JTable(model);
		downScrollPane = new JScrollPane(sutudentInfoTable);
		downScrollPane.setBounds(50, 150, 810, 300);
		
		studentInitPanel = new JPanel();
		studentInitPanel.setLayout(null);
		studentInitPanel.setBounds(0, 0, 910, 520);
		studentInitPanel.add(upPanel);
		studentInitPanel.add(downScrollPane);
		
		studentPanel.add(studentInitPanel);
		
		//监听事件
		addStudentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				studentInitPanel.setVisible(false);
				addStudentPanel = new AddStudentPane().init();
				addStudentPanel.setVisible(true);
				studentPanel.add(addStudentPanel);
				AdminView.currentPage = CurrentPage.newStudent;
			}
		});
		
		return studentPanel;
	}

}
