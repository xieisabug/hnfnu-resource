package com.hnfnu.zyw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() throws ClassNotFoundException,
			Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://125.221.193.205:3306/hnfnuzyw"; // 这个没有验证，错误了要更正。
		String user = "root";
		String password = "640310";

		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static void closeAll(Connection conn, PreparedStatement ps,
			ResultSet rs) throws SQLException {
		if (conn != null)
			conn.close();
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
	}

}