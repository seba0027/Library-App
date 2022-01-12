package CST8284_21S_Assignment2_Test;

/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: BookTest
Date: July 20, 2021
*/

import CST8284_21S_Assignment2.Book;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookTest {

	private String DEFAULT_ISBN = "9781119499";
	private String DEFAULT_TITLE = "Object Oriented Java";
	private String DEFAULT_AUTHOR = "Walter White";
	private String DEFAULT_PUB_DATE = "2018";

	private String OTHER_ISBN = "97889896745";
	private Book myBook;

	@Before
	public void setUp() throws Exception {
		myBook = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_ISBN, DEFAULT_PUB_DATE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTitle_True() {
		assertTrue(myBook.getTitle().equals(DEFAULT_TITLE));
	}

	@Test
	public void testGetTitle_False() {
		assertFalse(myBook.getTitle().equals(""));
	}

	@Test
	public void testGetAuthor_True() {
		assertTrue(myBook.getAuthor().equals(DEFAULT_AUTHOR));
	}

	@Test
	public void testGetAuthor_False() {
		assertFalse(myBook.getAuthor().equals(""));
	}

	@Test
	public void testGetPublicationDate_True() {
		assertTrue(myBook.getPublicationDate().equals(DEFAULT_PUB_DATE));
	}

	@Test
	public void testGetPublicationDate_False() {
		assertFalse(myBook.getPublicationDate().equals(""));
	}

	@Test
	public void testGetIsbnNumber_True() {
		assertTrue(myBook.getIsbnNumber().equals(DEFAULT_ISBN));
	}

	@Test
	public void testGetIsbnNumber_False() {
		assertFalse(myBook.getIsbnNumber().equals(OTHER_ISBN));
	}

	@Test
	public void testEqualsObject_True() {
		Book b = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_ISBN, DEFAULT_PUB_DATE);
		assertTrue(myBook.equals(b));
	}

	@Test
	public void testEqualsObject_False() {
		Book b = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, OTHER_ISBN, DEFAULT_PUB_DATE);
		assertFalse(myBook.equals(b));
	}

}
