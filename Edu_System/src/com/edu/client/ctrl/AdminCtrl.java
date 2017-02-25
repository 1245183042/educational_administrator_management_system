package com.edu.client.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.OperationCode;
import com.edu.bean.Student;
import com.edu.client.model.UserModel;
import com.edu.client.view.admin.AdminNoticePane;
import com.edu.util.DateUtil;

public class AdminCtrl extends WindowAdapter implements ActionListener {

	private JTextField idField;
	private ButtonGroup group;
	private DefaultTableModel model;
	private JButton button;

	public AdminCtrl() {
	};

	public AdminCtrl(ButtonGroup group, JTextField idField,
			DefaultTableModel model, JButton button) {
		this.idField = idField;
		this.group = group;
		this.model = model;
		this.button = button;
	}

	@Override
	public void windowOpened(WindowEvent e) {
//		try {
//			String identify = Identify.ADMIN;
//			//Message message = new Message(identify, OperationCode.QUERY_NOTICE);
//			UserModel userModel = new UserModel();
//
//			List<Notice> notices = userModel.queryNotice(message);
//			AdminNoticePane adminNoticePane = AdminNoticePane.getInstance();
//			DefaultTableModel model = adminNoticePane.getModel();
//			for (Notice n : notices) {
//				// System.out.println(n.getNoticeTitle());
//				model.addRow(new String[] { "口", n.getNoticeTitle(),
//						getTarget(n.getNoticeTarget()), n.getNoticeAuthor(),
//						DateUtil.getTime(n.getNoticeReleaseTime()) });
//			}
//
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
	}

	private String getTarget(int n) {
		System.out.println(n);
		if (n == 2) {
			return "教师";
		} else if (n == 1) {
			return "学生";
		} else {
			return "全体教师生";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Message message = null;
			UserModel userModel = new UserModel();
			if (e.getSource() == button) {
				Enumeration<AbstractButton> elements = group.getElements();
				while (elements.hasMoreElements()) {
					AbstractButton button = elements.nextElement();
					if (button.isSelected()) {
						String value = button.getText();
						if (value.equals("学号")) {
							String id = idField.getText();
							if (!"".equals(id)) {
							
							} else {
								JOptionPane.showMessageDialog(idField,
										"学号不能为空！", "错误信息",
										JOptionPane.ERROR_MESSAGE);
							}
						}else{
							
						}
					}
				}
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}

}
