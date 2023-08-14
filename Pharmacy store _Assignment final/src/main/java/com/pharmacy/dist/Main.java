package com.pharmacy.dist;

import java.util.Scanner;

import com.pharmacy.admin.AdminLogin;
import com.pharmacy.admin.AdminRegistration;
import com.pharmacy.customer.CustomerLogin;
import com.pharmacy.customer.CustomerRegistration;
public class Main {
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		System.out.println("****Welcome to our pharmacy store****");
	       int status=0;
	        Scanner scanner1 = new Scanner(System.in);
	       do {
	        System.out.println("\nSelect an option:");
	       
	        System.out.println("1) Admin Login");
	        System.out.println("2) Admin Registration");
	        System.out.println("3) Customer Login");
	        System.out.println("4) Customer Registration");
	        int option = scanner1.nextInt();
		if (option == 1) {
			AdminLogin adminlogin = AdminLogin.getInstance();
			adminlogin.user();

		} 
		else if(option == 2) {
			AdminRegistration adminregister = AdminRegistration.getInstance();
			adminregister.register();		
		}
		else if(option==3) 
		{
			CustomerLogin customerlogin = CustomerLogin.getInstance();
			customerlogin.user();			 
		}
		else if(option==4) 
		{
			CustomerRegistration register = CustomerRegistration.getInstance();
			register.register();
		}
		System.out.println("Do you wish to continue(press any number not zero)");		
		status = scanner.nextInt();		
	} while (!(status == 0));		        
	System.out.println("Thank you for choosing us!");	        
	}	
}
