package com.edu.server.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.List;

import com.edu.bean.Identify;
import com.edu.bean.Message;
import com.edu.bean.OperationCode;
import com.edu.server.connection.ConnManager;
import com.edu.server.connection.XmlManager;
import com.edu.server.dao.AdminDao;
import com.edu.server.dao.UserDao;

/**
 * 服务端Service层
 * 
 * @author Administrator
 * 
 */
public class ServerService {

	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Socket serverSocket;

	public ServerService(Socket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void init() {
		UserDao userDao = new UserDao();
		try {
			List<String> childElementValues = XmlManager
					.getChildElementValues(XmlManager
							.getDoc("src/com/edu/server/connection/db.xml"));
			Connection conn = ConnManager.getConn(childElementValues.get(0),
					childElementValues.get(1), childElementValues.get(2),
					childElementValues.get(3));
			in = new ObjectInputStream(serverSocket.getInputStream());
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			Message message = (Message) in.readObject();
			String identify = message.getIdentify();
			String operationCode = message.getOperationCode();
			Message getMes = null;
			if (identify.equals(Identify.ADMIN)) {
				AdminDao adminDao = new AdminDao();
				if (operationCode.equals(OperationCode.LOGIN)) {
					getMes = userDao.queryAdmin(conn, message.getAdmin());
					out.writeObject(getMes);
				} else if (operationCode.equals(OperationCode.CREATE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.DELETE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.CREATE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.UPDATE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.DELETE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.CREATE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.UPDATE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.DELETE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.CREATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_COURSE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.DELETE_COURSE)) {

				} else if (operationCode.equals(OperationCode.CREATE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.UPDATE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.DELETE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.CREATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SCORE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.DELETE_SCORE)) {

				}

			} else if (identify.equals(Identify.STUDENT)) {

				if (operationCode.equals(OperationCode.LOGIN)) {
					getMes = userDao.queryStudent(conn, message.getStudent());
					out.writeObject(getMes);
				} else if (operationCode.equals(OperationCode.CREATE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.DELETE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.CREATE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.UPDATE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.DELETE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.CREATE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.UPDATE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.DELETE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.CREATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_COURSE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.DELETE_COURSE)) {

				} else if (operationCode.equals(OperationCode.CREATE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.UPDATE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.DELETE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.CREATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SCORE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.DELETE_SCORE)) {

				}

			} else if (identify.equals(Identify.TEACHER)) {

				if (operationCode.equals(OperationCode.LOGIN)) {
					getMes = userDao.queryTeacher(conn, message.getTeacher());
					out.writeObject(getMes);
				} else if (operationCode.equals(OperationCode.CREATE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.DELETE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.CREATE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.UPDATE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.DELETE_STUDENT)) {

				} else if (operationCode.equals(OperationCode.CREATE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.UPDATE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.DELETE_TEACHER)) {

				} else if (operationCode.equals(OperationCode.CREATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_COURSE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.DELETE_COURSE)) {

				} else if (operationCode.equals(OperationCode.CREATE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.UPDATE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.DELETE_SUBJECT)) {

				} else if (operationCode.equals(OperationCode.CREATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SCORE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.DELETE_SCORE)) {

				}
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
