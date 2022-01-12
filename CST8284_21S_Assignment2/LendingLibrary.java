package CST8284_21S_Assignment2;
/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: LendingLibrary
Date: July 20, 2021
*/

import java.util.ArrayList;
public class LendingLibrary {

	private final static int MAX_LOAN_PER_USER = 2;
	
	private ArrayList<Book> bookReg;
	private ArrayList<User> userReg;
	private ArrayList<BookLoan> loanReg;
	
	public LendingLibrary() {
		bookReg = new ArrayList<>();
		userReg = new ArrayList<>();
		loanReg = new ArrayList<>();
		
	}
	
		
	public boolean addUser(User u) {
		if(u != null){
			userReg.add(u);	
			return true;
		}
		return false;
	}
	
	public boolean addBook(Book b) {
		if(b != null){
			bookReg.add(b);
			return true;
		}
		return false;
	}
	
	public boolean addLoan(BookLoan l) {
		if(l != null){
			loanReg.add(l);
			return true;
		}
		return false;
	}
	
	public User findUser(String firstName, String lastName) {
        for(User u : getUserReg()) {
            if(u != null) {
                if(u.getFirstName().equals(firstName) && u.getLastName().equals(lastName)) {
                    return u;
                }
            }
        }
        return null;
    }
	
	public Book findBook(String isbnNumber) {
		for(Book b : getBookReg()) {
            if(b != null) {
                if(b.getIsbnNumber().equals(isbnNumber)) {
                    return b;
                }
            }
        }
        return null;
	}
	
	public BookLoan findLoan(String isbnNumber) {
		for(BookLoan l : getLoanReg()) {
            if(l != null) {
                if(l.getBook().getIsbnNumber().equals(isbnNumber)) {
                    return l;
                }
            }
        }
        return null;
	} 
	
	public boolean deleteUser(String firstName, String lastName) {
		User u = findUser(firstName, lastName);
		if(u != null) {
			int counter = 0;
			for (BookLoan bl : getLoanReg()) {
				if (bl.getUser().equals(u)) {
					counter += 1;
				}
			}
			if (counter == 0) {
				getUserReg().remove(u);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean deleteBook(String isbnNumber) {
		Book b = findBook(isbnNumber);
		if(b != null){
			return (!isBookLoaned(b)) ? getBookReg().remove(b) : false;
		}else {
				return false;
		}
	}
	
	public boolean deleteLoan(String isbnNumber) {
		BookLoan l = findLoan(isbnNumber);
		if (l != null) {
			getLoanReg().remove(l);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean userCanBorrow(User u) {
		int counter = 0;
		for(BookLoan l : getLoanReg()) {
			if (l != null) {
				if (l.getUser().equals(u)) {
					counter++;
				} 
			}
		}
		return counter < MAX_LOAN_PER_USER;
	}
	
	
	public boolean isBookLoaned(Book b) {
		for(BookLoan l : getLoanReg()) {
			if (l != null) {
				if(l.getBook().equals(b)) {
					return true;
				}
			}
		} 
		return false; 
	}

	public ArrayList<Book> getBookReg() {
		return bookReg;
	}

	public void setBookReg(ArrayList<Book> bookReg) {
		this.bookReg = bookReg;
	}

	public ArrayList<User> getUserReg() {
		return userReg;
	}

	public void setUserReg(ArrayList<User> userReg) {
		this.userReg = userReg;
	}

	public ArrayList<BookLoan> getLoanReg() {
		return loanReg;
	}

	public void setLoanReg(ArrayList<BookLoan> loanReg) {
		this.loanReg = loanReg;
	}
	
		
}
