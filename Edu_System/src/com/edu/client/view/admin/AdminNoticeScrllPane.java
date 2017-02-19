package com.edu.client.view.admin;

import java.util.Date;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class AdminNoticeScrllPane {
	//放在tabbedPane的组件
	private JScrollPane noticeScrllPane;
	private JList noticeLists;//公告列表
	private Vector<String> noticeVector;//装公告标题和发布时间
	
	public AdminNoticeScrllPane(Vector<String> noticeVector){
		this.noticeVector = noticeVector;
	}
	
	public JScrollPane init(){
		Vector<String> noticeVector = new Vector<String>();
		for(int i=1;i<100;i++){
			noticeVector.add("> 我校足球队荣获惠州市第"+i+1+"届迎春足球赛青年组冠军	   "+new Date().toString());
		}
		noticeLists = new JList(noticeVector);
		noticeScrllPane = new JScrollPane(noticeLists);
		return noticeScrllPane;
	}
}
