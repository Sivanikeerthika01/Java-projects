package com.pharmacy.cart;

import java.util.Scanner;

import com.pharmacy.operations.CancelOrder;
import com.pharmacy.operations.PlaceOrder;
import com.pharmacy.operations.UpdateOrder;

public class Actions {
	private static Actions actions = null;
	public void user() {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Welcome to our pharmacy store");
	       int status=0;
	        Scanner scanner1 = new Scanner(System.in);
	       do {
	        System.out.println("\nSelect an option:");
	       
	        System.out.println("1) Place order");
	        System.out.println("2) Update order");
	        System.out.println("3) Cancel order");
	 
	        int option = scanner1.nextInt();

		if (option == 1) {
			PlaceOrder placeorder = PlaceOrder.getInstance();
			placeorder.user();

		} 
		else if(option == 2) {
			UpdateOrder updateorder = UpdateOrder.getInstance();
			updateorder.user();
		}
		else if(option==3) 
		{
			CancelOrder cancelorder = CancelOrder.getInstance();
			cancelorder.user();
		}
		System.out.println("Do you wish to continue(press any number not zero)");
		status = scanner.nextInt();
		
	} while (!(status == 0));
		        
	System.out.println("Thank you for choosing us!");
	        
	}
	public static Actions getInstance() {
		if (actions == null) {
			actions= new Actions();
		}
		return actions;
}
}