package com.edu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.edu.server.service.ServerThread;

/**
 * 教务管理系统服务端
 * 
 * @author chen7
 * 
 */
public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(11111);
		while (true) {
			Socket serverSocket = server.accept();
			new ServerThread(serverSocket).start();
		}
	}
}
