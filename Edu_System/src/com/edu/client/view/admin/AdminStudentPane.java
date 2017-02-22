package com.edu.client.view.admin;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminStudentPane {
	private JPanel studentPane;
	private JPanel upPane;
	private JScrollPane downPane;
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	public void init(){ 
		//装院系的数组
		String[] colleges = new String[]{
			"电子信息与电气工程学院","旭日广东服装学院","化学与材料工程学院","经济管理学院","信息科学技术学院",
			"教育科学学院","建筑与土木工程学院","地理与旅游学院","美术与设计学院","生命科学学院","数学与大数据学院",
			"体育学院","外国语学院 ","音乐学院","文学与传媒学院","政法学院","马克思主义学院","继续教育学院 "
		};
		//装年级的的数组
		String[] grades = new String[]{
			"2013级","2014级","2015级","2016级"	
		};
		//装班级的数组
		String[] classs = new String[]{
			"1班","2班"
		};
		
		//条件选择面板
		upPane = new JPanel();
		upPane.setLayout(gb);
		JLabel titleLable = new JLabel("学生管理");
		JLabel lineLabel = new JLabel("——————————————————————————————————————————————————");
		JRadioButton Radio1 = new JRadioButton();
		JRadioButton Radio2 = new JRadioButton();
		JLabel collegeLabel = new JLabel("院系");
		JComboBox<String> collegeBox = new JComboBox<String>(colleges);
		JLabel majorLabel = new JLabel("专业");
		JComboBox<String> majorBox = new JComboBox<String>(colleges);
		JLabel gradeLabel = new JLabel("年级");
		JComboBox<String> gradeBox = new JComboBox<String>(grades);
		JLabel classLabel = new JLabel("班级");
		JComboBox<String> classBox = new JComboBox<String>(classs);
		JLabel idLabel = new JLabel("学号");
		JTextField idField = new JTextField();
		JButton queryButton = new JButton("检索");
		JButton addButton = new JButton("添加学生");
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(titleLable);
		addComponent(lineLabel);
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		addComponent(Radio1);
		addComponent(collegeLabel);
		addComponent(collegeBox);
		addComponent(majorLabel);
		addComponent(majorBox);
		addComponent(gradeLabel);
		addComponent(gradeBox);
		addComponent(classLabel);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(classBox);
		gbc.gridwidth = 1;
		addComponent(Radio2);
		addComponent(idLabel);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		addComponent(idField);
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.gridwidth = 1;
		addComponent(queryButton);
		gbc.gridx = 8;
		gbc.gridy = 4;
		addComponent(addButton);
		
		//显示学生信息的面板
		
		JTable sutudentInfoTable = new JTable(new Object[][]{{"信息科学技术学院","网络工程","2013级","1314080903178","林蛋大",new JCheckBox(),new JCheckBox()}},
				new Object[]{"院系","专业","年级","班级","学号","姓名",new Button("修改信息"),new Button("删除")});
		downPane = new JScrollPane(sutudentInfoTable);
		
		
		JFrame jf = new JFrame("测试窗口");
		jf.setLayout(null);
		upPane.setBounds(0, 0, 1000, 100);
		downPane.setBounds(50, 200,1000, 500);
		jf.add(downPane);
		jf.add(upPane);
		jf.setBounds(0,0,1800, 500);
		jf.setVisible(true);;
	}
	//添加组件
	public void addComponent(Component comp){
		gb.setConstraints(comp, gbc);
		upPane.add(comp);
	}
	
	public static void main(String[] args) {
		new AdminStudentPane().init();
	}
}
