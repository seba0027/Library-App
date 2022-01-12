package CST8284_21S_Assignment2;
/*
Class: CST8284_302 
Author Name: Jules Sebastian
Class Name: User
Date: July 20, 2021
*/

public class User {

	private static int userNextId = 1000;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;

	public User(int id, String firstName, String lastName, String address, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		userNextId++;
	}

	public User(String firstName, String lastName, String address, int age) {
		this(userNextId, firstName, lastName, address, age);
	}

	public User(String first, String last, String address) {
		this(first, last, address, 18);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "********** User id:" + getId() + "\n" + "********** User name:" + getFirstName() + " " + getLastName()
				+ "\n" + "********** Age:" + getAge() + "\n" + "********** Address:" + getAddress() + "\n";
	}
	
	public boolean equals(Object o) {
		final User u = (User) o;
		if(getFirstName() == u.getFirstName()
				&& getLastName() == u.getLastName()
				&& getAddress() == u.getAddress()
				&& getAge() == u.getAge()) {
			return true;
		}else {
			return false;
		}
	}
}
