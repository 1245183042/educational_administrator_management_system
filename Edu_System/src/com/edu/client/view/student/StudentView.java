package com.edu.client.view.student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.Student;
import com.edu.client.ctrl.StudentCtrl;

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
	private Message message;
	Color bgColor = new Color(245,245,245);
	Color wordColor = new Color(234,234,234);
	public StudentView(){
		studentFrame.setSize( 800, 600);
		//设置窗口相对于指定组件的位置。 如果组件当前未显示，或者 c 为 null，则此窗口将置于屏幕的中央。
		studentFrame.setLocationRelativeTo(null);
	}
	public void initUI(Message getMes2){
		this.message = getMes2;
		studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//窗口用户是否调整
		studentFrame.setResizable(false);
		
		//对控件施行绝对定位，必须让它不要使用任何布局方式（关键步骤）
		studentFrame.setLayout(null);
		
		
		Font font = new Font("宋体", Font.BOLD, 18);
		
		
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
		JLabel nameLabel = new JLabel("欢迎同学:"+getMes2.getStudent().getStudentName()+"，使用本系统。");
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
		JLabel studentNameLabel = new JLabel("姓名:"+getMes2.getStudent().getStudentName());
		studentNameLabel.setBounds(80, 30, 200, 30);
		studentNameLabel.setFont(font);
		studentPanel.add(studentNameLabel);
		
		//性别
		JLabel studentSexLabel = new JLabel("性别:"+getMes2.getStudent().getStudentGender());
		studentSexLabel.setBounds(300, 30, 100, 30);
		studentSexLabel.setFont(font);
		studentPanel.add(studentSexLabel);
		
		//民族
		JLabel studentRaceLabel = new JLabel("民族:"+getMes2.getStudent().getStudentRace());
		studentRaceLabel.setBounds(500,30, 150, 30);
		studentRaceLabel.setFont(font);
		studentPanel.add(studentRaceLabel);
		
		//学号
		JLabel studentIdLabel = new JLabel("学号:"+getMes2.getStudent().getStudentId());
		studentIdLabel.setBounds(80, 100, 200, 30);
		studentIdLabel.setFont(font);
		studentPanel.add(studentIdLabel);
		
		//手机号
		JLabel studentPhoneLabel = new JLabel("手机号:"+getMes2.getStudent().getStudentPhone());
		studentPhoneLabel.setBounds(380, 100, 220, 30);
		studentPhoneLabel.setFont(font);
		studentPanel.add(studentPhoneLabel);
		
		//年年
		JLabel studentGIdLabel = new JLabel("年级:"+getMes2.getGrade().getGradeYear());
		studentGIdLabel.setBounds(80, 170, 200, 30);
		studentGIdLabel.setFont(font);
		studentPanel.add(studentGIdLabel);
		
		//班年
		JLabel studentClassLabel = new JLabel("班级:"+getMes2.getStudent().getStuClass());
		studentClassLabel.setBounds(380, 170, 220, 30);
		studentClassLabel.setFont(font);
		studentPanel.add(studentClassLabel);
		
		//宿舍
		JLabel studentDormitoryLabel = new JLabel("宿舍:"+getMes2.getStudent().getStudentDormitory());
		studentDormitoryLabel.setBounds(80, 240, 200, 30);
		studentDormitoryLabel.setFont(font);
		studentPanel.add(studentDormitoryLabel);
		
		//专业
		JLabel studentMIdLabel = new JLabel("专业:"+getMes2.getCollage().getCollageName());
		studentMIdLabel.setBounds(380, 240, 220, 30);
		studentMIdLabel.setFont(font);
		studentPanel.add(studentMIdLabel);
		
		//家庭住址
		JLabel studentAdressLabel = new JLabel("家庭住址:"+getMes2.getStudent().getStudentAddress());
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
		String[] grade = new String[]{"2014年","2015年","2016年","2017年"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox<String> gradeBox = new JComboBox(grade);
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
		JComboBox<String> termBox = new JComboBox(term);
		termBox.setBounds(350, 20, 110, 30);
		termBox.setFont(font);
		coursePanel.add(termBox);
		//检索信息
		JButton searchesButton = new JButton("检索");
		searchesButton.setBounds(600, 20, 80, 30);
		searchesButton.setFont(font);
		coursePanel.add(searchesButton);
		//专业
		JLabel studentMIdLabel2 = new JLabel("专业:"+getMes2.getCollage().getCollageName());
		studentMIdLabel2.setBounds(500, 60, 220, 30);
		studentMIdLabel2.setFont(font);
		coursePanel.add(studentMIdLabel2);
		//姓名
		JLabel studentNameLabel2 = new JLabel("姓名:"+getMes2.getStudent().getStudentName());
		studentNameLabel2.setBounds(300, 60, 200, 30);
		studentNameLabel2.setFont(font);
		coursePanel.add(studentNameLabel2);
		//学号
		JLabel studentIdLabel2 = new JLabel("学号:"+getMes2.getStudent().getStudentId());
		studentIdLabel2.setBounds(50, 60, 200, 30);
		studentIdLabel2.setFont(font);
		coursePanel.add(studentIdLabel2);
		
		
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
		String[] grade2 = new String[]{"2014年","2015年","2016年","2017年"};
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
		JLabel studentMIdLabel22= new JLabel("专业:"+getMes2.getCollage().getCollageName());
		studentMIdLabel22.setBounds(500, 60, 220, 30);
		studentMIdLabel22.setFont(font);
		scorePanel.add(studentMIdLabel22);
		//姓名
		JLabel studentNameLabel22 = new JLabel("姓名:"+getMes2.getStudent().getStudentName());
		studentNameLabel22.setBounds(300, 60, 200, 30);
		studentNameLabel22.setFont(font);
		scorePanel.add(studentNameLabel22);
		//学号
		JLabel studentIdLabel22 = new JLabel("学号:"+getMes2.getStudent().getStudentId());
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
		//学年
		JLabel gradeLabel3 = new JLabel("学年:");
		gradeLabel3.setBounds(50, 20, 50, 30);
		gradeLabel3.setFont(font);
		commentPanel.add(gradeLabel3);
		//学年下拉菜单
		String[] grade3 = new String[]{"2014年","2015年","2016年","2017年"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox<String> gradeBox3 = new JComboBox(grade3);
		gradeBox3.setBounds(100, 20, 110, 30);
		gradeBox3.setFont(font);
		commentPanel.add(gradeBox3);
		//学期
		JLabel termLabel3 = new JLabel("学期:");
		termLabel3.setBounds(300, 20, 50, 30);
		termLabel3.setFont(font);
		commentPanel.add(termLabel3);
		//学期下拉菜单
		String[] term3 = new String[]{"第一学期","第二学期"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox<String> termBox3 = new JComboBox(term3);
		termBox3.setBounds(350, 20, 110, 30);
		termBox3.setFont(font);
		commentPanel.add(termBox3);
		//检索信息
		JButton searchesButton3 = new JButton("检索");
		searchesButton3.setBounds(600, 20, 80, 30);
		searchesButton3.setFont(font);
		commentPanel.add(searchesButton3);
		//专业
		JLabel studentMIdLabel222= new JLabel("专业:"+getMes2.getCollage().getCollageName());
		studentMIdLabel222.setBounds(500, 60, 220, 30);
		studentMIdLabel222.setFont(font);
		commentPanel.add(studentMIdLabel222);
		//姓名
		JLabel studentNameLabel222 = new JLabel("姓名:"+getMes2.getStudent().getStudentName());
		studentNameLabel222.setBounds(300, 60, 200, 30);
		studentNameLabel222.setFont(font);
		commentPanel.add(studentNameLabel222);
		//学号
		JLabel studentIdLabel222 = new JLabel("学号:"+getMes2.getStudent().getStudentId());
		studentIdLabel222.setBounds(50, 60, 200, 30);
		studentIdLabel222.setFont(font);
		commentPanel.add(studentIdLabel222);
		
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
		tabbedPane.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				if   (((JTabbedPane)event.getSource()).getSelectedIndex() == 0)   
				{   
		          }   
		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 1)   
		          {   
		          }   
		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 2)   
		          {   
		          }   
		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 3)   
		          {   
		          }   
		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 4)   
		          {   
		          }  
		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 5)   
		          {   
		          }   
		          else   if(((JTabbedPane)event.getSource()).getSelectedIndex() == 6)   
		          {   
		          } 
			}
		});
		
		
		studentFrame.setVisible(true);
		logoutButton.addActionListener(new StudentCtrl(logoutButton,studentFrame));
		searchesButton.addActionListener(new StudentCtrl(getMes2,searchesButton,gradeBox,termBox,StudentView.this));
		presentPasswordButton.addActionListener(new StudentCtrl(studentIdUPField,studentPasswordField,studentNewPasswordField,studentSurePasswordField,presentPasswordButton,studentFrame));
		searchesButton3.addActionListener(new StudentCtrl(searchesButton3,getMes2,gradeBox3,termBox3));
	}
	//公告里面的消息
	private JPanel panel() {
		this.num = 0;
		//num应该从后台取的数据
		for (Notice n : message.getNotices()) {
			if(n.getNoticeTarget() != 2){
			this.num ++;
			}
		}
		if(num == 0){
			return null;
		}else{
		Font noticeFont = new Font("仿宋",Font.BOLD,23);
		panel = new JPanel();
		panel.setBackground(bgColor);
		JButton[] button = new JButton[num];
		int i = 0;
		for(Notice n : message.getNotices())
		{	
			if((n.getNoticeTarget() != 2)){
			button[i] = new JButton("<"+(i+1)+">"+n.getNoticeReleaseTime()+"●"+n.getNoticeTitle());
			button[i].setPreferredSize(new Dimension(labelWeight,labelHeight));
			button[i].setHorizontalAlignment(SwingConstants.LEFT);
			button[i].setBackground(bgColor);
			button[i].setBorderPainted(false);
			button[i].setFont(noticeFont);
			//有后台以后换成方法
			button[i].addActionListener(new StudentNoticeView(i,n));
			panel.add(button[i]);
			i++;
			}
			}
		return panel;
		}
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
		Student studentTry = new Student();
		Message messageTry =  new Message();
		messageTry.setStudent(studentTry);
		new StudentView().initUI(messageTry);
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
		int height = num* (labelHeight+5)+5;
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
