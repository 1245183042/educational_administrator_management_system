package com.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBOperation {

	private String poolAliasName; // 数据库连接池别名
	private Connection conn = null;

	public DBOperation(String poolAliasName) {
		this.poolAliasName = poolAliasName;
	}

	/**
	 * 关闭数据库连接
	 */
	public void close() {
		try {
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打开数据库连接
	 * 
	 * @throws SQLException
	 */
	private void open() throws SQLException {
		close();
		this.conn = DBManager.getDBManager().getConnection(this.poolAliasName);
	}

	/**
	 * sql语句参数转化
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private PreparedStatement setPres(String sql,
			HashMap<Integer, Object> params) throws SQLException,
			ClassNotFoundException {
		if (null == params || params.size() < 1) {
			return null;
		}
		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		for (int i = 1; i <= params.size(); i++) {
			if (params.get(i) == null) {
				pstmt.setString(i, "");
			} else if (params.get(i).getClass() == Class
					.forName("java.lang.String")) {
				pstmt.setString(i, params.get(i).toString());
			} else if (params.get(i).getClass() == Class
					.forName("java.lang.Integer")) {
				pstmt.setInt(i, (Integer) (params.get(i)));
			} else if (params.get(i).getClass() == Class
					.forName("java.lang.Long")) {
				pstmt.setLong(i, (Long) (params.get(i)));
			} else if (params.get(i).getClass() == Class
					.forName("java.lang.Double")) {
				pstmt.setDouble(i, (Double) (params.get(i)));
			} else if (params.get(i) == Class.forName("java.lang.Float")) {
				pstmt.setFloat(i, (Float) (params.get(i)));
			} else if (params.get(i) == Class.forName("java.lang.Boolean")) {
				pstmt.setBoolean(i, (Boolean) params.get(i));
			} else if (params.get(i) == Class.forName("java.sql.Date")) {
				pstmt.setDate(i,
						java.sql.Date.valueOf(params.get(i).toString()));
			} else {
				return null;
			}
		}
		return pstmt;
	}

	/**
	 * 执行sql语句，返回影响的行数
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String sql) throws SQLException {
		this.open();
		Statement stmt = conn.createStatement();
		if (null == stmt) {
			return 0;
		}
		return stmt.executeUpdate(sql);
	}

	/**
	 * 执行sql语句，返回影响的行数
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int executeUpdate(String sql, HashMap<Integer, Object> params)
			throws SQLException, ClassNotFoundException {
		this.open();
		PreparedStatement pstmt = setPres(sql, params);
		if (null == pstmt) {
			return 0;
		}
		return pstmt.executeUpdate();
	}

	/**
	 * 执行sql语句，返回结果集
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql) throws SQLException {

		this.open();
		Statement stmt = conn.createStatement();
		if (null == stmt) {
			return null;
		}
		return stmt.executeQuery(sql);
	}

	/**
	 * 执行sql语句，返回结果集
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ResultSet executeQuery(String sql, HashMap<Integer, Object> params)
			throws SQLException, ClassNotFoundException {
		this.open();
		PreparedStatement pstmt = setPres(sql, params);
		if (null == pstmt) {
			return null;
		}
		return pstmt.executeQuery();
	}

}
