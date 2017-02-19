package com.edu.server.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {

	public static Connection getConn(String driverName, String url,
			String user, String password) throws ClassNotFoundException,
			SQLException {
		Class.forName(driverName);
		return DriverManager.getConnection(url, user, password);
	}
}
