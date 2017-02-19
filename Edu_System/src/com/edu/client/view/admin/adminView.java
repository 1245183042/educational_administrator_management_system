package com.edu.client.view.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.util.Date;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class adminView {
	JFrame adminFrame;
	JTabbedPane tabbedPane;
	JLabel userNameLabel ;
	String userName = "彭刚";
	JLabel titleLabel;
	JLabel onlineNumLabel;//显示在线人数
	int onlineNum = 1258232;//在线人数
	JLabel timeLabel;//显示当前时间
	JLabel termLabel;//显示当前学期
	String term = "2016-2017学年第二学期 第一周";
	JButton mainButton;//首页按钮
	JButton backButton;//后退按钮
	JButton refreshButton;//刷新按钮
	JButton logoutButton;//注销按钮
	JPanel upPanel;
	//放在tabbedPane的组件
	JScrollPane noticeScrllPane;
	JList noticeLists;//公告列表
	Vector<String> noticeVector;//装公告标题和发布时间

	
	public adminView(Vector<String> noticeVector){
		this.noticeVector = noticeVector;
	}
	
	public void init(){
		adminFrame = new JFrame("管理员模块");
		Font font = new Font("asd",Font.PLAIN,20);
		
		//创建一个面板，用来放在JSplitPane上边
		upPanel = new JPanel();
		upPanel.setPreferredSize(new Dimension(1240,130));
		upPanel.setLayout(new BorderLayout(300,30));
		titleLabel = new JLabel("教务管理系统");
		titleLabel.setFont(new Font("系统名字体",Font.BOLD,30));
		userNameLabel = new JLabel(userName+"管理员，欢迎您！");
		onlineNumLabel = new JLabel("在线人数:"+onlineNum);
		timeLabel = new JLabel(new Date().toString());
		termLabel = new JLabel(term);
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new FlowLayout());
		mainButton = new JButton("首页");
		backButton = new JButton("后退");
		refreshButton = new JButton("刷新");
		logoutButton = new JButton("注销");
		buttonPanel.add(mainButton);
		buttonPanel.add(backButton);
		buttonPanel.add(refreshButton);
		buttonPanel.add(logoutButton);
		//创建一个Panel用来存放onlineNumLabel，timeLabel，termLabel
		Panel p = new Panel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(onlineNumLabel);
		p.add(timeLabel);
		p.add(termLabel);
		p.add(buttonPanel);
		upPanel.add(titleLabel);
		upPanel.add(userNameLabel,BorderLayout.WEST);
		upPanel.add(p,BorderLayout.EAST);
		upPanel.add(new JLabel(),BorderLayout.NORTH);
		
		//创建一个Tab页面标签,标题放在左边，采用垂直滚动策略的JTabbedPane(放在JSplitPane下边)
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setPreferredSize(new Dimension(1240,520));
		
		noticeLists = new JList(noticeVector);
		noticeScrllPane = new JScrollPane(noticeLists);
		
		tabbedPane.addTab("通知公告", noticeScrllPane);
		tabbedPane.addTab("学生管理", null);
		tabbedPane.addTab("教师管理", null);
		tabbedPane.addTab("课程表管理", null);
		tabbedPane.addTab("科目信息", null);
		tabbedPane.addTab("学生成绩", null);
		
		//创建一个垂直分割面板，将upPanel放在上面，将tabbedPane放在下面，支持连续布局。
		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,upPanel,tabbedPane);
		sp.setDividerSize(1);
		
		adminFrame.add(sp);
		adminFrame.pack();
		adminFrame.setLocationRelativeTo(null);
		adminFrame.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		Vector<String> noticeVector = new Vector<String>();
		for(int i=1;i<100;i++){
			noticeVector.add("> 我校足球队荣获惠州市第"+i+"届迎春足球赛青年组冠军	   "+new Date().toString());
		}
		new adminView(noticeVector).init();
	}
}

