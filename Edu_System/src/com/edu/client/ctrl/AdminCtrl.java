package com.edu.client.ctrl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.OperationCode;
import com.edu.client.model.UserModel;
import com.edu.client.view.admin.AdminNoticePane;
import com.edu.util.DateUtil;

public class AdminCtrl extends WindowAdapter {

	@Override
	public void windowOpened(WindowEvent e) {
		try {
			String identify = Identify.ADMIN;
			Message message = new Message(identify, OperationCode.QUERY_NOTICE);
			UserModel userModel = new UserModel();

			List<Notice> notices = userModel.queryNotice(message);
			AdminNoticePane adminNoticePane = AdminNoticePane.getInstance();
			DefaultTableModel model = adminNoticePane.getModel();
			for (Notice n : notices) {
				// System.out.println(n.getNoticeTitle());
				model.addRow(new String[] { "口", n.getNoticeTitle(),
						getTarget(n.getNoticeTarget()), n.getNoticeAuthor(),
						DateUtil.getTime(n.getNoticeReleaseTime()) });
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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

}
