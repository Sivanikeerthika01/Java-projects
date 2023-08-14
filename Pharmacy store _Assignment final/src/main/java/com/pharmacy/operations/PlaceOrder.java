package com.pharmacy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.pharmacy.cart.Delete;
import com.pharmacy.cart.ViewOrder;

public class PlaceOrder {
	static String Customer_name;
	   static String Address;
	  static String Requested_date;
	  static String User_id;
	  static String Email_id;
	private static PlaceOrder placeorder = null;
	public void user()
	{	
		String JdbcURL =  "jdbc:mysql://localhost:3306/pharmacy_store";
	      String Username = "root";
	      String password = "admin@123";
	      Connection connection = null;
	      Scanner scanner=new Scanner(System.in);
	      PreparedStatement preparestatement = null;	      
	      String query = "INSERT INTO order_list(Customer_name, Email_id, Requested_date,Address,User_id)" + "VALUES (?,?,?,?,?)";
	      try {
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         input(scanner);
	         preparestatement = connection.prepareStatement(query);
	         preparestatement.setString(1,Customer_name);
	         preparestatement.setString(2, Email_id);
	         preparestatement.setString(3,Requested_date);
	         preparestatement.setString(4,Address);
	         preparestatement.setString(5, User_id);
	         int status = preparestatement.executeUpdate();	         
	         if(status > 0) {
	        	 System.out.println("Your order is placed successfully!!!");
	        	    ViewOrder vieworder = ViewOrder.getInstance();
					vieworder.user();
	        	    Delete delete = Delete.getInstance();
				    delete.user();				
	         }
	      } catch(Exception e){
	    	  System.out.println("Failed to place your order");
	      }
	   }
	public static void input(Scanner scanner) {
		System.out.println("Confirm your details");
		System.out.println("Enter the User_id");
	      User_id = scanner.next();
		   System.out.println("Enter the Customer name:");
		      Customer_name = scanner.next();
		      System.out.println("Enter the Email id");
		      Email_id = scanner.next();
		      System.out.println("Enter the Address");
		      Address = scanner.next();
		      System.out.println("Enter the Requested date");
		      Requested_date = scanner.next();
	}
	public static PlaceOrder getInstance() {
		if (placeorder == null) {
			placeorder = new PlaceOrder();
		}
		return placeorder;
}
}


