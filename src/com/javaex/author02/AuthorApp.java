package com.javaex.author02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		AuthorDao authorDao = new AuthorDao();
			
		// 등록
		AuthorVo vo01 = new AuthorVo ("이문열", "경북영양" );
		authorDao.authorInsert(vo01);
		
		AuthorVo vo02 = new AuthorVo ("박경리", "경상남도 통영" );
		authorDao.authorInsert(vo02);
	
		// 수정
		AuthorVo vo03 = new AuthorVo(2, "수정-박경리", "수정-경남통영");
		authorDao.authorUpdate(vo03);
		 
		
		AuthorVo vo04 = new AuthorVo(3, "수정-기안84", "수정-기안동");
		authorDao.authorUpdate(vo04);
		
		// 삭제
//		authorDao.authorDelete(1);
				
		// 리스트 가져오기
		List<AuthorVo>authorList = authorDao.getAuthorList();
//		System.out.println(authorList.get(1).getAuthorDesc());
				
		//출력

		for(int i = 0; i < authorList.size(); i++) {
			System.out.println(authorList.get(i).getAuthorId() + ", " + authorList.get(i).getAuthorName() + ", " + authorList.get(i).getAuthorDesc());
		}
		System.out.println("=================================================");
	}

}
