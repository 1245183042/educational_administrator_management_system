package com.edu.client.view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.edu.bean.CurrentPage;
import com.edu.util.DateUtil;

public class AdminNoticePane {
	private JPanel noticePanel;//放在tabbedPane的公告标签
	private JPanel noticeInitPanel;//初始面板
	private JPanel addNoticePanel;//添加新公告的面板
	private JScrollPane downScrollPane;//用来装公告表格的面板
	private JTable NoticeTable;//学生信息表格
	private DefaultTableModel model;
	private JButton addNoticeButton;


	/*
	 * 单例模式
	 */
	// 定义一个私有构造方法,防止用new实例化
	private AdminNoticePane(){}
	//定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	private static volatile AdminNoticePane adminNoticeInstance;
	 //定义一个共有的静态方法，返回该类型实例
	public static AdminNoticePane getIstance(){
		 // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if(adminNoticeInstance==null){
			//同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (AdminNoticePane.class) {
				 //未初始化，则初始instance变量
				if(adminNoticeInstance==null){
					adminNoticeInstance=new AdminNoticePane();
				}
			}
		}
		return adminNoticeInstance;
	}
	
	public JPanel getAddNoticePanel(){
		return addNoticePanel;
	}

	public JPanel getNoticeInitPanel(){
		return noticeInitPanel;
	}
	
	public JButton getAddButton() {
		return addNoticeButton;
	}
	public void setAddButton(JButton addNoticeButton) {
		this.addNoticeButton = addNoticeButton;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JPanel init(){
		Font font = new Font("宋体",Font.PLAIN,12);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		noticePanel = new JPanel();
		noticePanel.setLayout(null);
		noticePanel.setBounds(0, 0, 910, 520);
		
		JLabel titleLable = new JLabel("公告管理");
		titleLable.setBounds(422, 10, 66, 20);
		titleLable.setFont(new Font("微软雅黑",Font.BOLD,16));
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
//		lineLabel.setFont(font1);
		lineLabel.setBounds(152,45,605,3);
		addNoticeButton = new JButton("发布新公告");
		addNoticeButton.setFont(font1);
		addNoticeButton.setBounds(152,55,100,20);
		
		//用来装公告表格的面板
		model = new DefaultTableModel(new String[]{"口删除","标题","发布对象","发布者","发布时间"}, 0);
		NoticeTable = new JTable(model);
		model.addRow(new String[]{"口","关于配合做好车辆通行年票费补缴工作的通知","学生","admin",DateUtil.getTime()});
		model.addRow(new String[]{"口","开学温馨提示","学生","admin",DateUtil.getTime()});
		TableColumn column = NoticeTable.getColumnModel().getColumn(0);
		column.setCellEditor(new DefaultCellEditor(new JCheckBox()));
		downScrollPane = new JScrollPane(NoticeTable);
		downScrollPane.setBounds(50, 100, 810, 300);
		
		noticeInitPanel = new JPanel();
		noticeInitPanel.setLayout(null);
		noticeInitPanel.setBounds(0, 0, 910, 520);
		noticeInitPanel.add(titleLable);
		noticeInitPanel.add(lineLabel);
		noticeInitPanel.add(addNoticeButton);
		noticeInitPanel.add(downScrollPane);
		
		noticePanel.add(noticeInitPanel);
		
		addNoticeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				noticeInitPanel.setVisible(false);
				addNoticePanel = new AddNoticePane().init();
				noticePanel.add(addNoticePanel);
				addNoticePanel.setVisible(true);
				AdminView.currentPage = CurrentPage.newNotice;
			}
		});

		return noticePanel;
	}
}
