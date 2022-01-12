package CST8284_21S_Assignment2;
/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: LendingLibraryController
Date: July 20, 2021
*/

import java.util.Scanner;

public class LendingLibraryController {

	private LendingLibrary bookLib;
	private static Scanner input;
	
	public LendingLibraryController() {
		bookLib = new LendingLibrary();
		input = new Scanner(System.in);
	}
	
	public void addUser() {
		System.out.println("Enter User Entry\n");
		String lastName = getResponseTo("Last name\n");
		String firstName = getResponseTo("First name\n");
		String age = getResponseTo("Age\n");
		String address = getResponseTo("Address\n");
			
		if(isValidNumber(age)) {
			User u = new User(firstName, lastName, address, Integer.parseInt(age));
			if (bookLib.addUser(u)) {
				System.out.println("User was added\n");
			}else{
				System.out.println("User not added\n");
			}
		}else {
			System.out.println("Not a valid age\n");
		}
	}
	
	public void changeUser() {
		System.out.println("Modify user Information\n");
		String lastName = getResponseTo("Last name\n");
		String firstName = getResponseTo("First name\n");
		User u = bookLib.findUser(firstName, lastName);
		if (u != null) {
			String address = getResponseTo("Enter new address\n");
			u.setAddress(address);
		}else {
			System.out.println("User does not exist\n");
		}
	}
	
	public void findUser() {
		System.out.println("Find user\n");
		String lastName = getResponseTo("Last name\n");
		String firstName = getResponseTo("First name\n");
		User u = bookLib.findUser(firstName, lastName);
		if(u != null) {
			System.out.println(u.toString()+"\n");
		} else {
			System.out.println("No users found\n");
		}
	}
	
	public void listUsers() {
		int i = 1;
		if(bookLib.getUserReg().size() != 0) {
			for(User u : bookLib.getUserReg()) {
				System.out.println("User#" + i);
				System.out.println(u.toString());
				i++;
			}
			System.out.println();
		}else {
			System.out.println("No users found\n");
		}
	}
	
	public void addBook() {
		System.out.println("New Book Entry\n");
        String title = getResponseTo("Title:\n");
        String author = getResponseTo("Author:\n");
        String pub = getResponseTo("Publication date (year in NNNN format)\n");
        String isbn = getResponseTo("ISBN number (10 digits)\n");
        Book b = new Book(title, author, isbn, pub);
        if (b.verifyISBNNumber(isbn)) {
            if (isValidNumber(pub) && pub.length() == 4) {
                if (bookLib.addBook(b)) {
                    System.out.println("Book is added\n");
                } else {
                    System.out.println("Book was not added. Array is full\n");
                }
            } else {
                System.out.println("Invalid publication date\n");
            }
        } else {
            System.out.println("Invalid ISBN number\n");
          }
    }
	
	
	public void changeBook() {
		System.out.println("Change Book info\n");
        String isbn = getResponseTo("Enter isbn number:\n");
        Book b = bookLib.findBook(isbn);
        if (b != null) {
            String author = getResponseTo("Enter author:\n");
            String title = getResponseTo("Enter title\n");
            String pub = getResponseTo("Enter pub date\n");
            if (isValidNumber(pub) && pub.length() == 4) {
                b.setAuthor(author);
                b.setTitle(title);
                b.setPublicationDate(pub);
                System.out.println("Book changed.\n");
            } else {
                System.out.println("Invalid publication date\n");
            }
        } else {
            System.out.println("Could not find a book with this isbn!\n");
        }
    }
	
	public void findBook() {
		System.out.println("Find Book info\n");
        String isbn = getResponseTo("Enter isbn number:\n");
		Book b = bookLib.findBook(isbn);
		if(b != null) {
			System.out.println(b.toString());
			System.out.println();
		} else {
			System.out.println("No book with this isbn number\n");
		}
	}
	
