package com.javaex.author01;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		AuthorDao authorDao = new AuthorDao();
			
		// 등록
//		authorDao.authorInsert("이문열", "경북영양");
//		authorDao.authorInsert("박경리", "경상남도 통영");
//		authorDao.authorInsert("유시민", "17대 국회의원");
//		authorDao.authorInsert("기안84", "'기안동에서 산 84년생");
		
		
		// 수정
//		authorDao.authorUpdate(2, "수정-박경리", "수정-경상남도 통영");
		
		// 삭제
		authorDao.authorDelete(1);
				
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
