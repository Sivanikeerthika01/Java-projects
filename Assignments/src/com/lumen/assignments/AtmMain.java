package com.lumen.assignments;

import java.util.Scanner;

public class AtmMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter balance");
		double balance=scanner.nextDouble();
		Account account=new SavingsAccount(balance);
		Account account1=new CurrentAccount(balance);
		boolean flag=true;
		while(flag) {
			System.out.println("Welcome to ATM Banking");
			System.out.println("1.Saving\t\t2.Current\t\t3.Exit");
			System.out.println("Enter choice");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
			{
				System.out.println("1.withdraw\n2.deposit\n3.check balance\n4.Exit");
				System.out.println("Enter choice");
				int choice2=scanner.nextInt();
				if(choice2==1) {
					System.out.println("Enter amount");
					double amount=scanner.nextDouble();
					account.withdraw(amount);
				}
				if(choice2==2) {
					System.out.println("Enter amount");
					double amount=scanner.nextDouble();
					account.deposit(amount);
				}
				if(choice2==3) {
					account.getBalance();
				}
				if(choice2==4) {
					break;
				}
			break;
			}
				case 2:{
					System.out.println("1.withdraw\n2.deposit\n3.check balance\n4.Exit");
					System.out.println("Enter choice");
					int choice2=scanner.nextInt();
					if(choice2==1) {
						System.out.println("Enter amount");
						double amount=scanner.nextDouble();
						account1.withdraw(amount);
					}
					if(choice2==2) {
						System.out.println("Enter amount");
						double amount=scanner.nextDouble();
						account1.deposit(amount);
					}
					if(choice2==3) {
						account1.getBalance();
					}
					if(choice2==4) {
						break;
					}
					break;
				}
					case 3:{
						flag=false;
						break;
					}
				
					default:{
						System.out.println("Sorry try again");
					
					}
				}
			}
			
			scanner.close();

		}
}

	


