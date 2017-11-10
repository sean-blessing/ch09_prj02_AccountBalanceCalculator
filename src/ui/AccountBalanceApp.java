package ui;
import java.text.NumberFormat;

import business.*;
import util.Console;

public class AccountBalanceApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Account application");
		System.out.println();
		System.out.println("Starting balances");
		
		SavingsAccount sa = new SavingsAccount(.015);
		CheckingAccount ca = new CheckingAccount(1);
		sa.setBalance(1000);
		ca.setBalance(1000);
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("Checking:  "+currency.format(ca.getBalance()));
		System.out.println("Savings:   "+currency.format(sa.getBalance()));
		System.out.println("Enter transactions for the month:");
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			String transType = Console.getString("Withdrawal or Deposit(w/d)?:  ", "w", "d");
			String acctType = Console.getString("Checking or Savings(c/s)?:  ", "c", "s");
			double amount = Console.getDouble("Amount?:  ", 1, 1000);
			Account a = null;
			if (acctType.equals("c")) {
				a = ca;
			}
			else {
				a = sa;
			}
			if (transType.equalsIgnoreCase("w")) {
				a.withdraw(amount);
			}
			else {  // we know transaction is deposit due to previous data validation
				a.deposit(amount);
			}
			
			choice = Console.getString("Continue(y/n)?:  ");
		}

		ca.subtractMonthlyFee();
		sa.applyMonthlyInterestPayment();

		System.out.println("Monthly Payments and Fees:");
		System.out.println("Checking Fee:  "+currency.format(ca.getMonthlyFee()));
		System.out.println("Savings Interest Payment:   "+currency.format(sa.getMonthlyInterestPayment()));
		
		System.out.println("Final Balances:");
		System.out.println("Checking:  "+currency.format(ca.getBalance()));
		System.out.println("Savings:   "+currency.format(sa.getBalance()));
		
		System.out.println("Bye!");
	}

}
