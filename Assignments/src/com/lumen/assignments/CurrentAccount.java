package com.lumen.assignments;

public class CurrentAccount extends Account{
	public CurrentAccount(double balance) {
		super(balance);
	}
	public void withdraw(double amount) {
		System.out.println("Withdraw:"+amount);
		this.balance=this.balance-amount;
		System.out.println("After current account: "+this.balance);
	}
	@Override
	void deposit(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Depositing: "+amount);
		this.balance=this.balance+amount;
		System.out.println("After current deposit"+this.balance);
	}
	

}
