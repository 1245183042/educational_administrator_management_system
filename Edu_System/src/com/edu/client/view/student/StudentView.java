package com.edu.client.view.student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StudentView implements ComponentListener {
	final JFrame studentFrame = new JFrame("学生教务系统界面");
	private JPanel panel;
	private JPanel electivePanel;
	private JScrollPane noticeScrollPane;
	private JScrollPane electiveScrollPane;
	private int labelWeight = 680;
	private int labelHeight = 60;
	private int electiveNum = 19;
	private int num;
	Color bgColor = new Color(245,245,245);
	Color wordColor = new Color(234,234,234);
	public void initUI(){
		studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//窗口用户是否调整
		studentFrame.setResizable(false);
		studentFrame.setSize( 800, 600);
		//对控件施行绝对定位，必须让它不要使用任何布局方式（关键步骤）
		studentFrame.setLayout(null);
		//设置窗口相对于指定组件的位置。 如果组件当前未显示，或者 c 为 null，则此窗口将置于屏幕的中央。
		studentFrame.setLocationRelativeTo(null);
		
		Font font = new Font("宋体", Font.BOLD, 18);
		Font font2 = new Font("宋体",Font.BOLD,11);
		
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 800, 100);
		topPanel.setBackground(new Color(9,49,75));
		//时间
		JLabel dateLabel = new JLabel(dateToStrLong(new Date()));
		dateLabel.setBounds( 650,0,100, 50);
		dateLabel.setFont(font);
		dateLabel.setForeground(wordColor);
		topPanel.add(dateLabel);
		
		//系统名字
		JLabel systemLabel = new JLabel("教务管理系统");
		systemLabel.setBounds( 300,0,300, 80);
		systemLabel.setFont(new Font("楷体",Font.CENTER_BASELINE,36));
		systemLabel.setForeground(wordColor);
		topPanel.add(systemLabel);
		
		//在线人数
		int numLine = 0;
		JLabel numLabel = new JLabel("在线人数："+numLine+"人");
		numLabel.setBounds( 0,0,90, 20);
		numLabel.setFont(new Font("宋体",Font.BOLD,12));
		numLabel.setForeground(wordColor);
		topPanel.add(numLabel);
		
		//欢迎语
		String name = "贾硕";
		JLabel nameLabel = new JLabel("欢迎同学:"+name+"，使用本系统。");
		nameLabel.setBounds( 0,60,300, 40);
		nameLabel.setFont(new Font("宋体",Font.BOLD,20));
		nameLabel.setForeground(wordColor);
		topPanel.add(nameLabel);
		
		//注销按钮
		JButton logoutButton = new JButton("退出");
		logoutButton.setBounds(700,60,80,30);
		logoutButton.setFont(new Font("宋体",Font.BOLD,20));
		logoutButton.setForeground(new Color(234,32,0));
		logoutButton.setBackground(new Color(9,49,75));
		logoutButton.setBorderPainted(false);
		topPanel.add(logoutButton);
		
		studentFrame.add(topPanel);
		
		
		//创建一个tab页面的标签放在左边，采用滚动条
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 100, 800, 470);
		tabbedPane.setBackground(new Color(226,228,230));
		tabbedPane.setForeground(new Color(0,0,0));
		//公告
		noticeScrollPane = new JScrollPane();
		noticeScrollPane.setViewportView(panel());
		studentFrame.addComponentListener(this);
		
		
		
		//个人信息
		JPanel studentPanel = new JPanel();
		studentPanel.setLayout(null);
		studentPanel.setBackground(bgColor);
		
		//姓名
		String studentName = new String("贾硕哥哥");
		JLabel studentNameLabel = new JLabel("姓名:"+studentName);
		studentNameLabel.setBounds(80, 30, 200, 30);
		studentNameLabel.setFont(font);
		studentPanel.add(studentNameLabel);
		
		//性别
		String studentSex = new String("男");
		JLabel studentSexLabel = new JLabel("性别:"+studentSex);
		studentSexLabel.setBounds(300, 30, 100, 30);
		studentSexLabel.setFont(font);
		studentPanel.add(studentSexLabel);
		
		//民族
		String studentRace = new String("汉族");
		JLabel studentRaceLabel = new JLabel("民族:"+studentRace);
		studentRaceLabel.setBounds(500,30, 150, 30);
		studentRaceLabel.setFont(font);
		studentPanel.add(studentRaceLabel);
		
		//学号
		String studentId = new String("1314**********");
		JLabel studentIdLabel = new JLabel("学号:"+studentId);
		studentIdLabel.setBounds(80, 100, 200, 30);
		studentIdLabel.setFont(font);
		studentPanel.add(studentIdLabel);
		
		//手机号
		String studentPhone = new String("157********");
		JLabel studentPhoneLabel = new JLabel("手机号:"+studentPhone);
		studentPhoneLabel.setBounds(380, 100, 220, 30);
		studentPhoneLabel.setFont(font);
		studentPanel.add(studentPhoneLabel);
		
		//年级
		String studentGId = new String("2013级");
		JLabel studentGIdLabel = new JLabel("年级:"+studentGId);
		studentGIdLabel.setBounds(80, 170, 200, 30);
		studentGIdLabel.setFont(font);
		studentPanel.add(studentGIdLabel);
		
		//班级
		String studentClass = new String("13计师2班");
		JLabel studentClassLabel = new JLabel("班级:"+studentClass);
		studentClassLabel.setBounds(380, 170, 220, 30);
		studentClassLabel.setFont(font);
		studentPanel.add(studentClassLabel);
		
		//宿舍
		String studentDormitory = new String("南亭村");
		JLabel studentDormitoryLabel = new JLabel("宿舍:"+studentDormitory);
		studentDormitoryLabel.setBounds(80, 240, 200, 30);
		studentDormitoryLabel.setFont(font);
		studentPanel.add(studentDormitoryLabel);
		
		//专业
		String studentMId = new String("计算机科学与技术");
		JLabel studentMIdLabel = new JLabel("专业:"+studentMId);
		studentMIdLabel.setBounds(380, 240, 220, 30);
		studentMIdLabel.setFont(font);
		studentPanel.add(studentMIdLabel);
		
		//家庭住址
		String studentAdress = new String("广东省广州市大学城信息枢纽楼702");
		JLabel studentAdressLabel = new JLabel("家庭住址:"+studentAdress);
		studentAdressLabel.setBounds(80, 310, 420, 30);
		studentAdressLabel.setFont(font);
		//对齐方式
