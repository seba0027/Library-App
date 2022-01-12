package CST8284_21S_Assignment2;

/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: BookLoan
Date: July 20, 2021
*/
public class BookLoan {

	private String dueDate;
	
	private User user;
	
	private Book book;

	public BookLoan(User user, Book book, String dueDate) {
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String toString() {
		return "********** User Name:" + getUser().getFirstName() + " " + getUser().getLastName() + "\n"
				+ "********** Title:" + getBook().getTitle() + "\n" + "********** Author:" + getBook().getAuthor()
				+ "\n" + "********** ISBN:" + getBook().getIsbnNumber() + "\n" + "********** Due Date:" + getDueDate()
				+ "\n";
	}
	
	public boolean equals(Object o) {
		final BookLoan bl = (BookLoan) o;
		if (getBook() == bl.getBook()
				&& getUser() == bl.getUser()
				&& getDueDate() == bl.getDueDate()) {
			return true;
		}else {
			return false;
		}
	}
	
}
