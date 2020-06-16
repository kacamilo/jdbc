package com.javaex.author02;

public class BookVo {

	// 필드
	private int bookId;
	private String bookTitle;
	private String bookPubs;
	private String pubDate;

	// 생성자
	public BookVo(int bookId, String bookTitle, String bookPubs, String pubDate) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPubs = bookPubs;
		this.pubDate = pubDate;
	}

	// g/s

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPubs() {
		return bookPubs;
	}

	public void setBookPubs(String bookPubs) {
		this.bookPubs = bookPubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	
	// 일반 메소드
	
	//toString
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPubs=" + bookPubs + ", pubDate="
				+ pubDate + "]";
	}


}
