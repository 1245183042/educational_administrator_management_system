package com.edu.client.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.edu.bean.Message;
import com.edu.bean.User;

public class UserModel {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public UserModel() throws UnknownHostException, IOException {
		socket = new Socket("127.0.0.1", 11111);
	}

	/**
	 * 登录验证
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public User loginUser(Message message) throws IOException,
			ClassNotFoundException {
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(message);
		out.flush();

		in = new ObjectInputStream(socket.getInputStream());
		User user = (User) in.readObject();
		return user;
	}
}
