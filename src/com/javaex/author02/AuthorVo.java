package com.javaex.author02;

public class AuthorVo {

	
	// 	VO 는 로직이 없는 순수한 데이터 객체
	//	속성과 속성에 접근하기 위한 GETTER, SETTER, 메소드만 가지고있음
	
	
	//필드
	private int authorId;
	private String authorName;
	private String authorDesc;
	
	//생성자
	// APP 등록 형식 String형 두개
	public AuthorVo(String authorName, String authorDesc) {
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	
	
	
	// APP 등록 형식 String형 세개
		public AuthorVo(int authorId, String authorName, String authorDesc) {
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}

	//g/s
	

	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	
	
	//메소드
	
	//toString
	@Override
	public String toString() {
		return "AuthorVo [authorId=" + authorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	
}
