package com.edu.client.view.admin;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddNoticePane {
	private JPanel addNoticePanel;
	
	public JPanel init(){
		Font font = new Font("宋体",Font.PLAIN,14);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		addNoticePanel = new JPanel();
		addNoticePanel.setBounds(0, 0, 910, 520);
		addNoticePanel.setLayout(null);
		
		JLabel topLabel = new JLabel("公告管理");
		topLabel.setBounds(422, 10, 66, 20);
		topLabel.setFont(new Font("微软雅黑",Font.BOLD,16));
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
//		lineLabel.setFont(font1);
		lineLabel.setBounds(152,45,605,3);
		JLabel tipLabel = new JLabel(">>>   发布新公告");
		tipLabel.setBounds(152,55,100,20);
		tipLabel.setFont(font1);
		JLabel titleLabel = new JLabel("标题");
		titleLabel.setBounds(280, 100, 30, 20);
		titleLabel.setFont(font);
		JTextField titleField = new JTextField();
		titleField.setBounds(320, 100, 200, 20);
		JLabel whoLabel = new JLabel("通知对象");
		whoLabel.setBounds(252, 150, 60, 20);
		whoLabel.setFont(font);
		JCheckBox studentBox  = new JCheckBox();
		studentBox.setBounds(320, 150, 20, 16);
		JLabel studentLabel = new JLabel("学生");
		studentLabel.setBounds(345, 150, 30, 20);
		studentLabel.setFont(font);
		JCheckBox teacherBox  = new JCheckBox();
		teacherBox.setBounds(385, 150, 20, 16);
		JLabel teacherLabel = new JLabel("教师");
		teacherLabel.setBounds(410, 150, 30, 20);
		teacherLabel.setFont(font);
		JLabel contentLabel = new JLabel("内容");
		contentLabel.setBounds(280, 200, 30, 20);
		contentLabel.setFont(font);
		JTextArea contentArea = new JTextArea();
		JScrollPane contentPane = new JScrollPane(contentArea);
		contentPane.setBounds(320, 200, 500, 150);
		contentArea.setLineWrap(true);
		JLabel authorLabel = new JLabel("发布人");
		authorLabel.setBounds(270, 380, 50, 20);
		authorLabel.setFont(font);
		JTextField authorField = new JTextField();
		authorField.setBounds(320, 380, 200, 20);
		JButton confirmButton = new JButton("确认发布");
		confirmButton.setBounds(730, 420, 90, 20);
		confirmButton.setFont(font1);
		addNoticePanel.add(topLabel);
		addNoticePanel.add(lineLabel);
		addNoticePanel.add(tipLabel);
		addNoticePanel.add(titleLabel);
		addNoticePanel.add(titleField);
		addNoticePanel.add(whoLabel);
		addNoticePanel.add(studentBox);
		addNoticePanel.add(studentLabel);
		addNoticePanel.add(teacherBox);
		addNoticePanel.add(teacherLabel);
		addNoticePanel.add(contentLabel);
		addNoticePanel.add(contentPane);
		addNoticePanel.add(authorLabel);
		addNoticePanel.add(authorField);
		addNoticePanel.add(confirmButton);
//		addNoticePanel.setVisible(false);
		return addNoticePanel;
	}
}
