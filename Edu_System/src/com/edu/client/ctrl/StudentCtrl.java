package com.edu.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.edu.client.view.LoginView;


public class StudentCtrl implements ActionListener {
	private JButton logoutButton;
	private JFrame frame;
	public StudentCtrl(JButton logoutButton, JFrame frame) {
		this.logoutButton = logoutButton;
		this.frame = frame;
	}
	public void studentCtrl(){
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(logoutButton)){
			frame.setVisible(false);
			new LoginView().iniUI();
		}
		
	}
}
