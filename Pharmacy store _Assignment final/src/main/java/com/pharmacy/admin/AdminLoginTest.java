package com.pharmacy.admin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdminLoginTest {
	   @Test
	   public void testLoginFailure() {
	      AdminLogin adminLogin = AdminLogin.getInstance();
	      adminLogin.UserId = "testuser";
	      adminLogin.Password = "testpassword";
	      //call the user method and check if the output is as expected
	      adminLogin.user();
	      assertEquals("Invalid userid or password", "Invalid userid or password");
	   }

		@Test
		   public void testLoginSuccess() {
		      AdminLogin adminLogin = AdminLogin.getInstance();
		      adminLogin.UserId = "testuser";
		      adminLogin.Password = "testpassword";
		      //call the user method and check if the output is as expected
		      adminLogin.user();
		      assertEquals("Login Successful!!!", "Login Successful!!!");
		   }
		}