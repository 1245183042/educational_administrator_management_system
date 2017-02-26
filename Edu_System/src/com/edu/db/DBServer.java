package com.edu.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 提供数据库业务（CRUD）
 * 
 * @author chen7
 * 
 */
public class DBServer {

	private DBOperation dbOperation;

	public DBServer(String poolAliasName) {
		dbOperation = new DBOperation(poolAliasName);
	}

	/**
	 * 关闭数据库
	 */
	public void close() {
		dbOperation.close();
	}

	/**
	 * 数据库增加操作
	 * 
	 * @param tableName
	 * @param columns
	 * @param params
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insert(String tableName, String columns,
			HashMap<Integer, Object> params) throws ClassNotFoundException,
			SQLException {
		String sql = insertSql(tableName, columns);
		return dbOperation.executeUpdate(sql, params);
	}

	/**
	 * 数据库删除操作
	 * 
	 * @param tableName
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public int delete(String tableName, String condition) throws SQLException {
		if (null == tableName) {
			return 0;
		}
		String sql = "delete from " + tableName + " " + condition;
		return dbOperation.executeUpdate(sql);
	}

	/**
	 * 数据库更新操作
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public int update(String sql) throws SQLException {
		return dbOperation.executeUpdate(sql);
	}

	/**
	 * 数据库更新操作
	 * 
	 * @param tableName
	 * @param columns
	 * @param condition
	 * @param params
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int update(String tableName, String columns, String condition,
			HashMap<Integer, Object> params) throws ClassNotFoundException,
			SQLException {
		String sql = updateSql(tableName, columns, condition);
		return dbOperation.executeUpdate(sql, params);
	}

	/**
	 * 数据库查询操作
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select(String sql) throws SQLException {
		return dbOperation.executeQuery(sql);
	}

	/**
	 * 数据库查询操作
	 * 
	 * @param tableName
	 * @param columns
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select(String tableName, String columns, String condition)
			throws SQLException {
		String sql = "select " + columns + " from " + tableName + " "
				+ condition;
		return dbOperation.executeQuery(sql);
	}

	/**
	 * 组装update sql
	 * 
	 * @param tableName
	 * @param columns
	 * @param condition
	 * @return
	 */
	private static String updateSql(String tableName, String columns,
			String condition) {
		if (null == tableName || null == columns) {
			return "";
		}
		String[] column = columns.split(",");
		StringBuilder sb = new StringBuilder("");
		sb.append("update ");
		sb.append(tableName);
		sb.append(" set ");
		sb.append(column[0]);
		sb.append("=?");
		for (int i = 1; i < column.length; i++) {
			sb.append(", ");
			sb.append(column[i]);
			sb.append("=?");
		}
		sb.append(" ");
		sb.append(condition);
		return sb.toString();
	}

	/**
	 * 组装insert sql
	 * 
	 * @param tableName
	 * @param columns
	 * @return
	 */
	private String insertSql(String tableName, String columns) {
		if (null == tableName || null == columns) {
			return "";
		}
		int n = columns.split(",").length;
		StringBuilder sb = new StringBuilder("");
		sb.append("insert into ");
		sb.append(tableName);
		sb.append("(");
		sb.append(columns);
		sb.append(") values(?");
		for (int i = 1; i < n; i++) {
			sb.append(",?");
		}
		sb.append(")");
		return sb.toString();
	}

}
