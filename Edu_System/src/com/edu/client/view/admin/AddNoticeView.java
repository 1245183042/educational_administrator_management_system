package com.edu.client.view.admin;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddNoticeView {
	private JPanel addNoticePanel;
	
	public void init(){
		JFrame addNoticeFrame = new JFrame("测试窗口");
		
		addNoticePanel = new JPanel();
		addNoticePanel.setPreferredSize(new Dimension(1136, 620));
		addNoticePanel.setLayout(null);
		
		JLabel topLabel = new JLabel("公告管理");
		topLabel.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JLabel tipLabel = new JLabel(">>>   发布新公告");
		tipLabel.setBounds(268,55,100,20);
		JLabel titleLabel = new JLabel("标题");
		titleLabel.setBounds(400, 150, 30, 20);
		JTextField titleField = new JTextField();
		titleField.setBounds(440, 150, 200, 20);
		JLabel whoLabel = new JLabel("通知对象");
		whoLabel.setBounds(400, 200, 60, 20);
		JCheckBox studentBox  = new JCheckBox();
		studentBox.setBounds(500, 200, 20, 16);
		JLabel studentLabel = new JLabel("学生");
		studentLabel.setBounds(525, 200, 30, 20);
		JCheckBox teacherBox  = new JCheckBox();
		teacherBox.setBounds(577, 200, 20, 16);
		JLabel teacherLabel = new JLabel("教师");
		teacherLabel.setBounds(602, 200, 30, 20);
		JLabel contentLabel = new JLabel("内容");
		contentLabel.setBounds(400, 250, 30, 20);
		JTextArea contentArea = new JTextArea();
		JScrollPane contentPane = new JScrollPane(contentArea);
		contentPane.setBounds(440, 250, 600, 200);
		contentArea.setLineWrap(true);
		JLabel authorLabel = new JLabel("发布人");
		authorLabel.setBounds(400, 480, 50, 20);
		JTextField authorField = new JTextField();
		authorField.setBounds(440, 480, 200, 20);
		JButton confirmButton = new JButton("确认发布");
		confirmButton.setBounds(950, 520, 90, 20);
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
		
		addNoticeFrame.add(addNoticePanel);
		addNoticeFrame.pack();
		addNoticeFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AddNoticeView().init();
	}
}
