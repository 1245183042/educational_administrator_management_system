package com.edu.client.view.admin;

import java.awt.Font;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.edu.client.ctrl.AdminCtrl;

public class AdminView{
	private JFrame adminFrame;
	private JPanel upPanel;//装标题、在线人数、日期、学期、导航按钮的面板。
	private JTabbedPane tabbedPane;
	private int onlineNum = 125;//在线人数
	private String term = "2016-2017学年第二学期 第一周";
	private JButton mainButton;//首页按钮
	private JButton backButton;//后退按钮
	private JButton refreshButton;//刷新按钮
	private JButton logoutButton;//注销按钮
	private JPanel noticePanel; 

	Vector<String> noticeVector;//临时测试用
	
	public void init(){
		Font font = new Font("asd",Font.PLAIN,20);
		adminFrame = new JFrame("管理员模块");
		adminFrame.setLayout(null);
		adminFrame.setSize(1242, 760);
//		adminFrame.setPreferredSize(new Dimension(1230,760));
		adminFrame.setLocationRelativeTo(null);//屏幕居中
		
		upPanel = new JPanel();
		upPanel.setLayout(null);
		upPanel.setBounds(0, 0, 1230, 120);
		JLabel welcomeLabel = new JLabel("管理员欢迎您！");
		welcomeLabel.setBounds(0, 0, 100, 25);
		JLabel titleLabel = new JLabel("教务管理系统");
		titleLabel.setFont(new Font("系统名字体",Font.BOLD,30));
		titleLabel.setBounds(500, 50, 250, 50);
		JLabel onlineNumLabel = new JLabel("在线人数:"+onlineNum);//显示在线人数
		onlineNumLabel.setBounds(1100, 30, 100, 25);
		JLabel timeLabel = new JLabel(new Date().toString());//显示当前时间
		timeLabel.setBounds(1100, 40, 100, 25);
		JLabel termLabel = new JLabel(term);//显示当前学期
		termLabel.setBounds(1100, 50, 100, 25);
		mainButton = new JButton("首页");
		mainButton.setBounds(980, 70, 60, 25);
		backButton = new JButton("后退");
		backButton.setBounds(1040, 70, 60, 25);
		refreshButton = new JButton("刷新");
		refreshButton.setBounds(1100, 70, 60, 25);
		logoutButton = new JButton("注销");
		logoutButton.setBounds(1160, 70, 60, 25);
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
		tabbedPane.setBounds(0,120,1230,620);
		//Vector<String> noticeVector = 此处调用Client端Ctrl层的方法（返回一个Vector<String>）
		noticePanel = AdminNoticePane.getInstance().init();
		JPanel studentPanel = new AdminStudentPane().init();
		JPanel teacherPanel = new AdminTeacherPane().init();
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
		adminFrame.addWindowListener(new AdminCtrl());
		adminFrame.setVisible(true);
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

