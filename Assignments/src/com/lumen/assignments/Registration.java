package com.lumen.assignments;

import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usernames[]= {"Sivani","Ram","Priya","Hema","Sri"};
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Name");
		String name=scanner.next();
		int flag=0;
		for(String username:usernames) {
			if(username.equals(name)) {
				flag=1;
				break;
				
			}
		}
		if(flag==1) {
			System.out.println("Logged in");
		
		}else {
			System.out.println("Name exist");
			
		}
		
	}
	

}