//		studentAdressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		studentPanel.add(studentAdressLabel);
		
		//课程表
		JPanel coursePanel = new JPanel();
		coursePanel.setLayout(null);
		coursePanel.setBackground(bgColor);
		//学年
		JLabel gradeLabel = new JLabel("学年:");
		gradeLabel.setBounds(50, 20, 50, 30);
		gradeLabel.setFont(font);
		coursePanel.add(gradeLabel);
		//学年下拉菜单
		String[] grade = new String[]{"2014级","2015级","2016级","2017级"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox gradeBox = new JComboBox(grade);
		gradeBox.setBounds(100, 20, 110, 30);
		gradeBox.setFont(font);
		coursePanel.add(gradeBox);
		//学期
		JLabel termLabel = new JLabel("学期:");
		termLabel.setBounds(300, 20, 50, 30);
		termLabel.setFont(font);
		coursePanel.add(termLabel);
		//学期下拉菜单
		String[] term = new String[]{"第一学期","第二学期"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox termBox = new JComboBox(term);
		termBox.setBounds(350, 20, 110, 30);
		termBox.setFont(font);
		coursePanel.add(termBox);
		//检索信息
		JButton searchesButton = new JButton("检索");
		searchesButton.setBounds(600, 20, 80, 30);
		searchesButton.setFont(font);
		coursePanel.add(searchesButton);
		//专业
		JLabel studentMIdLabel2 = new JLabel("专业:"+studentMId);
		studentMIdLabel2.setBounds(500, 60, 220, 30);
		studentMIdLabel2.setFont(font);
		coursePanel.add(studentMIdLabel2);
		//姓名
		JLabel studentNameLabel2 = new JLabel("姓名:"+studentName);
		studentNameLabel2.setBounds(300, 60, 200, 30);
		studentNameLabel2.setFont(font);
		coursePanel.add(studentNameLabel2);
		//学号
		JLabel studentIdLabel2 = new JLabel("学号:"+studentId);
		studentIdLabel2.setBounds(50, 60, 200, 30);
		studentIdLabel2.setFont(font);
		coursePanel.add(studentIdLabel2);
		
		JLabel morning = new JLabel("上午");
		morning.setBounds(10, 150, 50, 30);
		morning.setFont(font);
		coursePanel.add(morning);
		JLabel afternone = new JLabel("下午");
		afternone.setBounds(10, 250, 50, 30);
		afternone.setFont(font);
		coursePanel.add(afternone);
		JLabel late = new JLabel("晚上");
		late.setBounds(10, 350, 50, 30);
		late.setFont(font);
		coursePanel.add(late);
		JLabel morning1 = new JLabel("1、2节");
		morning1.setBounds(50, 125, 60, 30);
		morning1.setFont(font);
		coursePanel.add(morning1);
		JLabel afternone1 = new JLabel("5、6节");
		afternone1.setBounds(50, 225, 60, 30);
		afternone1.setFont(font);
		coursePanel.add(afternone1);
		JLabel late1 = new JLabel("9、10节");
		late1.setBounds(40, 325, 70, 30);
		late1.setFont(font);
		coursePanel.add(late1);
		JLabel morning2 = new JLabel("3、4节");
		morning2.setBounds(50, 175, 60, 30);
		morning2.setFont(font);
		coursePanel.add(morning2);
		JLabel afternone2 = new JLabel("7、8节");
		afternone2.setBounds(50, 275, 60, 30);
		afternone2.setFont(font);
		coursePanel.add(afternone2);
		JLabel late2 = new JLabel("11、12节");
		late2.setBounds(30, 375, 80, 30);
		late2.setFont(font);
		coursePanel.add(late2);
		JLabel day1 = new JLabel("星期一");
		day1.setBounds(150, 80, 80, 30);
		day1.setFont(font);
		coursePanel.add(day1);
		JLabel day2 = new JLabel("星期二");
		day2.setBounds(230, 80, 80, 30);
		day2.setFont(font);
		coursePanel.add(day2);
		JLabel day3 = new JLabel("星期三");
		day3.setBounds(310, 80, 80, 30);
		day3.setFont(font);
		coursePanel.add(day3);
		JLabel day4 = new JLabel("星期四");
		day4.setBounds(390, 80, 80, 30);
		day4.setFont(font);
		coursePanel.add(day4);
		JLabel day5 = new JLabel("星期五");
		day5.setBounds(480, 80, 80, 30);
		day5.setFont(font);
		coursePanel.add(day5);
		JLabel day6 = new JLabel("星期六");
		day6.setBounds(560, 80, 80, 30);
		day6.setFont(font);
		coursePanel.add(day6);
		JLabel day7 = new JLabel("星期日");
		day7.setBounds(640, 80, 80, 30);
		day7.setFont(font);
		coursePanel.add(day7);
		JTextArea[] courseTextArea = new JTextArea[42];
		for(int i = 0;i < 7;i++)
		{
			for(int j = 0;j < 6;j++)
			{
				//课程文本
				courseTextArea[6*i+j] = new JTextArea("课程"+(6*i+j+1)+"\n老师"
				+(6*i+j+1)+"\n教室"+(6*i+j+1));
				courseTextArea[6*i+j].setBounds(150+82*i, 115+52*j, 70, 40);
				courseTextArea[6*i+j].setFont(font2);
				courseTextArea[6*i+j].setBackground(new Color(203,227,247));
				courseTextArea[6*i+j].setEditable(false);
				coursePanel.add(courseTextArea[6*i+j]);
			}
		}
		//考试成绩
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setBackground(bgColor);
		//学年
		JLabel gradeLabel2 = new JLabel("学年:");
		gradeLabel2.setBounds(50, 20, 50, 30);
		gradeLabel2.setFont(font);
		scorePanel.add(gradeLabel2);
		//学年下拉菜单
		String[] grade2 = new String[]{"2014级","2015级","2016级","2017级"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox gradeBox2 = new JComboBox(grade2);
		gradeBox2.setBounds(100, 20, 110, 30);
		gradeBox2.setFont(font);
		scorePanel.add(gradeBox2);
		//学期
		JLabel termLabel2 = new JLabel("学期:");
		termLabel2.setBounds(300, 20, 50, 30);
		termLabel2.setFont(font);
		scorePanel.add(termLabel2);
		//学期下拉菜单
		String[] term2 = new String[]{"第一学期","第二学期"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox termBox2 = new JComboBox(term2);
		termBox2.setBounds(350, 20, 110, 30);
		termBox2.setFont(font);
		scorePanel.add(termBox2);
		//检索信息
		JButton searchesButton2 = new JButton("检索");
		searchesButton2.setBounds(600, 20, 80, 30);
		searchesButton2.setFont(font);
		scorePanel.add(searchesButton2);
		//专业
		JLabel studentMIdLabel22= new JLabel("专业:"+studentMId);
		studentMIdLabel22.setBounds(500, 60, 220, 30);
		studentMIdLabel22.setFont(font);
		scorePanel.add(studentMIdLabel22);
		//姓名
		JLabel studentNameLabel22 = new JLabel("姓名:"+studentName);
		studentNameLabel22.setBounds(300, 60, 200, 30);
		studentNameLabel22.setFont(font);
		scorePanel.add(studentNameLabel22);
		//学号
		JLabel studentIdLabel22 = new JLabel("学号:"+studentId);
		studentIdLabel22.setBounds(50, 60, 200, 30);
		studentIdLabel22.setFont(font);
		scorePanel.add(studentIdLabel22);
		
		JLabel courseLabel = new JLabel("    序号"+"              "+"课程"+"               "+"类别"+"              "+"成绩");
		courseLabel.setBounds(10, 100, 690, 30);
		courseLabel.setFont(font);
		courseLabel.setBackground(bgColor);
		scorePanel.add(courseLabel);
		String[] courseData = new String[]{"1111111111111111","22222222","33333333","111111",
				"22222222","33333333","111111","22222222","33333333"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList courseList = new JList(courseData);
		courseList.setFont(new Font("宋体",Font.BOLD,36));
		JScrollPane courseScrollPane = new JScrollPane(courseList);
		courseScrollPane.setBounds(10, 130, 690, 320);
		scorePanel.add(courseScrollPane);
		
		
		//评价老师
		JPanel commentPanel = new JPanel();
		commentPanel.setLayout(null);
		commentPanel.setBackground(bgColor);
		//教师姓名
		JLabel teacherName = new JLabel("教师姓名:");
		teacherName.setBounds(100, 10, 100, 30);
		teacherName.setFont(font);
		commentPanel.add(teacherName);
		//教师姓名下拉菜单
		String[] teacherNameString = new String[]{"嘉鹏-学士","凯豪-学士","硕硕-中科院","飞荣-学士"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox teacherNameBox = new JComboBox(teacherNameString);
		teacherNameBox.setBounds(200, 10, 200, 30);
		teacherNameBox.setFont(font);
		commentPanel.add(teacherNameBox);
		
		//课程名
		JLabel courseName = new JLabel("  课程名:");
		courseName.setBounds(400, 10, 100, 30);
		courseName.setFont(font);
		commentPanel.add(courseName);
		//课程名下拉菜单
		String[] courseNameString = new String[]{"论早恋的危害","男人怎么脱单","中国未来单身问题","电影鉴赏","java深入浅出"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox courseNameBox = new JComboBox(courseNameString);
		courseNameBox.setBounds(500, 10, 200, 30);
		courseNameBox.setFont(font);
		commentPanel.add(courseNameBox);
		
		//评价号
		JLabel commentNum = new JLabel("评价号");
		commentNum.setBounds(75, 50, 100, 30);
		commentNum.setFont(font);
		commentPanel.add(commentNum);
		//评价内容
		JLabel commentReason = new JLabel("评价内容");
		commentReason.setBounds(325, 50, 100, 30);
		commentReason.setFont(font);
		commentPanel.add(commentReason);
		//评价等级
		JLabel commentLevel = new JLabel("评价等级");
		commentLevel.setBounds(575, 50, 100, 30);
		commentLevel.setFont(font);
		commentPanel.add(commentLevel);
		
		JLabel[] commentNums = new JLabel[8];
		JTextField[] commentReasons = new JTextField[8];
		//课程名下拉菜单
		String[] commentLevelString = new String[]{"优秀","良好","及格","不及格","很差"};
		for(int i = 0;i<8;i++)
		{	
			commentNums[i] = new JLabel(String.valueOf(i+1));
			commentNums[i].setBounds(100, 100+40*i, 20, 30);
			commentNums[i].setFont(font);
			commentPanel.add(commentNums[i]);
			
			commentReasons[i] = new JTextField();
			commentReasons[i].setBounds(140, 100+40*i, 350, 30);
			commentReasons[i].setFont(font);
			commentPanel.add(commentReasons[i]);
			
			@SuppressWarnings({ "rawtypes", "unchecked" })
			JComboBox commentLevelBox = new JComboBox(commentLevelString);
			commentLevelBox.setBounds(500, 100+40*i, 200, 30);
			commentLevelBox.setFont(font);
			commentPanel.add(commentLevelBox);
		}
		JButton commentButton = new JButton("提交");
		commentButton.setBounds(500, 380, 200, 30);
		commentButton.setBackground(bgColor);
		commentPanel.add(commentButton);
		
		
		//修改密码
		JPanel updatePasswordPanel = new JPanel();
		updatePasswordPanel.setLayout(null);
		updatePasswordPanel.setBackground(bgColor);
		
		//学号(修改密码子页面)
		JLabel studentIdUPLabel = new JLabel("学号:");
		studentIdUPLabel.setBounds(250, 50, 50, 30);
		studentIdUPLabel.setFont(font);
		updatePasswordPanel.add(studentIdUPLabel);
		//学号输入框(修改密码子页面)
		JTextField studentIdUPField = new JTextField();
		studentIdUPField.setBounds(300, 50, 150, 30);
		studentIdUPField.setFont(font);
		updatePasswordPanel.add(studentIdUPField);
		
		//旧密码(修改密码子页面)
		JLabel studentPasswordLabel = new JLabel("旧密码:");
		studentPasswordLabel.setBounds(230, 120, 70, 30);
		studentPasswordLabel.setFont(font);
		updatePasswordPanel.add(studentPasswordLabel);
		//旧密码输入框(修改密码子页面)
		JTextField studentPasswordField = new JTextField();
		studentPasswordField.setBounds(300, 120, 150, 30);
		studentPasswordField.setFont(font);
		updatePasswordPanel.add(studentPasswordField);
		
		//新密码(修改密码子页面)
		JLabel studentNewPasswordLabel = new JLabel("新密码:");
		studentNewPasswordLabel.setBounds(230, 190, 70, 30);
		studentNewPasswordLabel.setFont(font);
		updatePasswordPanel.add(studentNewPasswordLabel);
		//旧密码输入框(修改密码子页面)
		JTextField studentNewPasswordField = new JTextField();
		studentNewPasswordField.setBounds(300, 190, 150, 30);
		studentNewPasswordField.setFont(font);
		updatePasswordPanel.add(studentNewPasswordField);
		
		//确认密码(修改密码子页面)
		JLabel studentSurePasswordLabel = new JLabel("确认密码:");
		studentSurePasswordLabel.setBounds(210, 260, 90, 30);
		studentSurePasswordLabel.setFont(font);
		updatePasswordPanel.add(studentSurePasswordLabel);
		//旧密码输入框(修改密码子页面)
		JTextField studentSurePasswordField = new JTextField();
		studentSurePasswordField.setBounds(300, 260, 150, 30);
		studentSurePasswordField.setFont(font);
		updatePasswordPanel.add(studentSurePasswordField);
		//提交信息
		JButton presentPasswordButton = new JButton("提交");
		presentPasswordButton.setBounds(320, 330, 80, 30);
		presentPasswordButton.setFont(font);
		updatePasswordPanel.add(presentPasswordButton);
		
		//选课
		electiveScrollPane = new JScrollPane();
		electiveScrollPane.setViewportView(electivePanel());
		studentFrame.addComponentListener(this);
		
		
		//向JTabbedPane中添加标签页面，指定了标题,组件
		tabbedPane.addTab("公告", noticeScrollPane);
		tabbedPane.addTab("个人信息", studentPanel);
		tabbedPane.addTab("课程表", coursePanel);
		tabbedPane.addTab("考试成绩", scorePanel);
		tabbedPane.addTab("评价老师", commentPanel);
		tabbedPane.addTab("修改密码", updatePasswordPanel);
		tabbedPane.addTab("选课", electiveScrollPane);
		
		studentFrame.add(tabbedPane);
		
		
		
		//为JTbbedPane添加事件监听器(可以在按事件的时候触发)
//		tabbedPane.addChangeListener(new ChangeListener()
//		{
//			public void stateChanged(ChangeEvent event)
//			{
//				if   (((JTabbedPane)event.getSource()).getSelectedIndex() == 0)   
//				{   
//		          }   
//		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 1)   
//		          {   
//		          }   
//		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 2)   
//		          {   
//		          }   
//		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 3)   
//		          {   
//		          }   
//		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 4)   
//		          {   
//		          }  
//			}
//		});
		
		
		studentFrame.setVisible(true);
	}
	//公告里面的消息
	private JPanel panel() {
		//num应该从后台取的数据，20用于测试
		this.num = 23;
		Font noticeFont = new Font("仿宋",Font.BOLD,23);
		panel = new JPanel();
		panel.setBackground(bgColor);
		JButton[] button = new JButton[num];
		for(int i = 0;i < num;i++)
		{
			button[i] = new JButton((i+1)+".公告。。。。。。。。");
			button[i].setPreferredSize(new Dimension(labelWeight,labelHeight));
			button[i].setHorizontalAlignment(SwingConstants.LEFT);
			button[i].setBackground(bgColor);
			button[i].setBorderPainted(false);
			button[i].setFont(noticeFont);
			//有后台以后换成方法
			button[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{	
					JOptionPane.showMessageDialog(studentFrame, 
							"没有内容", "错误窗口", JOptionPane.ERROR_MESSAGE);
				}
			});
			panel.add(button[i]);
		}
		return panel;
	}
	public JPanel electivePanel()
	{	
		electivePanel = new JPanel();
		electivePanel.setBackground(bgColor);
		electivePanel.setLayout(null);
		JTextArea[] electiveTextArea = new JTextArea[(8*(electiveNum+1))];
		String[] elective = new String[]{"序号","课程","学时","类别","教师","时间","地点"};
		for(int i = 0;i < (electiveNum+1);i++)
		{
			for(int j = 0;j < 8;j++)
			{	
				if(i == 0)
				{	if(j < 7){
						electiveTextArea[8*i+j] = new JTextArea("\n  "+elective[j]);
						electiveTextArea[8*i+j].setBounds(20+84*j, 10+80*i, 80, 36);
						electiveTextArea[8*i+j].setFont(new Font("宋体", Font.BOLD, 16));
						electiveTextArea[8*i+j].setLineWrap(true);// 激活自动换行功能  
						electiveTextArea[8*i+j].setWrapStyleWord(true);// 激活断行不断字功能  
						electiveTextArea[8*i+j].setBackground(new Color(152,203,250));
						electiveTextArea[8*i+j].setEditable(false);
						electivePanel.add(electiveTextArea[8*i+j]);
					}JButton electiveButton = new JButton("提交");
					electiveButton.setBounds(20+84*j, 10+80*i, 80, 36);
					electiveButton.setFont(new Font("宋体", Font.BOLD, 16));
					electivePanel.add(electiveButton);
				}else if(j < 7)
				{	switch (j) {
				case 0:
					electiveTextArea[8*i+j] = new JTextArea("\n\n     "+i);
					break;
				case 1:
					electiveTextArea[8*i+j] = new JTextArea("\n\n   "+i+"课程");
					break;
				case 2:
					electiveTextArea[8*i+j] = new JTextArea("\n\n   "+i+"学时");
					break;
				case 3:
					electiveTextArea[8*i+j] = new JTextArea("\n\n   "+i+"类别");
					break;
				case 4:
					electiveTextArea[8*i+j] = new JTextArea("\n\n   "+i+"教师");
					break;
				case 5:
					electiveTextArea[8*i+j] = new JTextArea("\n\n   "+i+"时间");
					break;
				case 6:
					electiveTextArea[8*i+j] = new JTextArea("\n\n   "+i+"地点");
					break;
				
				default:
					break;
				}
					electiveTextArea[8*i+j].setBounds(20+84*j, 10+80*i-40, 80, 76);
					electiveTextArea[8*i+j].setFont(new Font("宋体", Font.BOLD, 12));
					electiveTextArea[8*i+j].setLineWrap(true);// 激活自动换行功能  
					electiveTextArea[8*i+j].setWrapStyleWord(true);// 激活断行不断字功能  
					electiveTextArea[8*i+j].setBackground(new Color(203,227,247));
					electiveTextArea[8*i+j].setEditable(false);
					electivePanel.add(electiveTextArea[8*i+j]);
				} if((i != 0) && (j == 7)){
					JCheckBox electiveCheckBox = new JCheckBox("",false);
					electiveCheckBox.setBounds(40+84*j, 30+80*i-40, 20, 20);
					electivePanel.add(electiveCheckBox);
				}
			}
		}
		return electivePanel;
	}
	public static void main(String[] args) {
		new StudentView().initUI();
	}
	
	public static String dateToStrLong(java.util.Date dateDate) {
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		int weidth = noticeScrollPane.getWidth() - 20;
		int height = num* (labelHeight+5);
		panel.setPreferredSize(new Dimension(weidth, height));
		
		
		int weidth2 = electiveScrollPane.getWidth() - 20;
		int height2 = electiveNum* 80+55;
		electivePanel.setPreferredSize(new Dimension(weidth2, height2));
		studentFrame.repaint();
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
