package com.javaex.author01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

	// 필드

	// 생성자
	public AuthorDao() {
	}

	// g/s

	// 일반 메소드

	// 작가 추가
	public void authorInsert(String authorName, String authorDesc) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속 성공");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "INSERT INTO author VALUES (seq_author_id.nextval, ?, ? )"; // 쿼리문 문자열 만들기 ___어떤게 들어올지 모르니 ?
																						// 로 표시한다.
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, authorName); // ?(물음표)중 1번째, 순서 중요
			pstmt.setString(2, authorDesc); // ?(물음표)중 2번째, 순서 중요

			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 처리되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
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

	// 작가 수정
	public void authorUpdate(int authorId, String authorName, String authorDesc) {
		// 0. import java.sql.*;
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				
				
				try {
				    // 1. JDBC 드라이버 (Oracle) 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");

				    // 2. Connection 얻어오기
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					conn = DriverManager.getConnection(url, "webdb", "1234");
					System.out.println("접속성공");
					
				    // 3. SQL문 준비 / 바인딩 / 실행
					String query = ""; //쿼리문 문자열만들기, ? 주의
					query +=" update author ";
					query +=" set author_name = ? ";
					query +=" , author_desc = ? ";
					query +=" where author_id = ? ";

					pstmt = conn.prepareStatement(query); //쿼리로 만들기
					
					pstmt.setString(1, authorName);
					pstmt.setString(2, authorDesc);
					pstmt.setInt(3, authorId);

					int count = pstmt.executeUpdate();  //쿼리문 실행
					
				    // 4.결과처리
					System.out.println(count + "건 처리되었습니다.");
					
					
				} catch (ClassNotFoundException e) {
				    System.out.println("error: 드라이버 로딩 실패 - " + e);
				} catch (SQLException e) {
				    System.out.println("error:" + e);
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

	// 작가 삭제
	public void authorDelete (int authorId) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
			System.out.println("접속성공");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " delete from author ";
			query += " where author_id = ? ";
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			
			pstmt.setInt(1, authorId) ;// ?(물음표) 중 1번째, 순서중요

			
			int count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			System.out.println(count + "건 처리되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
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
	
	// 작가 리스트
	public List<AuthorVo> getAuthorList() {
		List<AuthorVo> list = new ArrayList<AuthorVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "1234");
			System.out.println("접속 성공");

			// 3. SQL문 준비 / 바인딩 / 실행 --> 완성된 sql문을 가져와서 작성할 것
			String query = "";
			query += " select  author_id, ";
			query += "         author_name, ";
			query += "         author_desc ";
			query += " from author";

			System.out.println(query);

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery(); // select

			// 4.결과처리
			while (rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");

				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);

				list.add(authorVo);
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
		return list;
	}
}
