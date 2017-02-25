package com.edu.client.view.admin;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddSubjectView {
	private JPanel addSubjectPanel;
	
	public void init(){
		JFrame addSubjectFrame = new JFrame("测试窗口");
		
		addSubjectPanel = new JPanel();
		addSubjectPanel.setPreferredSize(new Dimension(1136, 620));
		addSubjectPanel.setLayout(null);
		
		JLabel topLabel = new JLabel("科目管理");
		topLabel.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JLabel tipLabel = new JLabel(">>>   添加科目");
		tipLabel.setBounds(268,55,100,20);
		JLabel subjectNameLabel = new JLabel("科目名称:");
		subjectNameLabel.setBounds(440,140,100,20);
		JTextField subjectNameField = new JTextField();
		subjectNameField.setBounds(510,140,100,20);
		JLabel learnTimeLabel = new JLabel("学时:");
		learnTimeLabel.setBounds(440, 170, 100, 20);
		JTextField learnTimeField = new JTextField();
		learnTimeField.setBounds(510,170,100,20);
		JButton confirmButton = new JButton("确认添加");
		confirmButton.setBounds(440, 210, 170, 20);
		addSubjectPanel.add(topLabel);
		addSubjectPanel.add(lineLabel);
		addSubjectPanel.add(tipLabel);
		addSubjectPanel.add(subjectNameLabel);
		addSubjectPanel.add(subjectNameField);
		addSubjectPanel.add(learnTimeLabel);
		addSubjectPanel.add(learnTimeField);
		addSubjectPanel.add(confirmButton);
		
		addSubjectFrame.add(addSubjectPanel);
		addSubjectFrame.pack();
		addSubjectFrame.setVisible(true);
	}
	public static void main(String[] args) {
		new AddSubjectView().init();
	}
}
