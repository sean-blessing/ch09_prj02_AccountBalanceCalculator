package business;

public class SavingsAccount extends Account {
	private double monthlyInterestRate = 0.0;
	private double monthlyInterestPayment = 0.0;
	
	public SavingsAccount(double inMonthlyInterestRate) {
		monthlyInterestRate = inMonthlyInterestRate;
	}
	
	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}

	public void setMonthlyInterestPayment() {
		this.monthlyInterestPayment = monthlyInterestPayment;
	}

	public void applyMonthlyInterestPayment() {
		monthlyInterestPayment = balance*monthlyInterestRate;
		balance+=monthlyInterestPayment;
	}
}
