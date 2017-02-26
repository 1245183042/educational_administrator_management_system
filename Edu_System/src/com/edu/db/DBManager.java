package com.edu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

/**
 * 数据库连接池管理
 * 
 * @author chen7
 * 
 */
public class DBManager {

	private DBManager() {
		try {
			JAXPConfigurator.configure(DBPool.getDBPool().getPoolPath(), false);
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static class DBManagerDao {
		private static DBManager dbManager = new DBManager();
	}

	public static DBManager getDBManager() {
		return DBManagerDao.dbManager;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @param poolName
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String poolName) throws SQLException {
		return DriverManager.getConnection(poolName);

	}
}
