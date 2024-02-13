package tests;

import java.util.Date;
import model.Account;

public class AccountTest {
	
	//test the constructor of account, using all its getter methods 
	
	public static void main(String[] args) {
		testConstructor();
		testSetters();
		
	}
	
	private static void testConstructor() {
		String testAccountNumber = "123456";
		String testUsernameOfAccountHolder = "Laura";
		String testAccountType = "Savings";
		//reference = chat gpt for working out the date field
		Date testAccountOpeningDate = new Date(2017, 2, 1);
		
		Account testAccount = new Account (testAccountNumber, testUsernameOfAccountHolder, testAccountType, testAccountOpeningDate);
		
		boolean passed = true;
		
		
		if(testAccount.getAccountNumber() != testAccountNumber) {
			System.out.println("TC1 failed: account number did not match");
			passed= false;
		}
		
		if(testAccount.getUsernameOfAccountHolder() != testUsernameOfAccountHolder) {
			System.out.println("TC2 failed: username of account holder did not match");
			passed= false;
		}
		
		if(testAccount.getAccountType() != testAccountType) {
			System.out.println("TC3 failed: account type did not match");
			passed= false;
		}
		
		if(testAccount.getAccountOpeningDate() != testAccountOpeningDate) {
			System.out.println("TC4 failed: account opening date did not match");
			passed= false;
		}
	

		assert testAccount.getAccountNumber() == testAccountNumber;
		assert testAccount.getUsernameOfAccountHolder() == testUsernameOfAccountHolder;
		assert testAccount.getAccountType() == testAccountType;
		assert testAccount.getAccountOpeningDate() == testAccountOpeningDate;
		
		if(passed)
			System.out.println("All (testConstructor) TC's Passed");
	}
	
	
	
	public static void testSetters() {
	    String testAccountNumber = "123456";
	    String testUsernameOfAccountHolder = "Laura";
	    String testAccountType = "Savings";
	    Date testAccountOpeningDate = new Date(2017, 2, 1);
	    
	    Account testAccount = new Account(testAccountNumber, testUsernameOfAccountHolder, testAccountType, testAccountOpeningDate);

	    // Set new values using setter methods
	    String newAccountNumber = "654321";
	    String newUsername = "Jennifer";
	    String newAccountType = "Current";
	    //reference = chat gpt for working out the date field
	    Date newOpeningDate = new Date(2022, 1, 1);

	    testAccount.setAccountNumber(newAccountNumber);
	    testAccount.setUsernameOfAccountHolder(newUsername);
	    testAccount.setAccountType(newAccountType);
	    testAccount.setAccountOpeningDate(newOpeningDate);
	    
	    boolean passed = true;

	    if (testAccount.getAccountNumber() != (newAccountNumber)) {
	        System.out.println("TC5 failed: account number did not match");
	        passed = false;
	    }
	    
	    if (testAccount.getUsernameOfAccountHolder() !=(newUsername)) {
	        System.out.println("TC6 failed: username of account holder did not match");
	        passed = false;
	    }
	    
	    if (testAccount.getAccountType() != (newAccountType)) {
	        System.out.println("TC7 failed: account type did not match");
	        passed = false;
	    }
	    
	    
	    if (testAccount.getAccountOpeningDate() != (newOpeningDate)) {
	        System.out.println("TC8 failed: account opening date did not match");
	        passed = false;
	    }

	    if(passed) {
	    	System.out.println("All (testSetters) TC's Passed");
	    }
	}
}