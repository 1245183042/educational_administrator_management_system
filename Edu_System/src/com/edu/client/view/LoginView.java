package com.edu.client.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.edu.bean.Identify;

/**
 * 教务管理系统登录页面
 * 
 * @author chen7
 * 
 */
public class LoginView {
	private JComboBox<String> identityBox;
	private JLabel accountLabel;
	private Identify identify;

	public void iniUI() {
		JFrame loginFrame = new JFrame();
		loginFrame.setSize(800, 500);
		loginFrame.setLocationRelativeTo(null);

		JPanel contentPane = (JPanel) loginFrame.getContentPane();
		contentPane.setLayout(null);

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(0, 0, 320, 220);
		contentPane.add(loginPanel);

		JLabel topLabel = new JLabel("用户登录");
		topLabel.setBounds(150, 10, 180, 30);
		loginPanel.add(topLabel);

		JLabel identityLabel = new JLabel("身份");
		identityLabel.setBounds(70, 45, 50, 20);
		loginPanel.add(identityLabel);

		accountLabel = new JLabel("学号");
		accountLabel.setBounds(70, 70, 50, 20);
		loginPanel.add(accountLabel);

		JLabel passwordLabel = new JLabel("密码");
		passwordLabel.setBounds(70, 95, 50, 20);
		loginPanel.add(passwordLabel);

		JButton loginButton = new JButton("登录");
		loginButton.setBounds(70, 150, 180, 30);
		loginPanel.add(loginButton);

		identityBox = new JComboBox<String>();
		identityBox.setBounds(115, 45, 130, 20);
		identityBox.addItem("学生");
		identityBox.addItem("教师教辅人员");
		identityBox.addItem("管理员");

		loginPanel.add(identityBox);

		JTextField accountField = new JTextField();
		accountField.setBounds(115, 70, 130, 20);
		loginPanel.add(accountField);

		JTextField passwordField = new JTextField();
		passwordField.setBounds(115, 95, 130, 20);
		loginPanel.add(passwordField);

		loginFrame.setVisible(true);

		identityBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					if (identityBox.getSelectedItem().equals("学生")) {
						accountLabel.setText("学号");
						identify = Identify.STUDENT;
					}
					if (identityBox.getSelectedItem().equals("教师教辅人员")) {
						accountLabel.setText("工号");
						
					}
					if (identityBox.getSelectedItem().equals("管理员")) {
						accountLabel.setText("账号");
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new LoginView().iniUI();
	}
}
