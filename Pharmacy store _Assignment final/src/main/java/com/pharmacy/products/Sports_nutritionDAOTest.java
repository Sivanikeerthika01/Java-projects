package com.pharmacy.products;
import org.junit.Test;
public class Sports_nutritionDAOTest {
	@Test
    public void testSelect() {
    	Sports_nutritionDAO sports =Sports_nutritionDAO.getInstance();
        sports.select();
        
    }

}
