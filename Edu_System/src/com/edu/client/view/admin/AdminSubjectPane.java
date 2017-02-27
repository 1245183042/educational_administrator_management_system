package com.edu.client.view.admin;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminSubjectPane {
	private JPanel subjectPanel;//放在tabbedPane的科目管理标签
	private JPanel subjectInitPanel;//初始面板
	
	public JPanel init(){
		String[] colleges = new String[]{
				"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
				"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
				"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
			};
		
		Font font = new Font("宋体",Font.PLAIN,14);//常规Label字体
		Font font1 = new Font("微软雅黑",Font.BOLD,12);//常规按钮字体
		
		subjectPanel = new JPanel();
		subjectPanel.setLayout(null);
		subjectPanel.setBounds(0, 0, 910, 520);
		JLabel titleLable = new JLabel("课程管理");
		titleLable.setBounds(422, 10, 66, 20);
		titleLable.setFont(new Font("微软雅黑",Font.BOLD,16));
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
//		lineLabel.setFont(font1);
		lineLabel.setBounds(152,45,605,3);
		JLabel subjectLabel = new JLabel("科目");
		subjectLabel.setBounds(152,55,30,20);
		subjectLabel.setFont(font);
		JTextField queryField = new JTextField();
		queryField.setBounds(187,55,100,20);
		queryField.setFont(font);
		JComboBox<String> subjectBox = new JComboBox<String>(colleges);
		subjectBox.setBounds(292,55,170,20);
		subjectBox.setFont(font);
		JButton addButton = new JButton("添加科目");
		addButton.setBounds(650,55,87,20);
		addButton.setFont(font1);
		JLabel subjectIdLabel = new JLabel("科目ID:");
		subjectIdLabel.setBounds(370,110,60,20);
		subjectIdLabel.setFont(font);
		JLabel IdLabel = new JLabel("100011");
		IdLabel.setBounds(450,110,200,20);
		subjectIdLabel.setFont(font);
		JLabel subjectNameLabel = new JLabel("科目名称:");
		subjectNameLabel.setBounds(360,140,70,20);
		subjectNameLabel.setFont(font);
		JTextField subjectNameField = new JTextField("高等数学1");
		subjectNameField.setBounds(450,140,100,20);
		subjectNameField.setFont(font);
		subjectNameField.setEditable(false);
		JLabel learnTimeLabel = new JLabel("学时:");
		learnTimeLabel.setBounds(390, 170, 60, 20);
		learnTimeLabel.setFont(font);
		JTextField learnTimeField = new JTextField("48学时");
		learnTimeField.setBounds(450,170,100,20);
		learnTimeField.setFont(font);
		learnTimeField.setEditable(false);
		JButton modifyButton = new JButton("修改");
		modifyButton.setBounds(370, 220, 60, 20);
		modifyButton.setFont(font1);
		JButton deleteButton = new JButton("删除该科目");
		deleteButton.setBounds(450, 220, 100, 20);
		deleteButton.setFont(font1);
		
		subjectInitPanel = new JPanel();
		subjectInitPanel.setLayout(null);
		subjectInitPanel.setBounds(0, 0, 910, 520);
		subjectInitPanel.add(titleLable);
		subjectInitPanel.add(lineLabel);
		subjectInitPanel.add(subjectLabel);
		subjectInitPanel.add(queryField);
		subjectInitPanel.add(subjectBox);
		subjectInitPanel.add(addButton);
		subjectInitPanel.add(subjectIdLabel);
		subjectInitPanel.add(IdLabel);
		subjectInitPanel.add(subjectNameLabel);
		subjectInitPanel.add(subjectNameField);
		subjectInitPanel.add(learnTimeLabel);
		subjectInitPanel.add(learnTimeField);
		subjectInitPanel.add(modifyButton);
		subjectInitPanel.add(deleteButton);

		
		subjectPanel.add(subjectInitPanel);
		return subjectPanel;
	}
}
