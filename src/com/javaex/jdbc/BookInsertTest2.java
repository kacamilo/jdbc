package com.javaex.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsertTest2 {

	public static void main(String[] args) {
		
		//JDBC를 이용한 데이터 베이스 연결방법	
			
			//0. import java.sql.*;
			//1. JDBC 드라이버 (Oracle) 로딩
			//2. Connection 얻어오기
			//3. SQL문 준비 / 바인딩 / 실행
			//4.결과처리
			//5. 자원정리

		//0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속 성공");
			
			//2-1. commit 설정 변경
			conn.setAutoCommit(false);
			
			
			
			//3. SQL문 준비 / 바인딩 / 실행
			
			// 공통
			String query = "";
			query += "INSERT INTO book VALUES (seq_book_id.nextval, ?, ?, ?, ?)";  // 쿼리문 문자열 만들기 ___어떤게 들어올지 모르니 ? 로 표시한다.
			System.out.println(query);
			pstmt = conn.prepareStatement(query); 			//쿼리 미리 만들기
			
			// -정보등록
			pstmt.setString(1, "26년");								//?(물음표)중 1번째, 순서 중요
			pstmt.setString(2, "재미주의");							//?(물음표)중 2번째, 순서 중요
			pstmt.setString(3, "2012-02-04");					//?(물음표)중 3번째, 순서 중요
			pstmt.setInt(4, 5 );										//?(물음표)중 4번째, 순서 중요
			int count = pstmt.executeUpdate();
			System.out.println(count);
			
			// +정보등록
			pstmt.setString(1, "+26년");								//?(물음표)중 1번째, 순서 중요
			pstmt.setString(2, "+재미주의");							//?(물음표)중 2번째, 순서 중요
			pstmt.setString(3, "+2012-02-04");						//?(물음표)중 3번째, 순서 중요
			pstmt.setInt(4, 1000 );											//?(물음표)중 4번째, 순서 중요
			
			int count2 = pstmt.executeUpdate();
			System.out.println(count2);
			
			
			//4.결과처리
			//System.out.println(count + "건 처리되었습니다.");
			conn.commit();
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		    try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		} finally {
		   
		    // 5. 자원정리
		    try {                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}

		
		
	}

}
