package com.edu.client.model;

import java.io.IOException;
import java.util.List;

import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.OperationCode;
import com.edu.client.model.UserModel;

public class StudentModel {
	@SuppressWarnings("finally")
	public List<Notice> notices(){
		List<Notice> notice = null;
		try {
			String identify = Identify.STUDENT;
			Message message = new Message(identify, OperationCode.QUERY_NOTICE);
			UserModel userModel = new UserModel();
			
			List<Notice> notices = userModel.queryNotice(message);
			notice = notices;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			return notice;
		}
		
	}
}
