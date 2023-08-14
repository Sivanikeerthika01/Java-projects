package com.pharmacy.products;

import org.junit.Test;

public class Special_nutritionDAOTest {
	@Test
    public void testSelect() {
    	Special_nutritionDAO special =Special_nutritionDAO.getInstance();
        special.select();
        // add assert statements to verify the output of the select method
    }
}


