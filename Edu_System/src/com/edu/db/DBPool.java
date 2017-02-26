package com.edu.db;

import com.edu.util.ClassUtil;

/**
 * 管理数据库连接池的配置文件
 * 
 * @author chen7
 * 
 */
public class DBPool {

	private DBPool() {
	}

	private static class DBPoolDao {
		private static DBPool DBPool = new DBPool();
	}

	public static DBPool getDBPool() {
		return DBPoolDao.DBPool;
	}

	private String poolPath;// 数据库连接池配置文件的路径

	public String getPoolPath() {
		if (poolPath == null) {
			poolPath = ClassUtil.getClassPath(DBPool.class) + "proxool.xml";
		}
		return poolPath;
	}
}