	public void listBooks() {
		System.out.println("List all books\n");
		int i = 1;
		if(bookLib.getBookReg().size() != 0) {
			for (Book b : bookLib.getBookReg()) {
				System.out.println("Book#" + i);
				System.out.println(b.toString());
				i++;
			}
			System.out.println();
		} else {
			System.out.println("No books registered\n");
		}
	}
	
	public void addBookLoan() {
		System.out.println("New Loan Entry\n");
        String lastName = getResponseTo("User last name:\n");
        String firstName = getResponseTo("User first name:\n");
        String isbn = getResponseTo("Book isbn number\n");

        Book b = bookLib.findBook(isbn);
        if (b == null) {
            System.out.println("Could not find a book with this isbn!\n");
        } else {
            String date = getResponseTo("Loan date (format yyyy-mm-dd)\n");
            User u = bookLib.findUser(firstName, lastName);
            if (u != null) {
                if (bookLib.userCanBorrow(u)) {
                    if (!bookLib.isBookLoaned(b)) {
                        BookLoan bl = new BookLoan(u, b, date);
                        if (bookLib.addLoan(bl)) {
                            System.out.println("Loan added.\n");
                            System.out.println(bl.toString()+"\n");
                        } else {
                            System.out.println("Loan was not added. Array is full\n");
                        }
                    } else {
                        System.out.println("Book is already loaned.\n");
                    }
                } else {
                    System.out.println("This user is not allowed to borrow more books.\n");
                }
            } else {
                System.out.println("No user with this name!\n");
            }
        }
    }
	
	public void changeBookLoan() {
		System.out.println("Modify loan details\n");

        String isbn = getResponseTo("ISBN number for the loan you want to modify:\n");
        BookLoan bl = bookLib.findLoan(isbn);
        if (bl != null) {
            System.out.println(bl.toString());
            String date = getResponseTo("Change due date (Hit Enter key for no change)\n");
            bl.setDueDate(date);
            System.out.println("Book loan date changed.\n");
        } else {
            System.out.println("No book loan found with this isbn number.\n");
        }
    }

    public void findBookLoan() {
        String isbn = getResponseTo("Find a book loan. Enter ISBN number:\n");
        BookLoan bl = bookLib.findLoan(isbn);
        if (bl != null) {
            System.out.println(bl.toString()+"\n");
        } else {
            System.out.println("No book loan found with this isbn number.\n");
        }

    }
	
	public void listBookLoans() {
		System.out.println("List all loans\n");
		int i = 1;
		if(bookLib.getLoanReg().size() != 0) {
			for (BookLoan bl : bookLib.getLoanReg()) {
				System.out.println("Loan#" + i);
				System.out.println(bl.toString());
				i++;
			}
			System.out.println();
		} else {
			System.out.println("No loans registered\n");
		}
	}
	
	public void deleteUser() {
		String lastName = getResponseTo("Last Name:\n");
		String firstName = getResponseTo("First Name:\n");
		if(bookLib.deleteUser(firstName, lastName)) {
			System.out.println("User deleted");
		}else {
			System.out.println("Could not delete user\n");
		}
	}
	
	public void deleteBook() {
		String isbn = getResponseTo("Enter isbn Number:\n");
		if(bookLib.deleteBook(isbn)) {
			System.out.println("Book Deleted\n");
		}else {
			System.out.println("Could not delete book\n");
		}
	}
	
	public void deleteBookLoan() {
		String isbn = getResponseTo("Enter ISBN number:\n");
		if (bookLib.deleteLoan(isbn)) {
			System.out.println("Loan deleted\n");
		} else {
			System.out.println("Could not delete loan\n");
		}
	}

	private static String getResponseTo(String s) {
		System.out.print(s);
		return(input.nextLine());
	}
		
	private static Boolean isValidNumber(String input) {
		if (input == null) {
			return false;
		}
		
		try {
			int i = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
		}
	
	private boolean verifyISBNNumber(String n) {
		return n.length() == 10;
	}
	
}

