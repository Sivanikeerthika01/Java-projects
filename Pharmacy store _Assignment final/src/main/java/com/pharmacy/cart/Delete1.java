package com.pharmacy.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete1 {
	private static Delete1 delete1 = null;
	public void user() {
      try {
      //Getting the connection
      String url = "jdbc:mysql://localhost:3306/pharmacy_store";
      Connection connection = DriverManager.getConnection(url, "root", "admin@123");
      
      //Creating the Statement
      Statement statement = connection.createStatement();
      //Query to delete all records in a table
      String query = "Truncate table order_list";
      //Executing the query
      statement.execute(query);
   }
      catch (SQLException e) {
  		
  		e.printStackTrace();
  	}
	}
	public static Delete1 getInstance() {
		if (delete1 == null) {
			delete1 = new Delete1();
		}
		return delete1;
	}
}