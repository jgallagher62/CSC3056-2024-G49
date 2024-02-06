package tests;

import java.util.Date;

import model.Transaction;

public class TransactionTest {
	
	public static void main(String[] args) {
		Transaction testTransaction = new Transaction("6601", 1200, new Date("01/01/2021"));
		
		System.out.println(testTransaction);
	}
}	
