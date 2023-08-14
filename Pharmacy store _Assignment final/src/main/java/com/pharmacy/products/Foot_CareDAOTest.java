package com.pharmacy.products;

import org.junit.Test;

public class Foot_CareDAOTest {
	@Test
    public void testSelect() {
    	Foot_careDAO footcare = Foot_careDAO.getInstance();
        footcare.select();
        // add assert statements to verify the output of the select method
    }
}

