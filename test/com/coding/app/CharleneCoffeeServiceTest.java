package com.coding.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;
import com.coding.app.service.CharleneCoffeeService;
import com.coding.app.service.CharleneCoffeeServiceImp;

class CharleneCoffeeServiceTest {

	@Test
	void testReceipt() {
		
		CharleneCoffeeService service = new CharleneCoffeeServiceImp();;
		
		String order = "large coffee with extra milk";
			
		List<Item> items = service.prepare(order);
		
		Ticket receipt = service.execute(items, 5);

		Double received = receipt.getTotal();
		Double expected = 0.30;
		
		assertEquals(expected,received);
	}

}
