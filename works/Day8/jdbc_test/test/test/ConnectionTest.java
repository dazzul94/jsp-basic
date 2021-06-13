package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javateam.project.util.DbUtil;

public class ConnectionTest {
	
	public static void main(String[] args) {
		
		Connection con = DbUtil.connect();
		System.out.println("con : "+con);

		// Test 테이블에서 name 컬럼(필드)의 "hi"라는 값 추출/비교 테스트
		// select(DQL:Data Query Language) 검색/조회
		
		int id = 1;
		// SQL 구문
		// String sql = "SELECT name FROM test WHERE id=1";
		String sql = "SELECT name FROM test WHERE id=?";
		
		// String sql = "SELECT name FROM test WHERE id="+id;
		// id가 char, varchar 자료형일 경우(문자(열))
		// String sql = "SELECT name FROM test WHERE id='"+id+"'";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// SQL 구문 해석/처리
			// Statement stmt = con.createStatement();
			stmt = con.prepareStatement(sql);
			// 인자 처리
			stmt.setInt(1, id);
			// 결과 처리
			// ResultSet rs = stmt.executeQuery(sql);
			rs = stmt.executeQuery();
			String result = "";
			
			// SQL의 결과(행:row)가 존재하면...
			// if (rs.next()) {
			while (rs.next()) {
				result = rs.getString(1);
				System.out.println("결과 테스트 : " + 
				 result.equals("Hi"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			DbUtil.close(con, stmt, rs);
		} //
		
	} //

}