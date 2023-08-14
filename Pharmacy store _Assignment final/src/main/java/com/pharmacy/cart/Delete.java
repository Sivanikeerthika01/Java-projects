package com.pharmacy.cart;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	private static Delete delete = null;
  
	public void user() {
      try {	
      //Getting the connection
      String Url = "jdbc:mysql://localhost:3306/pharmacy_store";
      Connection connection = DriverManager.getConnection(Url, "root", "admin@123");
      System.out.println("Connection established......");
      //Creating the Statement
      Statement statement = connection.createStatement();
      //Query to delete all records in a table
      String query = "Truncate table my_cart";
      //Executing the query
      statement.execute(query);
   }
      catch (SQLException e) {

  		e.printStackTrace();
  	}
	}
	public static Delete getInstance() {
		if (delete == null) {
			delete = new Delete();
		}
		return delete;
	}
}