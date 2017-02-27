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

}
