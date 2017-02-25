package com.edu.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.edu.bean.Administrator;
import com.edu.bean.Message;
import com.edu.bean.OperationCode;
import com.edu.bean.Student;
import com.edu.bean.Teacher;
import com.edu.bean.User;
import com.edu.client.model.UserModel;
import com.edu.client.view.admin.AdminView;
import com.edu.client.view.student.StudentView;

public class UserCtrl implements ActionListener {

	private JFrame jf;
	private JTextField userNameField;
	private JPasswordField userPasswordField;
	private JComboBox<String> identifyBox;

	public UserCtrl(JFrame jf, JTextField userNameField,
			JPasswordField userPasswordField, JComboBox<String> identifyBox) {
		this.jf = jf;
		this.userNameField = userNameField;
		this.userPasswordField = userPasswordField;
		this.identifyBox = identifyBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String userIdStr = userNameField.getText().trim();
		String userPassword = String.valueOf(userPasswordField.getPassword());
		if (userIdStr.equals("") || userPassword.equals("")) {
			JOptionPane.showMessageDialog(jf, "用户名或密码为空", "错误信息",
					JOptionPane.ERROR_MESSAGE);
		} else {
			int userId = 0;
			try {
				userId = Integer.parseInt(userIdStr);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(jf, "只能输入纯数字", "错误信息",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			String identify = identifyBox.getSelectedItem().toString();
			User user = new User();
			user.setUserId(userId);
			user.setUserPassword(userPassword);
			Message message = new Message(user, identify, OperationCode.LOGIN);

			UserModel userModel;
			try {
				userModel = new UserModel();
				User loginUser = userModel.loginUser(message);
				if (loginUser.getUserId() == 0) {
					JOptionPane.showMessageDialog(jf, "用户名或密码错误", "错误信息",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (loginUser instanceof Administrator) {
						Administrator loginAdmin = (Administrator) loginUser;
						//System.out.println(loginAdmin.getUserName());
						new AdminView().init();
					} else if (loginUser instanceof Student) {
						Student loginStudent = (Student) loginUser;
						jf.setVisible(false);
						new StudentView().initUI(loginStudent);
						//System.out.println(loginStudent.getUserName());
					} else if (loginUser instanceof Teacher) {
						Teacher loginTeacher = (Teacher) loginUser;
						//System.out.println(loginTeacher.getUserName());
					}
				
					jf.setVisible(false);
				}
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
}
