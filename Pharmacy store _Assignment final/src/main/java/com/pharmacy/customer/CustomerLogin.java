package com.pharmacy.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.pharmacy.cart.Actions;
import com.pharmacy.products.Diabetes_managementDAO;
import com.pharmacy.products.Foot_careDAO;
import com.pharmacy.products.Home_testingDAO;
import com.pharmacy.products.Skin_careDAO;
import com.pharmacy.products.Special_nutritionDAO;
import com.pharmacy.products.Sports_nutritionDAO;

public class CustomerLogin{
	  private static CustomerLogin Login_page = null;
	static String User_id;
    static String Password;
    public void user() {

    String JdbcURL = "jdbc:mysql://localhost:3306/pharmacy_store";
    String Username = "root";
    String password = "admin@123";
    Connection connection = null;
    Scanner scanner=new Scanner(System.in);
    System.out.println("Enter the user id:");
    User_id = scanner.next();
    System.out.println("Enter the Password");
    Password = scanner.next();
    PreparedStatement preparestatement = null;
    ResultSet resultset = null;
    String myQuery = "select User_Id,Password from customer where User_Id=? and Password=?";
    try {
       connection = DriverManager.getConnection(JdbcURL, Username, password);
       preparestatement = connection.prepareStatement(myQuery);
       preparestatement.setString(1,User_id);
       preparestatement.setString(2,Password);		 
       resultset = preparestatement.executeQuery();
      if(resultset.next())
      {
      	System.out.println("Login Successful!!!");
      	int status=0;
      	Scanner scan=new Scanner(System.in);
	        Scanner scanner1 = new Scanner(System.in);
	        Scanner scanner2 = new Scanner(System.in);
      	do
      	{
      		System.out.println("\nSelect an option:");
    	    System.out.println("1) Personal Care");
   	        System.out.println("2) Nutrition");
   	        System.out.println("3) Health Care");
   	       int option = scanner1.nextInt();
   			if (option == 1) {
   				do
   				{
   					 System.out.println("\nSelect an option:");   		      	       
   	     	        System.out.println("1) Skin Care");
   	     	        System.out.println("2) Foot Care");
   	     	       int choice = scanner2.nextInt();   	     	       
   	     	       if(choice==1)
   	     	       {
   	     	    	 Skin_careDAO skincare = Skin_careDAO.getInstance();
        				 skincare.select();  
   	     	       }   	     	       
   	     	       else if(choice==2)
   	     	       {
   	     	    	 Foot_careDAO footcare = Foot_careDAO.getInstance();
        				 footcare.select();
   	     	       }       	     	         	     	       
   	     	     System.out.println("Do you wish to continue(press any number not zero)");   	     	    
  				 Actions actions = Actions.getInstance();
  				 actions.user();
   	    		status = scan.nextInt();   	    		
   				}
   				while(!(status == 0));  		        
   				System.out.println("Thank you for choosing us!");
      	}
   			else if(option==2)
   			{
   				do
   				{
   					 System.out.println("\nSelect an option:");   		      	       
   	     	        System.out.println("1) Special nutrition");
   	     	        System.out.println("2) Sports nutrition");   	     	       
   	     	       int choice = scanner2.nextInt();   	     	       
   	     	       if(choice==1)
   	     	       {
   	     	    	 Special_nutritionDAO specialnutrition = Special_nutritionDAO .getInstance();
   	     	    	specialnutrition.select();  
   	     	       }
   	     	       else if(choice==2)
   	     	       {
   	     	    	 Sports_nutritionDAO sportsnutrition = Sports_nutritionDAO .getInstance();
   	     	    	sportsnutrition.select(); 
   	     	       }   	     	       
   	     	     System.out.println("Do you wish to continue(press any number not zero)");   	     	   
				 Actions actions = Actions.getInstance();
				 actions.user();
   	    		status = scan.nextInt();
   				}
   				while(!(status == 0));  		        
   				System.out.println("Thank you for choosing us!");
      	}
   			else if(option==3)
   			{
   				do
   				{
   					 System.out.println("\nSelect an option:");   		      	       
   	     	        System.out.println("1) Diabetes management");
   	     	        System.out.println("2) Home testing kit");   	     	     
   	     	       int choice = scanner2.nextInt();   	     	       
   	     	       if(choice==1)
   	     	       {
   	     	    	 Diabetes_managementDAO diabetes_management = Diabetes_managementDAO.getInstance();
   	     	    	diabetes_management.select();  
   	     	       }   	     	       
   	     	       else if(choice==2)
   	     	       {
   	     	    	 Home_testingDAO home_testing = Home_testingDAO.getInstance();
   	     	    	home_testing.select();  
   	     	       }
   	     	     System.out.println("Do you wish to continue(press any number not zero)");   	     	     
				   Actions actions = Actions.getInstance();
				 actions.user();
   	    		status = scan.nextInt();
   				}
   				while(!(status == 0));  		        
   				System.out.println("Thank you for choosing us!");
      	}
   			
      }
      	while(!(status == 0));
      	System.out.println("Thank you for choosing us!");
      }
      else
      {
      	throw new CustomerDAOException("Invalid userid,password");
      }      
      resultset.close();
      preparestatement.close();
      connection.close();
    } 
    catch(CustomerDAOException e)
		{
			System.out.println(e.getMessage());
		}
    catch(Exception exec) {
       exec.printStackTrace();
    }
    
 }    
public static CustomerLogin getInstance() {
	
	if(Login_page == null) {
		Login_page  = new CustomerLogin ();
	}
	return Login_page;
}
}