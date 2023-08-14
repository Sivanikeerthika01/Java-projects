package com.pharmacy.products;

import org.junit.Test;

public class Skin_CareDAOTest {
	@Test
    public void testSelect() {
    	Skin_careDAO skincare =Skin_careDAO.getInstance();
        skincare.select();
        // add assert statements to verify the output of the select method
    }

}
