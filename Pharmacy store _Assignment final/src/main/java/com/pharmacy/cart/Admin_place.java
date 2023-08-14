package com.pharmacy.cart;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin_place {
	private static Admin_place adminplace = null;
	public void select() {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;

    try {
      // Establish a connection to the database
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_store", "root", "admin@123");
      
      // Execute a SELECT query to get the data from the source table
      statement = connection.createStatement();
      Scanner scanner=new Scanner(System.in);
		//input id
		System.out.print("Enter request id to be placed: ");
		String id=scanner.nextLine();
		String query="Select * from order_details where Request_id='"+id+"'";
   //   rs = stmt.executeQuery("SELECT * FROM order_details");
		resultset=statement.executeQuery(query);
		//to print the resultset on console
		if(resultset.next())
		{
			do
			{
      // Loop through the result set and insert each row into the target table
				 resultset = statement.executeQuery("SELECT * FROM order_details where Request_id='"+id+"'");
	 
      if (resultset.next()){
        String sql = "INSERT INTO confirmed_order (Request_id,Customer_name,Email_id,Quantity,Product_name,Requested_date,Address,User_id) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, resultset.getString("Request_id"));
        preparedStmt.setString(2, resultset.getString("Customer_name"));
        preparedStmt.setString(3, resultset.getString("Email_id"));
        preparedStmt.setString(4, resultset.getString("Quantity"));
        preparedStmt.setString(5, resultset.getString("Product_name"));
        preparedStmt.setString(6, resultset.getString("Requested_date"));
        preparedStmt.setString(7, resultset.getString("Address"));
        preparedStmt.setString(8, resultset.getString("User_id"));
        preparedStmt.execute();
      
        try {
            // create a connection to the database
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_store", "root", "admin@123");

            // create a new prepared statement to delete the request from the database
            PreparedStatement statement1 = connection1.prepareStatement("DELETE FROM order_details WHERE Request_id = ? ");

            // set the values for the prepared statement
            statement1.setString(1, id);
            

            // execute the query
            int rowsDeleted = statement1.executeUpdate();

            if (rowsDeleted > 0) {
            	  System.out.println("Order is placed Successfully");
            } else {
                System.out.println("Failed to place order");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      }
		}
			while(resultset.next());	
    } else
    {
    	System.out.println("Failed to place order");
    }
    }
		catch (SQLException e) {
      System.out.println(e);
    } finally {
      // Close the connection and release the resources
      if (resultset != null) {
        try {
        	resultset.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
      }
      if (statement != null) {
        try {
			statement.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
      }
      if (connection != null) {
        try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
      } 
    }
    }
	public static Admin_place getInstance() {
		if (adminplace == null) {
			adminplace= new Admin_place();
		}
		return adminplace;
	}
}