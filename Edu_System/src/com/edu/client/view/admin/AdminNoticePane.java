package com.edu.client.view.admin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.edu.util.DateUtil;

public class AdminNoticePane {
	private JPanel noticePanel;//放在tabbedPane的公告标签
	private JScrollPane downScrollPane;//用来装公告表格的面板
	private JTable NoticeTable;//学生信息表格
	
	public JPanel init(){
		noticePanel = new JPanel();
		noticePanel.setLayout(null);
		
		noticePanel.setBounds(0, 0, 1136, 620);
		JLabel titleLable = new JLabel("公告管理");
		titleLable.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JButton addButton = new JButton("发布新公告");
		addButton.setBounds(268,55,100,20);
		
		//用来装公告表格的面板
		NoticeTable = new JTable(new Object[][]{{"口","关于配合做好车辆通行年票费补缴工作的通知","学生","admin",DateUtil.getTime()},
				{"口","开学温馨提示","学生","admin",DateUtil.getTime()}},
				new Object[]{"口删除","标题","发布对象","发布者","发布时间"});
		downScrollPane = new JScrollPane(NoticeTable);
		downScrollPane.setBounds(50, 150, 1000, 300);
		
		noticePanel.add(titleLable);
		noticePanel.add(lineLabel);
		noticePanel.add(addButton);
		noticePanel.add(downScrollPane);

		return noticePanel;
	}
}
