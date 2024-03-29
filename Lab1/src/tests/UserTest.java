package tests;

import model.User;
import utils.TestUtils;

public class UserTest {


	public static void main(String[] args) {
	    	testUserConstructor();
	    }


	public static void testUserConstructor() {
		// Old manual testing = works correctly to the eye
		
		//User testUser = new User ("mike", "myPasswd", "Mike", "Smith", "07771234567");
		//System.out.println(testUser);
		
		String testUsername = "mike";
		String testPassword = "my_passwd";
		String testFirstName = "Mike";
		String testLastName = "Smith";
		String testMobileNumber = "07771234567";
		
		User testUser = new User (testUsername, testPassword, testFirstName, testLastName, testMobileNumber );
		
		/*
		 * System.out.
		 * println("Starting the assertions of the test method: testUserConstructor");
		 * 
		 * //if(testUser.getUsername() != testUsername) - intentional defect entered
		 * into the code commented out and fixed if(testUser.getUsername() ==
		 * testUsername) System.out.println(TestUtils.TEXT_COLOR_GREEN +
		 * "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET); else
		 * System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" +
		 * TestUtils.TEXT_COLOR_RESET);
		 * 
		 * if(testUser.getPassword()== testPassword)
		 * System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword_Passed" +
		 * TestUtils.TEXT_COLOR_RESET); else System.out.println(TestUtils.TEXT_COLOR_RED
		 * + "TC2-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		 * 
		 * //TODO1.1 - get first name if(testUser.getFirstName()== testFirstName)
		 * System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirstName-Passed" +
		 * TestUtils.TEXT_COLOR_RESET); else System.out.println(TestUtils.TEXT_COLOR_RED
		 * + "TC3-getFirstName-FAILED" + TestUtils.TEXT_COLOR_RESET);
		 * 
		 * 
		 * //TODO1.2 - get last name if(testUser.getLastName()== testLastName)
		 * System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLastName-Passed" +
		 * TestUtils.TEXT_COLOR_RESET); else System.out.println(TestUtils.TEXT_COLOR_RED
		 * + "TC4-getLastName-FAILED" + TestUtils.TEXT_COLOR_RESET);
		 * 
		 * 
		 * //TODO1.3 - get mobile number if(testUser.getMobileNumber()==
		 * testMobileNumber) System.out.println(TestUtils.TEXT_COLOR_GREEN +
		 * "TC5-getMobileNumber-Passed" + TestUtils.TEXT_COLOR_RESET); else
		 * System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobileNumber-FAILED" +
		 * TestUtils.TEXT_COLOR_RESET);
		 */
		
		
		
		boolean passed = true;
		
		
		if(testUser.getUsername() != testUsername) {
			System.out.println("TC1 failed: username did not match");
			passed= false;
		}
		
		if(testUser.getPassword() != testPassword) {
			System.out.println("TC2 failed: password did not match");
			passed= false;
		}
		
		if(testUser.getFirstName() != testFirstName) {
			System.out.println("TC3 failed: firstname did not match");
			passed= false;
		}
		
		if(testUser.getLastName() != testLastName) {
			System.out.println("TC4 failed: lastname did not match");
			passed= false;
		}
		
		if(testUser.getMobileNumber() == testMobileNumber) {
			System.out.println("TC5 failed: mobile number did not match");
			passed= false;
		}
		
		

		assert testUser.getUsername() == testUsername;
		assert testUser.getPassword() == testPassword;
		assert testUser.getFirstName() == testFirstName;
		assert testUser.getLastName() == testLastName;
		assert testUser.getMobileNumber() == testMobileNumber;
		
		if(passed)
			System.out.println("All TC's Passed");
		
		System.out.println("All Java assertions in the test suite passed(none have failed)");
	
	}
	
	
	
	
	
}	
