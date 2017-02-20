package com.edu.client.view.admin;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AdminStudentPane {
	private JPanel studentPane;
	private JPanel upPane;
	private JScrollPane downPane;
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	public void init(){
studentPane = new JPanel();
	 	
		
		upPane = new JPanel();
		upPane.setLayout(new GridBagLayout());
		JLabel titleLable = new JLabel("学生管理");
		JLabel lineLabel = new JLabel("—————————————————————————");
		JRadioButton Radio1 = new JRadioButton();
		JRadioButton Radio2 = new JRadioButton();
		JLabel collegeLabel = new JLabel("院系");
		JComboBox collegeBox = new JComboBox();
		JLabel majorLabel = new JLabel("专业");
		JComboBox majorBox = new JComboBox();
		JLabel gradeLabel = new JLabel("年级");
		JComboBox gradeBox = new JComboBox();
		JLabel classLabel = new JLabel("班级");
		JComboBox classBox = new JComboBox();
		JLabel idLabel = new JLabel("学号");
		JTextField idField = new JTextField();
		JButton queryButton = new JButton("检索");
		JButton addButton = new JButton("添加学生");
		
		
		
		downPane = new JScrollPane();
	}
	//添加组件
		public void addComponent(Component comp){
			gb.setConstraints(comp, gbc);
			upPane.add(comp);
		}
}
