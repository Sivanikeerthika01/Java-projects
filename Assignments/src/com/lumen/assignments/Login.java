package com.lumen.assignments;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usernames[]= {"Sivani","Ram","Priya","Hema","Sri"};
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Name");
		String name=scanner.next();
		int count=0;
		for(String username:usernames) {
			if(username.equals(name)) {
				count=1;
			}
			if(count==1) {
				System.out.println("Logged in");
				break;
				}
			else {
				System.out.println("Invalid");
				break;
			}
			
		}
		scanner.close();

	}

}
