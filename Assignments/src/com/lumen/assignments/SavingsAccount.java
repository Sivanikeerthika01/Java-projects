package com.lumen.assignments;

public class SavingsAccount  extends Account{

	public SavingsAccount(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	void withdraw(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Withdrwaing amount: "+amount);
		this.balance=this.balance-amount;
		System.out.println("After savings: "+this.balance);
	}

	@Override
	void deposit(double amount) {
		System.out.println("Depositing amount: "+amount);
		this.balance=this.balance+amount;
		System.out.println("After savings deposit: "+this.balance);
		
	}

}
