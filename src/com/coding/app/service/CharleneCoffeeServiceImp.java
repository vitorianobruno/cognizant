package com.coding.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.coding.app.model.Products;
import com.coding.app.model.Ticket;

public class CharleneCoffeeServiceImp implements CharleneCoffeeService{
	
	public List<Products> prepare(String order) {
		
		Products[] products = Products.values();
		List<Products> purchase = new ArrayList<Products>();
		order = order.toLowerCase();
						
		try {
				
			for(int i=0; i<products.length; i++) {				
				if (order.contains(products[i].getDescription().toLowerCase())) {
					purchase.add(Products.valueOf(products[i].name()));
				}	
			}		
			
		} catch (Exception e) {
			e.getMessage();
		}
		return purchase;
	}
		 	
	public Ticket execute(List<Products> listP, int stamp) {
		
		//Order ascending list by price to apply PROMO in lower prices
		Collections.sort(listP); 
		
		//Check Beverage-Snack for FREE extra
		int extraFree = extraFree(listP);
		
		//Check STAMP discount for FREE Beverage
		int beverageFree = beverageFree(stamp);

		
		//----------------------------BEGIN
		List<Products> toCalculate = new ArrayList<Products>();
		toCalculate.addAll(listP);
		
		//----------------------------Extra Promo process		
		int eCount = 0;
		int c = 0;
		while(extraFree > eCount) {
			
			for(Products i: toCalculate) {
				
				if(c<extraFree && i.getType().equals("E")) {
					i.setPrice(0.0);
					i.setPromo("* PROMO *");
					c++;
				}	
			}					
			eCount++;
		}
		
		//----------------------------Beverage Promo process
		int bCount = 0;
		c = 0;
		while(beverageFree > bCount) {
			
			for(Products i: toCalculate) {
				
				if(c<beverageFree && i.getType().equals("B")) {
					i.setPrice(0.0);
					i.setPromo("* PROMO *");
					c++;
				}	
			}
			bCount++;
		}
		
		//calculate TOTAL
        Double total = 0.00;
        for(Products i : toCalculate){
            total = total + i.getPrice();
        }
      	//----------------------------END
		
		Ticket ticket = new Ticket();
		
        ticket.setTotal(total);
        ticket.setDate(new Date());
        ticket.setProducts(listP);

        //Generate ID
        UUID uuid = UUID.randomUUID();
        ticket.setId(uuid.toString());

        return ticket;
    }

    //------------------------Check Beverage - Snack to apply promotion FREE EXTRA
    private int extraFree(List<Products> list) {
		int countB = 0; 
    	int countS = 0;
    	int extrafree = 0;
    	
    	 for (Products i : list){
    		 if(i.getType().equals("B")) {
    			 countB++;
    		 }
    		 if(i.getType().equals("S")) {
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
