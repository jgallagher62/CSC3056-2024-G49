package tests;

import java.util.Date;

import model.Account;

public class AccountTest {
	
	public static void main(String[] args) {
		Account testAccount = new Account("82345", "Lisa", "Savings" ,  new Date("01/02/2023"));
		
		System.out.println(testAccount);
	}
}
