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
import com.edu.server.dao.EduDao;
import com.edu.server.dao.StudentDao;
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
		EduDao dao = new EduDao();
		try {
			List<String> childElementValues = XmlManager
					.getChildElementValues(XmlManager
							.getDoc("src/com/edu/server/connection/db.xml"));
			Connection conn = null;
			// ConnManager.getConn(childElementValues.get(0),
			// childElementValues.get(1), childElementValues.get(2),
			// childElementValues.get(3));
			in = new ObjectInputStream(serverSocket.getInputStream());
			out = new ObjectOutputStream(serverSocket.getOutputStream());
			Message message = (Message) in.readObject();
			String identify = message.getIdentify();
			String operationCode = message.getOperationCode();
			Message getMes = null;
			if (identify.equals(Identify.ADMIN)) {
				AdminDao adminDao = new AdminDao();
				if (operationCode.equals(OperationCode.LOGIN)) {
					getMes = dao
							.getAdmin(Integer.parseInt(message.getAdmin()
									.getAdminName()), message.getAdmin()
									.getAdminPassword());

					out.writeObject(getMes);
				} else if (operationCode.equals(OperationCode.CREATE_NOTICE)) {
					dao.addNotice(message.getNotice());
				} else if (operationCode.equals(OperationCode.RETRIEVE_NOTICE)) {
					getMes = dao.getNotice(message.getNotice()
							.getNoticeTarget());
					out.writeObject(getMes);
				} else if (operationCode.equals(OperationCode.UPDATE_NOTICE)) {
					dao.alterNotice(message.getNotice());
				} else if (operationCode.equals(OperationCode.DELETE_NOTICE)) {
					dao.deleteNotice(message.getNotice().getNoticeId());
				} else if (operationCode.equals(OperationCode.CREATE_STUDENT)) {
					dao.addStudent(message.getStudent());
				} else if (operationCode.equals(OperationCode.RETRIEVE_STUDENT)) {
					if (null == message.getCollage()) {
						getMes = dao.getStudent(message.getStudent()
								.getStudentId());
						out.writeObject(getMes);
					} else {
						List<Message> getMess = dao.getStudents(message);
						out.writeObject(getMess);
					}
				} else if (operationCode.equals(OperationCode.UPDATE_STUDENT)) {
					dao.alterStudent(message.getStudent());
				} else if (operationCode.equals(OperationCode.DELETE_STUDENT)) {
					dao.deleteStudent(message.getStudent().getStudentId());
				} else if (operationCode.equals(OperationCode.CREATE_TEACHER)) {
					dao.addStudent(message.getStudent());
				} else if (operationCode.equals(OperationCode.RETRIEVE_TEACHER)) {
					if (null == message.getCollage()) {
						getMes = dao.getTeacher(message.getTeacher()
								.getTeacherId());
						out.writeObject(getMes);
					} else {
						List<Message> getMess = dao.getTeachers(message
								.getCollage().getCollageName());
						out.writeObject(getMess);
					}
				} else if (operationCode.equals(OperationCode.UPDATE_TEACHER)) {
					dao.alterTeacher(message.getTeacher());
				} else if (operationCode.equals(OperationCode.DELETE_TEACHER)) {
					dao.deleteTeacher(message.getTeacher().getTeacherId());
				} else if (operationCode.equals(OperationCode.CREATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_COURSE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_COURSE)) {

				} else if (operationCode.equals(OperationCode.DELETE_COURSE)) {

				} else if (operationCode.equals(OperationCode.CREATE_SUBJECT)) {
					dao.addSubject(message.getSubject());
				} else if (operationCode.equals(OperationCode.RETRIEVE_SUBJECT)) {
					getMes = dao.getSubject(message.getSubject()
							.getSubjectName());
					out.writeObject(getMes);
				} else if (operationCode.equals(OperationCode.UPDATE_SUBJECT)) {
					dao.alterSubject(message.getSubject());
				} else if (operationCode.equals(OperationCode.DELETE_SUBJECT)) {
					dao.deleteSubject(message.getSubject().getSubjectId());
				} else if (operationCode.equals(OperationCode.CREATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SCORE)) {

				} else if (operationCode.equals(OperationCode.UPDATE_SCORE)) {

				} else if (operationCode.equals(OperationCode.DELETE_SCORE)) {

				}

			} else if (identify.equals(Identify.STUDENT)) {
				StudentDao studentDao = new StudentDao();
				if (operationCode.equals(OperationCode.LOGIN)) {
					getMes = dao.getStudent(
							message.getStudent().getStudentId(), message
									.getStudent().getStudentPassword());
					// Message message2 = studentDao.queryNotice(conn);
					Message message2 = dao.getNotice(1);
					message2.setStudent(getMes.getStudent());
					message2.setMajor(getMes.getMajor());
					message2.setCollage(getMes.getCollage());
					message2.setGrade(getMes.getGrade());
					out.writeObject(message2);
				} else if (operationCode.equals(OperationCode.RETRIEVE_NOTICE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_STUDENT)) {
					getMes = dao
							.getStudent(message.getStudent().getStudentId());
					out.writeObject(getMes);
				} else if (operationCode.equals(OperationCode.UPDATE_STUDENT)) {
					dao.alterStudent(message.getStudent());
				} else if (operationCode.equals(OperationCode.RETRIEVE_COURSE)) {

				} else if (operationCode.equals(OperationCode.RETRIEVE_SCORE)) {

				}

			} else if (identify.equals(Identify.TEACHER)) {

				if (operationCode.equals(OperationCode.LOGIN)) {
					getMes = dao.getTeacher(
							message.getTeacher().getTeacherId(), message
									.getTeacher().getTeacherPassword());
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

				}
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
