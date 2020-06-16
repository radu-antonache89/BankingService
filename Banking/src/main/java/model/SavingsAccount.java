package model;

public class SavingsAccount {
	
	private String userId;
	private double balance;
	private double interestRate = 3.1;
	
	public SavingsAccount() {
    }
	
	public SavingsAccount(String p_id, double p_balance, double p_interestRate) {
		this.userId = p_id;
        this.balance = p_balance;
        this.interestRate = p_interestRate;
    }
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String p_id) {
		this.userId = p_id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double p_balance) {
		this.balance = p_balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double p_interestRate) {
		this.interestRate = p_interestRate;
	}

	public void deposit(double p_amount) {
		this.balance += p_amount;
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
}
