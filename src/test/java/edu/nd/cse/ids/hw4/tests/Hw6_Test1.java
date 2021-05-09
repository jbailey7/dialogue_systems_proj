package edu.nd.cse.ids.hw4.tests; 

import edu.nd.cse.ids.hw4.*; 

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.Arrays; 
import java.util.List; 

public class Hw6_Test1
{
	@Test
	public void testMsg() 	
	{
		RentalHouseNLG rentalNlg = new RentalHouseNLG("data/palmsprings-uniq.csv"); 

		String description = rentalNlg.askQuestion();  

		assertEquals("It has 2 spacious, tiled bathrooms with toiletries provided for the guests.Due to construction, until May 01, 2016 the living space should be shared on weekends.", description); 
	
	}
}
