package com.edu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * �������ϵͳ�����
 * @author chen7
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(11111);
		List<Socket> serverSocketList = new ArrayList<Socket>();
		while(true){
			Socket serverSocket = server.accept();
			
		}
		
	}
}
