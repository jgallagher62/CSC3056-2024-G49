package tests;

import model.User;

public class UserTest {
	
	public static void main(String[] args) {
		User testUser = new User ("mike", "myPasswd", "Mike", "Smith", "07771234567");
		
		System.out.println(testUser);
		
	}
}	