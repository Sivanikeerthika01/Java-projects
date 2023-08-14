package com.pharmacy.products;

import org.junit.Test;

public class Diabetes_managementDAOTest {
	@Test
    public void testSelect() {
    	Diabetes_managementDAO diabetes = Diabetes_managementDAO.getInstance();
        diabetes.select();
        // add assert statements to verify the output of the select method
    }
}

