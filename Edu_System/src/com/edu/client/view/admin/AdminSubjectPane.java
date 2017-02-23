package com.edu.client.view.admin;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminSubjectPane {
	private JPanel subjectPanel;//放在tabbedPane的科目管理标签
	
	public JPanel init(){
		String[] colleges = new String[]{
				"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
				"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
				"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
			};
		
		subjectPanel = new JPanel();
		subjectPanel.setLayout(null);
		subjectPanel.setBounds(0, 0, 1136, 620);
		JLabel titleLable = new JLabel("科目管理");
		titleLable.setBounds(540, 20, 60, 20);
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		lineLabel.setBounds(268,45,650,3);
		JLabel subjectLabel = new JLabel("科目");
		subjectLabel.setBounds(300,55,30,20);
		JTextField queryField = new JTextField();
		queryField.setBounds(335,55,100,20);
		JComboBox<String> subjectBox = new JComboBox<String>(colleges);
		subjectBox.setBounds(440,55,170,20);
		JButton addButton = new JButton("添加科目");
		addButton.setBounds(845,55,87,20);
		JLabel subjectIdLabel = new JLabel("科目ID:");
		subjectIdLabel.setBounds(440,110,60,20);
		JLabel IdLabel = new JLabel("100011");
		IdLabel.setBounds(510,110,200,20);
		JLabel subjectNameLabel = new JLabel("科目名称:");
		subjectNameLabel.setBounds(440,140,60,20);
		JTextField subjectNameField = new JTextField("高等数学1");
		subjectNameField.setBounds(510,140,100,20);
		subjectNameField.setEditable(false);
		JLabel learnTimeLabel = new JLabel("学时:");
		learnTimeLabel.setBounds(440, 170, 60, 20);
		JTextField learnTimeField = new JTextField("48学时");
		learnTimeField.setBounds(510,170,100,20);
		learnTimeField.setEditable(false);
		JButton modifyButton = new JButton("修改");
		modifyButton.setBounds(440, 220, 60, 20);
		JButton deleteButton = new JButton("删除该科目");
		deleteButton.setBounds(510, 220, 100, 20);
		subjectPanel.add(titleLable);
		subjectPanel.add(lineLabel);
		subjectPanel.add(subjectLabel);
		subjectPanel.add(queryField);
		subjectPanel.add(subjectBox);
		subjectPanel.add(addButton);
		subjectPanel.add(subjectIdLabel);
		subjectPanel.add(IdLabel);
		subjectPanel.add(subjectNameLabel);
		subjectPanel.add(subjectNameField);
		subjectPanel.add(learnTimeLabel);
		subjectPanel.add(learnTimeField);
		subjectPanel.add(modifyButton);
		subjectPanel.add(deleteButton);
		
		
		return subjectPanel;
	}
}
