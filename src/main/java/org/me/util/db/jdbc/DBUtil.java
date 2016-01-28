package org.me.util.db.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil{
	private String dbDriver;
	private String dbUrl;
	private String dbUser;
	private String dbPwd;

	public DBUtil(String file) {
		/**
		 * 初始化配置信息
		 */
		InputStream in=getClass().getResourceAsStream(file);
		Properties prop=new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dbDriver = prop.getProperty("Driver");
		dbUrl = prop.getProperty("Url");
		dbUser = prop.getProperty("User");
		dbPwd = prop.getProperty("Password");
	}
	
	
	/**
	 * 获取连接
	 * @author: cheng_bo
	 * @date: 2015年7月14日 16:28:04
	 */
	public Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(dbDriver);
			conn=DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return conn;
		}
		return conn;
	}
	
	/**
	 * 获取preparedStatement
	 * @author: cheng_bo
	 * @date: 2015年7月14日 17:00:35
	 */
	public PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return pstmt;
		}
		return pstmt;
	}
	
	/**
	 * 关闭连接
	 * @author: cheng_bo
	 * @date: 2015年7月14日 16:46:14
	 */
	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭PreparedStatement
	 * @author: cheng_bo
	 * @date: 2015年7月14日 17:09:57
	 */
	public void closePreparedStatement(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}