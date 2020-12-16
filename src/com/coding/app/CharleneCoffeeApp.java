package com.coding.app;

import java.util.ArrayList;
import java.util.List;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;
import com.coding.app.service.CharleneCoffeeService;
import com.coding.app.service.CharleneCoffeeServiceImp;

public class CharleneCoffeeApp {
	
	public static void main(String[] args) {
        
		CharleneCoffeeService order = new CharleneCoffeeServiceImp();;
		
		List<Item> list = new ArrayList<Item>();
		
		list.add(new Item("Coffee small",2.50,"CHF","B"));
		list.add(new Item("Bacon Roll",4.50,"CHF","S"));
		list.add(new Item("Extra Milk",0.30,"CHF","E"));
		
		System.out.println("======================");
		System.out.println("Order 1. With 5 stamps \n");
		Ticket receipt1 = order.receipt(list, 5); 
		System.out.println(receipt1.toString());
		

		list.clear();
		list.add(new Item("Freshly squeezed orange juice",3.95,"CHF","B"));
		list.add(new Item("Special roast coffee",0.90,"CHF","E"));
		
		System.out.println("======================");
		System.out.println("Order 2. With 2 stamps \n");
		Ticket receipt2 = order.receipt(list, 2); 
		System.out.println(receipt2.toString());
		
		list.clear();
		list.add(new Item("Coffee large",3.50,"CHF","B"));
		list.add(new Item("Foamed Milk",0.50,"CHF","E"));
		
		System.out.println("======================");
		System.out.println("Order 3. With 10 stamps \n");
		Ticket receipt3 = order.receipt(list, 10); 
		System.out.println(receipt3.toString());
		
    }
	
}
