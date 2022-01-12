package CST8284_21S_Assignment2_Test;

/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: UserTest
Date: July 20, 2021
*/


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CST8284_21S_Assignment2.User;

public class UserTest {

	private int DEFAULT_ID = 1000;
	private String DEFAULT_FIRST_NAME = "Jules";
	private String DEFAULT_LAST_NAME = "Sebastian";
	private String DEFAULT_ADDRESS = "100 Woodroffe Ave";
	private int DEFAULT_AGE = 78;

	private User myUser;
	private String OTHER_ADDRESS = "200 Woodroffe Ave";

	@Before
	public void setUp() throws Exception {
		myUser = new User(DEFAULT_ID, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_ADDRESS, DEFAULT_AGE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId_True() {
		assertTrue(String.valueOf(myUser.getId()).equals(String.valueOf(DEFAULT_ID)));
	}

	@Test
	public void testGetId_False() {
		assertFalse(String.valueOf(myUser.getId()).equals(""));
	}

	@Test
	public void testGetFirstName_True() {
		assertTrue(myUser.getFirstName().equals(DEFAULT_FIRST_NAME));
	}

	@Test
	public void testGetFirstName_False() {
		assertFalse(myUser.getFirstName().equals(""));
	}

	@Test
	public void testGetLastName_True() {
		assertTrue(myUser.getLastName().equals(DEFAULT_LAST_NAME));
	}

	@Test
	public void testGetLastName_False() {
		assertFalse(myUser.getLastName().equals(""));
	}

	@Test
	public void testGetAddress_True() {
		assertTrue(myUser.getAddress().equals(DEFAULT_ADDRESS));
	}

	@Test
	public void testGetAddress_False() {
		assertFalse(myUser.getAddress().equals(""));
	}

	@Test
	public void testGetAge_True() {
		assertTrue(String.valueOf(myUser.getAge()).equals(String.valueOf(DEFAULT_AGE)));
	}

	@Test
	public void testGetAge_False() {
		assertFalse(String.valueOf(myUser.getAge()).equals(""));
	}

	@Test
	public void testEqualsObject_True() {
		User u = new User(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_ADDRESS, DEFAULT_AGE);
		assertTrue(myUser.equals(u));
	}

	@Test
	public void testEqualsObject_False() {
		User u = new User(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, OTHER_ADDRESS, DEFAULT_AGE);
		assertFalse(myUser.equals(u));
	}

}
