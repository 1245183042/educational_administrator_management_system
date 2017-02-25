package com.edu.client.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import com.edu.bean.Message;
import com.edu.bean.Notice;

public class UserModel {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public UserModel() throws UnknownHostException, IOException {
		socket = new Socket("127.0.0.1", 11111);
	}

	/**
	 * 查询
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Message query(Message message) throws IOException,
			ClassNotFoundException {
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(message);
		out.flush();

		in = new ObjectInputStream(socket.getInputStream());
		Message getMes = (Message) in.readObject();
		return getMes;
	}

	/**
	 * 查询公告
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<Notice> queryNotice(Message message) throws IOException,
			ClassNotFoundException {
		// System.out.println(message.getIdentify());
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(message);
		out.flush();

		in = new ObjectInputStream(socket.getInputStream());
		List<Notice> notices = (List<Notice>) in.readObject();
		return notices;
	}
}
