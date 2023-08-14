package com.pharmacy.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ViewOrder {
	private static ViewOrder vieworder = null;
//	public static void main(String args[]) {
	public void user() {
		String JdbcURL = "jdbc:mysql://localhost:3306/pharmacy_store";
		String Username = "root";
		String password = "admin@123";
		Connection connection = null;
		
		PreparedStatement preparestatement = null;
		
		String myQuery = "INSERT INTO order_details(Customer_name, Email_id , Quantity, Product_name, Requested_date, Address, User_id) SELECT Customer_name, Email_id, Quantity, Product_name, Requested_date, Address, s1.User_id FROM my_cart AS s1 INNER JOIN order_list AS s2 ON s2.User_id = s1.User_id;";

		try {
			connection = DriverManager.getConnection(JdbcURL, Username, password);
			preparestatement = connection.prepareStatement(myQuery);
			preparestatement.executeUpdate();
			preparestatement.close();
			connection.close();
		} catch (Exception exec) {
			exec.printStackTrace();
		}
	}
	public static ViewOrder getInstance() {
		if (vieworder == null) {
			vieworder= new ViewOrder();
		}
		return vieworder;
	}
}