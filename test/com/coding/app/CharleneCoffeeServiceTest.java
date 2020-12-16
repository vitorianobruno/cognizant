package com.coding.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;
import com.coding.app.service.CharleneCoffeeService;
import com.coding.app.service.CharleneCoffeeServiceImp;

class CharleneCoffeeServiceTest {

	@Test
	void testReceipt() {
		
		CharleneCoffeeService order = new CharleneCoffeeServiceImp();;
		
		List<Item> list = new ArrayList<Item>();
		
		list.add(new Item("Coffee small",2.50,"CHF","B"));
		list.add(new Item("Bacon Roll",4.50,"CHF","S"));
		list.add(new Item("Extra Milk",0.30,"CHF","E"));
		
		Ticket receipt = order.receipt(list, 5);

		Double received = receipt.getTotal();
		Double expected = 4.50;
		
		assertEquals(expected,received);
	}

}
