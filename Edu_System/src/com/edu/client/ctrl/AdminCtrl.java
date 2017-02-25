package com.edu.client.ctrl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.OperationCode;
import com.edu.client.model.UserModel;

public class AdminCtrl extends WindowAdapter {

	@Override
	public void windowOpened(WindowEvent e) {
		try {
			String identify = Identify.ADMIN;
			Message message = new Message(identify, OperationCode.QUERY_NOTICE);
			UserModel userModel = new UserModel();
			
			List<Notice> notices = userModel.queryNotice(message);
			for (Notice n : notices) {
				System.out.println(n.getNoticeTitle());
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
