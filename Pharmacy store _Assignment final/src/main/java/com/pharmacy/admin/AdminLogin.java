package com.pharmacy.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.pharmacy.cart.Admin_place;
import com.pharmacy.cart.Admin_view;
public class AdminLogin {
	private static AdminLogin Login_page = null;
	static String UserId;
	static String Password;
	public void user() {
		String JdbcURL = "jdbc:mysql://localhost:3306/pharmacy_store";
		String Username = "root";
		String password = "admin@123";
		Connection connection = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the UserId :");
		UserId = scanner.next();
		System.out.println("Enter the Password");
		Password = scanner.next();
		PreparedStatement preparestatement = null;
		ResultSet resultset = null;
		String myQuery = "select User_Id,Password from Admin where User_Id=? and Password=?";
		try {
			connection = DriverManager.getConnection(JdbcURL, Username, password);
			preparestatement = connection.prepareStatement(myQuery);
			preparestatement.setString(1, UserId);
			preparestatement.setString(2, Password);
			resultset = preparestatement.executeQuery();
			if (resultset.next()) {
				System.out.println("Login Successful!!!");
				Admin_view adminview = Admin_view.getInstance();
 				 adminview.select(); 
 				Admin_place adminplace = Admin_place.getInstance();
				 adminplace.select();
			} else {
				throw new AdminDAOException("Invalid userid or password");
			}
			resultset.close();
			preparestatement.close();
			connection.close();
		}
		catch(AdminDAOException e)
		{
			System.out.println(e.getMessage());
		}
		catch (SQLException exec) {
			exec.printStackTrace();
		}
		
	}
	public static AdminLogin getInstance() {
		if (Login_page == null) {
			Login_page = new AdminLogin();
		}
		return Login_page;
	}
}