package org.me.util.db.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExecute {
	/**
	 * 查询结果集
	 * @author: cheng_bo
	 * @date: 2015年7月14日 17:19:38
	 */
	public ResultSet query(PreparedStatement pstmt) {
		ResultSet rs=null;
		if(pstmt==null)
			return rs;
		try {
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		return rs;
	}
	
	/**
	 * 更新
	 * @author: cheng_bo
	 * @date: 2015年7月14日 18:08:29
	 */
	public int update(PreparedStatement pstmt) {
		int i=0;
		if(pstmt == null)
			return i;
		try {
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
}