package com.pharmacy.products;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Skin_careDAO {
	private static Skin_careDAO skincare = null;
	   //public static void main(String[] args) {
		public void select() {
	      String JdbcURL = "jdbc:mysql://localhost:3306/pharmacy_store";
	      String Username = "root";
	      String password = "admin@123";
	      Connection con = null;
	      PreparedStatement pstm = null;
	      ResultSet rst = null;
	      String myQuery = "select Product_id,Product_name,Quantity from skin_care";
	      try {
	         con = DriverManager.getConnection(JdbcURL, Username, password);
	         pstm = con.prepareStatement(myQuery);
	         rst = pstm.executeQuery();
	         System.out.println("Product_id\tProduct_name\t\tQuantity");
	         while(rst.next()) {
	            System.out.print(rst.getInt(1));
	            System.out.print("\t\t"+rst.getString(2));
	            System.out.print("\t\t"+rst.getInt(3));
	            System.out.println();
	         }
	      } catch(Exception exec) {
	         exec.printStackTrace();
	      }
	      try{
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				//serverhost = localhost, port=3306, username=root, password=123
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_store","root","admin@123");

				Statement smt=cn.createStatement();
				//creating object of DataInputStream

				DataInputStream KB=new DataInputStream(System.in);
				//input id
				System.out.print("Enter product id: ");
				String id=KB.readLine();
				//input name
				System.out.print("Enter product name: ");
				String name=KB.readLine();
				

				
				String q="Select * from skin_care where Product_id='"+id+"' and Product_name='"+name+"'";

				// to execute query
				ResultSet rs=smt.executeQuery(q);
				//to print the resultset on console
				if(rs.next())
				{
					do{
						System.out.print("Enter Quantity: ");
						String Quantity=KB.readLine();
						System.out.print("Enter User id: ");
						String User_id=KB.readLine();
						String query = "INSERT INTO my_cart(Product_id, Product_name, Quantity,User_id)" + "VALUES (?, ?, ?,?)";
					//	String query1 = "UPDATE diabetes_management SET Quantity = Quantity - ? WHERE Product_id = ?";
						PreparedStatement pstmt = null;
						pstmt = cn.prepareStatement(query);
				         pstmt.setString(1,id);
				         pstmt.setString(2, name);
				         pstmt.setString(3, Quantity);
				         pstmt.setString(4, User_id);
				         int status = pstmt.executeUpdate();
				         if(status > 0) {
						System.out.println("Successfully added to cart");
						 String Product_id = rs.getString("Product_id");
			    	        String quantity = rs.getString("Quantity");
			    	       int newQuantity = Integer.parseInt(quantity) - Integer.parseInt(Quantity);


			    	        // create a new prepared statement to update the  quantity
			    	        PreparedStatement updateSt = con.prepareStatement("UPDATE skin_care SET Quantity = ? WHERE Product_id= ?");
			    	    
			  
							// set the values for the prepared statement
			    	        updateSt.setInt(1, newQuantity);
			    	        updateSt.setString(2, Product_id);
			    	        
			    	        // execute the query
			    	        updateSt.executeUpdate();
			    	      //  System.out.println("reduced");
				         }
					}while(rs.next());
				
			}
				else
				{
					System.out.println("Record Not Found...");
				}
				cn.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	   } 
		public static Skin_careDAO getInstance() {
			if (skincare == null) {
				skincare = new Skin_careDAO();
			}
			return skincare;
		}
		
	}


