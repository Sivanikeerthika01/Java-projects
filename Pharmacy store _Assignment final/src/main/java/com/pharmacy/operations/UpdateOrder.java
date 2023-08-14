package com.pharmacy.operations;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateOrder {
	private static UpdateOrder updateorder = null;
	public void user(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//serverhost = localhost, port=3306, username=root, password=123
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_store","root","admin@123");
			Statement statement=connection.createStatement();
			DataInputStream inputstream=new DataInputStream(System.in);			
			System.out.print("Enter user ID:");
			String eid=inputstream.readLine();			
			String q="Select * from my_cart where User_id='"+eid+"'";
			//to execute query
			ResultSet resultset=statement.executeQuery(q);
			if(resultset.next())
			{
				//to show the data
				System.out.println("User id:"+resultset.getString(4));
				System.out.println("1.Product id:"+resultset.getString(1));
				System.out.println("2.Product name:"+resultset.getString(2));
				System.out.println("3.Quantity:"+resultset.getString(3));
				String ch=inputstream.readLine();
				String pat="";
				String pat1="";
				String pat2="";
				//cases to choose field you want to edit		
						System.out.print("Enter New Product id:");
						String nn=inputstream.readLine();
						pat="Product_id='"+nn+"'";	
						System.out.print("Enter New Product name:");
						String nd=inputstream.readLine();
						pat1="Product_name='"+nd+"'";
						System.out.print("Enter New Quantity:");
						String nc=inputstream.readLine();
						pat2="Quantity='"+nc+"'";					
				if(!pat.equals(""))
				{
					//query to edit data of a particular record from table employee
					q="update my_cart set "+pat+","+pat1+","+pat2+" where User_id='"+eid+"'";
					//to execute update
					statement.executeUpdate(q);
					System.out.println("Record Updated....");
				}
			}
			else
			{
				System.out.println("Record Not Found...");
			}
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static UpdateOrder getInstance() {
		if (updateorder == null) {
			updateorder = new UpdateOrder();
		}
		return updateorder;
	}
}


