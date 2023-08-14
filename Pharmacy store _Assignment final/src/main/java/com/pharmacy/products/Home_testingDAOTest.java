package com.pharmacy.products;

import org.junit.Test;

public class Home_testingDAOTest {
	 @Test
	    public void testSelect() {
	    	Home_testingDAO hometesting =Home_testingDAO.getInstance();
	        hometesting.select();
	        // add assert statements to verify the output of the select method
	    }
	}


