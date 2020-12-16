package com.coding.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;

public class CharleneCoffeeServiceImp implements CharleneCoffeeService{
	
	public List<Item> prepare(String order) {
		
		List<Item> list = new ArrayList<Item>();

		ArrayList<String> products = new ArrayList<String>();
		products.add("small coffee");
		products.add("medium coffee");
		products.add("large coffee");
		products.add("bacon roll");
		products.add("orange juice");
		products.add("extra milk");
		products.add("foamed milk");
		products.add("special roast");
		
		order = order.toLowerCase();
		String[] subOrders = order.split(",");
		
		

		try {

			for(int i=0; i<subOrders.length; i++) {
			
			for (String p : products) {

				if (subOrders[i].contains(p)) {

					switch (p) {
					case "small coffee":
						list.add(new Item("Coffee small", 2.50, "CHF", "B",""));
						break;
					case "medium coffee":
						list.add(new Item("Coffee medium", 3.00, "CHF", "B",""));
						break;
					case "large coffee":
						list.add(new Item("Coffee large", 3.50, "CHF", "B",""));
						break;
					case "bacon roll":
						list.add(new Item("Bacon Roll", 4.50, "CHF", "S",""));
						break;
					case "orange juice":
						list.add(new Item("Orange Juice", 3.95, "CHF", "B",""));
						break;
					case "extra milk":
						list.add(new Item("Extra milk", 0.30, "CHF", "E",""));
						break;
					case "foamed milk":
						list.add(new Item("Foamed milk", 0.50, "CHF", "E",""));
						break;
					case "special roast":
						list.add(new Item("Special roast", 0.90, "CHF", "E",""));
						break;
					}
					;

				}
				
			}
		}
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}
		 	
	public Ticket execute(List<Item> list, int stamp) {
		
		//Order ascending list by price to apply PROMO in lower prices
		Collections.sort(list); 
		
		//Check Beverage-Snack for FREE extra
		int extraFree = extraFree(list);
		//System.out.println("EXTRA: "+extraFree);
		
		//Check STAMP discount for FREE Beverage
		int beverageFree = beverageFree(stamp);
		//System.out.println("BEVERAGE: "+beverageFree);
		
		//---------------------------------------
		List<Item> toCalculate = new ArrayList<Item>();
		toCalculate.addAll(list);
		
		//----------------------------Extra Promo process		
		int eCount = 0;
		int c = 0;
		while(extraFree > eCount) {
			
			for(Item i: toCalculate) {
				
				if(c<extraFree && i.getItemType().equals("E")) {
					i.setPrice(0.0);
					i.setHasPromo("* PROMO *");
					c++;
				}	
			}					
			//System.out.println("Extra PROMO applied.");
			eCount++;
		}
		
		//----------------------------Beverage Promo process
		int bCount = 0;
		c = 0;
		while(beverageFree > bCount) {
			
			for(Item i: toCalculate) {
				
				if(c<beverageFree && i.getItemType().equals("B")) {
					i.setPrice(0.0);
					i.setHasPromo("* PROMO *");
					c++;
				}	
			}
			//System.out.println("Beverage PROMO applied.");
			bCount++;
		}
		
		//calculate TOTAL
        Double total = 0.00;
        for(Item i : toCalculate){
            total = total + i.getPrice();
        }
	
		
		Ticket ticket = new Ticket();
		
        ticket.setTotal(total);
        ticket.setDate(new Date());
        ticket.setItems(list);

        //Generate ID
        UUID uuid = UUID.randomUUID();
        ticket.setId(uuid.toString());

        return ticket;
    }

    //------------------------Check Beverage - Snack to apply promotion FREE EXTRA
    private int extraFree(List<Item> list) {
		int countB = 0; 
    	int countS = 0;
    	int extrafree = 0;
    	
    	 for (Item i : list){
    		 if(i.getItemType().equals("B")) {
    			 countB++;
    		 }
    		 if(i.getItemType().equals("S")) {
    			 countS++;
    		 }
    	 }
    	 
    	extrafree = (countB<countS) ? countB : countS; 
    	return extrafree;
    }

    //------------------------Check stamp card to apply promotion FREE BEVERAGE
    private int beverageFree(float stamp) {
    	int beveragefree = 0;
    	
    	beveragefree = (int) (stamp/5);
    	
   		 return beveragefree;
   	 }
    
}
