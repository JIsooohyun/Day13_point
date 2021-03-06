package com.sh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBConnector {  //DB연결과 종료

	public static Connection getConnect() throws Exception{
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection conn = null;
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public static void disConnect(PreparedStatement st, Connection conn) throws Exception{
		st.close();
		conn.close();
	}
	
	public static void disConnect(PreparedStatement st, Connection conn, ResultSet rs) throws Exception{
		DBConnector.disConnect(st, conn);
		rs.close();
		
	}
}
