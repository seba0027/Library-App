package CST8284_21S_Assignment2;
/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: AppDriver
Date: July 20, 2021
*/

import java.util.Scanner;

public class AppDriver {
	private final static int APP_EXIT = 0;
	private final static int APP_ADD_BOOK = 1;
	private final static int APP_MOD_BOOK = 2;
	private final static int APP_FIND_BOOK = 3;
	private final static int APP_LIST_BOOKS = 4;
	private final static int APP_ADD_USER = 5;
	private final static int APP_MOD_USER = 6;
	private final static int APP_FIND_USER = 7;
	private final static int APP_LIST_USERS = 8;
	private final static int APP_ADD_LOAN = 9;
	private final static int APP_MOD_LOAN = 10;
	private final static int APP_FIND_LOAN = 11;
	private final static int APP_LIST_LOANS = 12;
	private final static int APP_DELETE_USER = 13;
	private final static int APP_DELETE_BOOK = 14;
	private final static int APP_DELETE_BOOK_LOAN = 15;
	
	private Scanner input;
	
	public LendingLibraryController appControl;
	
	public int choice;
	
	public void startApp() {
		appControl = new LendingLibraryController();
		input = new Scanner(System.in);
		
		do {
			choice = displayAppMenu();
			executeMenuItem();
		} while(choice != APP_EXIT);
	}
	
	public int displayAppMenu() {
		System.out.println("Enter a selection from the following menu:\n"
				+ "1. Enter a new book\n"
				+ "2. Modify the book details. Enter the book isbn number\n"
				+ "3. Find a book by isbn number\n"
				+ "4. Display list of all books\n\n"
				+ "5. Add a new user\n"
				+ "6. Modify user details\n"
				+ "7. Find a user by name\n"
				+ "8. Display all users\n\n"
				+ "9. Add a loan. Link a user name to abook by isbn number\n"
				+ "10. Modify a loan. Loan is identified by isbn number\n"
				+ "11. Find a loan. Loan is identified by isbn number\n"
				+ "12. Display all loans\n\n"
				+ "13. Delete a user\n"
				+ "14. Delete a book\n"
				+ "15. Delete a loan\n\n"
				+ "0. Exit program");
		return (input.nextInt());
	}
	
	public void executeMenuItem() {
		switch(choice) {
		case APP_ADD_BOOK:
			appControl.addBook();
			break;
		case APP_MOD_BOOK:
			appControl.changeBook();
			break;
		case APP_FIND_BOOK:
			appControl.findBook();
			break;
		case APP_LIST_BOOKS:
			appControl.listBooks();
			break;
		case APP_ADD_USER:
			appControl.addUser();
			break;
		case APP_MOD_USER:
			appControl.changeUser();
			break;
		case APP_FIND_USER:
			appControl.findUser();
			break;
		case APP_LIST_USERS:
			appControl.listUsers();
			break;
		case APP_ADD_LOAN:
			appControl.addBookLoan();
			break;
		case APP_MOD_LOAN:
			appControl.changeBookLoan();
			break;
		case APP_FIND_LOAN:
			appControl.findBookLoan();
			break;
		case APP_LIST_LOANS:
			appControl.listBookLoans();
			break;
		case APP_DELETE_USER:
			appControl.deleteUser();
			break;
		case APP_DELETE_BOOK:
			appControl.deleteBook();
			break;
		case APP_DELETE_BOOK_LOAN:
			appControl.deleteBookLoan();
			break;
		case APP_EXIT:
			System.out.println("Good bye");
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
}