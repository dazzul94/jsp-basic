package com.javateam.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB 연결(Connection) 유틸리티(Utility)
 * 
 * @author javateam
 * @since 2021.6.12
 * @version 1.0
 */
public class DbUtil {
	
	// DB 연결법
	// 1. JDBC 직접 연결
	// 2. ODBC 연결
	// 3. DBCP 연결 
	// ex) c3p0, apache DBCP, Hikari CP, WAS별 DBCP
	
	/** JDBC driver class */
	private static final String DRIVER = "org.h2.Driver";
	/** DB URL */
	private static final String URL = "jdbc:h2:tcp://localhost/~/test";
	/** DB account ID */
	private static final String ID = "SA";
	/** DB account PW */
	private static final String PW = "";
	
	/**
	 * DB 연결
	 * 
	 * @return DB 연결 객체
	 */
	public static Connection connect() {
		
		Connection con = null;
		
		// driver 검색/등록
		try {
			Class.forName(DRIVER);
			// DB 연결
			con = DriverManager.getConnection(URL, ID, PW);
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC 드라이버 찾을 수 없음.");
		} catch (SQLException e) {
			System.err.println("DB 연결 실패");
		}
		
		return con;
	} //
	
	/**
	 * DB 연결 해제(반납)
	 * 
	 * @param con DB 연결 객체
	 * @param pstmt DB SQL 처리 객체
	 * @param rs SQL 결과셋 객체
	 */
	public static void close(Connection con, 
							 PreparedStatement pstmt,
							 ResultSet rs) {
		try {
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (con!=null) con.close();
			// if (con.isClosed()==false) con.close();
		} catch (SQLException e) {
			System.err.println("DB 자원 반납 실패");
			e.printStackTrace();
		}
	} //

}