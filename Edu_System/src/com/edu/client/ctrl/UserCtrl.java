package com.edu.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.edu.bean.Administrator;
import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.OperationCode;
import com.edu.bean.Student;
import com.edu.bean.Teacher;
import com.edu.client.model.UserModel;
import com.edu.client.view.admin.AdminView;

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

		String userName = userNameField.getText().trim();
		String userPassword = String.valueOf(userPasswordField.getPassword());
		if (userName.equals("") || userPassword.equals("")) {
			JOptionPane.showMessageDialog(jf, "用户名或密码为空", "错误信息",
					JOptionPane.ERROR_MESSAGE);
		} else {
			int u = 0;
			try {
				u = Integer.parseInt(userName);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(jf, "只能输入纯数字", "错误信息",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				String identify = identifyBox.getSelectedItem().toString();
				String operationCode = OperationCode.LOGIN;
				UserModel userModel = new UserModel();
				if (identify.equals(Identify.ADMIN)) {
					Administrator admin = new Administrator();
					admin.setAdminName(userName);
					admin.setAdminPassword(userPassword);
					Message message = new Message(identify, operationCode,
							admin);
					Message getMes = userModel.query(message);
					Administrator getAdmin = getMes.getAdmin();
					if (getAdmin.getAdminName() == null) {
						JOptionPane.showMessageDialog(jf, "用户名或密码错误", "错误信息",
								JOptionPane.ERROR_MESSAGE);
					} else {
						new AdminView().init();
						jf.setVisible(false);
					}
				} else if (identify.equals(Identify.STUDENT)) {
					Student student = new Student();
					student.setStudentId(u);
					student.setStudentPassword(userPassword);
					Message message = new Message(identify, operationCode,
							student);
					Message getMes = userModel.query(message);
					Student getStu = getMes.getStudent();
					if (getStu.getStudentName() == null) {
						JOptionPane.showMessageDialog(jf, "用户名或密码错误", "错误信息",
								JOptionPane.ERROR_MESSAGE);
					} else {
						
						System.out.println(getStu.getStudentName());
						
					}

				} else if (identify.equals(Identify.TEACHER)) {
					Teacher teacher = new Teacher();
					teacher.setTeacherId(u);
					teacher.setTeacherPassword(userPassword);
					Message message = new Message(identify, operationCode,
							teacher);
					Message getMes = userModel.query(message);
					Teacher getTea = getMes.getTeacher();
					if (getTea.getTeacherName() == null) {
						JOptionPane.showMessageDialog(jf, "用户名或密码错误", "错误信息",
								JOptionPane.ERROR_MESSAGE);
					} else {
						
						
						
						
					}
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
