package com.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	
	//싱글 톤 패턴...
	// 기본 생성자 빠른 생성 -> 퍼블릭 프라이빗으로 바꿔버리기
	private DataBaseConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static DataBaseConnection connection
					= new DataBaseConnection();
	
	public static DataBaseConnection getInstance() {
		return connection;
	}
	
	
	//Connection 객체를 리턴하는 메서드
	public Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521";
		String uid = "hr";
		String upw = "hr";
		
		return DriverManager.getConnection(url, uid, upw); 
		//예외처리 거기서 해라~ throws로 붙이기.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
