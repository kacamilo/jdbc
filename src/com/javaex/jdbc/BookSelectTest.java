package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelectTest {

	public static void main(String[] args) {

		// 0. import java.sql.*;
		// 1. JDBC 드라이버 (Oracle) 로딩
		// 2. Connection 얻어오기
		// 3. SQL문 준비 / 바인딩 / 실행
		// 4.결과처리
		// 5. 자원정리

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속 성공");

			// 3. SQL문 준비 / 바인딩 / 실행 --> 완성된 sql문을 가져와서 작성할 것
			String query = "";
			query += " select book_id, ";
			query += "	 	  title," ;
			query += "		  pubs, ";
			query += " 		  pub_date";
			query += " 		  author_id";
			query += " from book";
			
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			// 4.결과처리
						while (rs.next()) {
							int bookId = rs.getInt("book_id");
							String Title = rs.getString("title");
							String Pubs = rs.getString("pubs");
							String pubDate = rs.getString("pub_date");
							String authorId = rs.getString("author_id");

							System.out.println(bookId + "\t" + Title + "\t|" + Pubs + "\t|" + pubDate + "\t|" + authorId);
						}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
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