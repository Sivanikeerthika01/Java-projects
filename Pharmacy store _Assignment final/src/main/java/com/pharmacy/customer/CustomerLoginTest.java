package com.pharmacy.customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerLoginTest {
	   @Test
	   public void testLoginFailure() {
		   CustomerLogin customerlogin = CustomerLogin.getInstance();			
		   customerlogin.User_id = "testuser";
		   customerlogin.Password = "testpassword";
	      //call the user method and check if the output is as expected
		   customerlogin.user();
	      assertEquals("Invalid userid or password", "Invalid userid or password");
	   }
		   @Test
		   public void testLoginSuccess() {
			   CustomerLogin customerlogin = CustomerLogin.getInstance();
			   customerlogin.User_id = "testuser";
			   customerlogin.Password = "testpassword";
		      //call the user method and check if the output is as expected
			   customerlogin.user();
		      assertEquals("Login Successful!!!", "Login Successful!!!");
		   }
		}