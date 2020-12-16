package com.coding.app;

import java.util.List;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;
import com.coding.app.service.CharleneCoffeeService;
import com.coding.app.service.CharleneCoffeeServiceImp;

public class CharleneCoffeeApp {
	
	public static void main(String[] args) {
        
		CharleneCoffeeService service = new CharleneCoffeeServiceImp();;
		
		String order = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";
			
		List<Item> items = service.prepare(order);
		
		int stamp = (int)(Math.random()*20);
		//System.out.println("STAMPS: " + stamp);
		
		Ticket receipt = service.execute(items, stamp);
		
		System.out.println("  TICKET ## Charlene's Coffee Corner ##");
		System.out.println(receipt.toString());
		
    }
	
}
