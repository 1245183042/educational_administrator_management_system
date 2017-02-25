package com.edu.server.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.List;

import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.OperationCode;
import com.edu.bean.User;
import com.edu.server.connection.ConnManager;
import com.edu.server.connection.XmlManager;
import com.edu.server.dao.AdminDao;
import com.edu.server.dao.UserDao;

/**
 * 服务端线程
 * 
 * @author Administrator
 * 
 */
public class ServerThread extends Thread {

	private Socket serverSocket;
	private static int onlineNum; // 在线人数
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Object obj = new Object();

	public ServerThread(Socket serverSocket) {
		synchronized (obj) {
			this.serverSocket = serverSocket;
			onlineNum++;
		}
	}

	@Override
	public void run() {
		Message message = null;
		UserDao userDao = new UserDao();
		AdminDao adminDao = new AdminDao();
		try {
			List<String> childElementValues = XmlManager
					.getChildElementValues(XmlManager
							.getDoc("src/com/edu/server/connection/db.xml"));
			Connection conn = ConnManager.getConn(childElementValues.get(0),
					childElementValues.get(1), childElementValues.get(2),
					childElementValues.get(3));
			in = new ObjectInputStream(serverSocket.getInputStream());
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			message = (Message) in.readObject();
			String identify = message.getIdentify();
			String operationCode = message.getOperationCode();
			// System.out.println(operationCode);
			User user = null;
			List<Notice> notices = null;
			if (identify.equals(Identify.ADMIN)) {
				if (operationCode.equals(OperationCode.LOGIN)) {
					user = userDao.queryAdmin(conn, message.getUser());
					out.writeObject(user);
				} else if (operationCode.equals(OperationCode.QUERY_NOTICE)) {
					notices = adminDao.queryNotice(conn);
					out.writeObject(notices);
				} else if (operationCode.equals(OperationCode.QUERY_STUDENT)) {
					//System.out.println(message.getUser().getUserId());
					Message getMes = userDao.queryStudentAll(conn,
							message.getUser());
					out.writeObject(getMes);
				}

			} else if (identify.equals(Identify.STUDENT)) {
				if (operationCode.equals(OperationCode.LOGIN)) {
					user = userDao.queryStudent(conn, message.getUser());
					out.writeObject(user);
				}

			} else if (identify.equals(Identify.TEACHER)) {
				if (operationCode.equals(OperationCode.LOGIN)) {
					user = userDao.queryTeacher(conn, message.getUser());
					out.writeObject(user);
				}
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
