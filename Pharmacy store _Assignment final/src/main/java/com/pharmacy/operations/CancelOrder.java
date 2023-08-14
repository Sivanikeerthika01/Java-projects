package com.pharmacy.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CancelOrder {
	private static CancelOrder cancelorder = null;
    private static final String SQL_DELETE = "DELETE FROM my_cart WHERE User_id=?";
    	public void user(){
    	 Scanner scanner = new Scanner(System.in);
	    	System.out.println("Enter userid: ");
	    	String User_id = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/pharmacy_store", "root", "admin@123");
             PreparedStatement preparestatement = connection.prepareStatement(SQL_DELETE)) {
        	 // set the values for the prepared statement
            preparestatement.setString(1, User_id);
            // execute the query
            int rowsDeleted = preparestatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Order cancelled successfully");
            } else {
                System.out.println("No request found to cancel");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    	public static CancelOrder getInstance() {
    		if (cancelorder == null) {
    			cancelorder = new CancelOrder();
    		}
    		return cancelorder;
    	}
    	}


