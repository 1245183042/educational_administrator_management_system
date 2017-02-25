package com.edu.server.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

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
			//System.out.println(operationCode);
			if (operationCode.equals(OperationCode.LOGIN)) {
				User user = null;
				if (identify.equals(Identify.ADMIN)) {
					user = userDao.queryAdmin(conn, message.getUser());
				} else if (identify.equals(Identify.STUDENT)) {
					user = userDao.queryStudent(conn, message.getUser());
				} else if (identify.equals(Identify.TEACHER)) {
					user = userDao.queryTeacher(conn, message.getUser());
				}
				out.writeObject(user);
				out.flush();
			}else if(operationCode.equals(OperationCode.QUERY_NOTICE)){
			
				List<Notice> notices = null;
				if(identify.equals(Identify.ADMIN)){
					notices = adminDao.queryNotice(conn);
				}
				out.writeObject(notices);
				out.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}
}
