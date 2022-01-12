package CST8284_21S_Assignment2;
/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: Book
Date: July 20, 2021
*/

public class Book {

	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;
	
	public Book(String title, String author, String isbn, String pubDate) {
		this.title = title;
		this.author = author;
		this.isbnNumber = isbn;
		this.publicationDate = pubDate;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	public boolean verifyISBNNumber(String s) {
		return s.length() == 10;
	}


	public String toString() {
		return "********** Book Title:" + getTitle() + "\n" + "********** Author:" + getAuthor()
				+ "\n" + "********** Publication Year:" + getPublicationDate() + "\n" + "********** ISBN:" + getIsbnNumber() + "\n";
	}
	
	public boolean equals(Object o) {
		final Book b = (Book) o;
		if(getTitle() == b.getTitle()
				&& getAuthor() == b.getAuthor()
				&& getIsbnNumber() == b.getIsbnNumber()
				&& getPublicationDate() == b.getPublicationDate()) {
		return true;
	}else {
		return false;	
		}
	}		
}		
	

