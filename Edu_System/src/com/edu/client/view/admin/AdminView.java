package com.edu.client.view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import com.edu.bean.CurrentPage;
import com.edu.util.DateUtil;

public class AdminView {
	private JFrame adminFrame;
	private JPanel upPanel;// 装标题、在线人数、日期、学期、导航按钮的面板。
	private JTabbedPane tabbedPane;
	private int onlineNum = 99;//在线人数
	private String term = "2016-2017学年第二学期 第一周";
	private JButton mainButton;//首页按钮
	private JButton backButton;//后退按钮
	private JButton refreshButton;//刷新按钮
	private JButton logoutButton;//注销按钮
	public static String currentPage;//判断当前页面是什么
	private JPanel noticePanel;
	public void init(){
		Font font = new Font("宋体",Font.PLAIN,12);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		adminFrame = new JFrame("管理员模块");
		adminFrame.setLayout(null);
		adminFrame.setSize(1000, 650);//620
//		adminFrame.setPreferredSize(new Dimension(1230,760));
		adminFrame.setLocationRelativeTo(null);//屏幕居中
		adminFrame.setResizable(false);

		upPanel = new JPanel();
		upPanel.setLayout(null);
		upPanel.setBounds(0, 0, 1000, 100);
		JLabel welcomeLabel = new JLabel("超级管理员，欢迎您！");
		welcomeLabel.setFont(new Font("宋体",Font.PLAIN,18));
		welcomeLabel.setBounds(10, 10, 200, 25);
		JLabel titleLabel = new JLabel("教务管理系统");
		titleLabel.setFont(new Font("微软雅黑",Font.BOLD,30));
		titleLabel.setBounds(405, 32, 200, 35);
		JLabel timeLabel = new JLabel(DateUtil.getTime());//显示当前时间
		timeLabel.setBounds(910, 5, 100, 20);
		timeLabel.setFont(font);
		JLabel onlineNumLabel = new JLabel("在线人数:"+onlineNum);//显示在线人数
		onlineNumLabel.setBounds(900, 30, 100, 20);
		onlineNumLabel.setFont(font);
		JLabel termLabel = new JLabel(term);//显示当前学期
		termLabel.setBounds(800, 55, 200, 20);
		termLabel.setFont(font);
		mainButton = new JButton("首页");
		mainButton.setBounds(753, 80, 60, 20);
		mainButton.setFont(font1);
		backButton = new JButton("后退");
		backButton.setFont(font1);
		backButton.setBounds(813, 80, 60, 20);
		refreshButton = new JButton("刷新");
		refreshButton.setFont(font1);
		refreshButton.setBounds(873, 80, 60, 20);
		logoutButton = new JButton("注销");
		logoutButton.setFont(font1);
		logoutButton.setBounds(933, 80, 60, 20);
		upPanel.add(welcomeLabel);
		upPanel.add(titleLabel);
		upPanel.add(onlineNumLabel);
		upPanel.add(timeLabel);
		upPanel.add(termLabel);
		upPanel.add(mainButton);
		upPanel.add(backButton);
		upPanel.add(refreshButton);
		upPanel.add(logoutButton);

		//创建一个Tab页面标签,标题放在左边，采用垂直滚动策略的JTabbedPane
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0,100,1000,520);
		tabbedPane.setFont(font1);
		JPanel noticePanel = AdminNoticePane.getIstance().init();
		JPanel studentPanel = AdminStudentPane.getIstance().init();
		JPanel teacherPanel = AdminTeacherPane.getIstance().init();
		JPanel scorePanel = new AdminScorePane().init();
		JPanel subjectPanel = new AdminSubjectPane().init();
		JPanel coursePanel = new AdminCoursePane().init();
		tabbedPane.addTab("公告管理", noticePanel);
		tabbedPane.addTab("学生管理", studentPanel);
		tabbedPane.addTab("教师管理", teacherPanel);
		tabbedPane.addTab("课程表管理", coursePanel);
		tabbedPane.addTab("科目信息", subjectPanel);
		tabbedPane.addTab("学生成绩", scorePanel);

		adminFrame.add(upPanel);
		adminFrame.add(tabbedPane);

		adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		adminFrame.addWindowListener(new AdminCtrl());

		adminFrame.setVisible(true);
		
		//添加监听事件
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(currentPage.equals(CurrentPage.newNotice)){
					AdminNoticePane.getIstance().getAddNoticePanel().setVisible(false);
					AdminNoticePane.getIstance().getNoticeInitPanel().setVisible(true);
				}
				if(currentPage.equals(CurrentPage.newStudent)){
					AdminStudentPane.getIstance().getAddStudentPanel().setVisible(false);
					AdminStudentPane.getIstance().getStudentInitPanel().setVisible(true);
				}
				if(currentPage.equals(CurrentPage.newTeacher)){
					AdminTeacherPane.getIstance().getAddTeacherPanel().setVisible(false);
					AdminTeacherPane.getIstance().getTeacherInitPanel().setVisible(true);
				}
			}
		});
	}

	public JPanel getNoticePanel() {
		return noticePanel;
	}

	public void setNoticePanel(JPanel noticePanel) {
		this.noticePanel = noticePanel;
	}

	public static void main(String[] args) {
		new AdminView().init();
	}
}
