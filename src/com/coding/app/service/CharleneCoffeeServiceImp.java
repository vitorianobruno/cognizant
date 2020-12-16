package com.coding.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;

public class CharleneCoffeeServiceImp implements CharleneCoffeeService{
	
	public Ticket receipt(List<Item> list, int stamp) {
		
		//Order list by price
		Collections.sort(list); 
		
		//Check Beverage-Snack for FREE extra
		boolean extraFree = isBeverageSnackOn(list);

		//Check STAMP discount for FREE Beverage
		boolean beverageFree = isStampCardOn(stamp);
		
		// Check tp apply PROMO		
		if(extraFree) {
			
			Predicate<Item> condition = item -> item.getItemType().equals("E");			
			list.removeIf(condition);        
			System.out.println("Extra PROMO applyed.");   
		}
		
		if(beverageFree) {
			
			Predicate<Item> condition = item -> item.getItemType().equals("B");			
			list.removeIf(condition);	        
			System.out.println("Beverage PROMO applyed.");  
		}
			
        Ticket ticket = new Ticket(list,stamp);
        ticket.setDate(new Date());

        //set Items
        ticket.setItems(list);

        //Generate ID
        UUID uuid = UUID.randomUUID();
        ticket.setId(uuid.toString());

        //calculate TOTAL
        Double total = 0.00;
        for(Item i : ticket.getItems()){
            total = total + i.getPrice();
        }
        ticket.setTotal(total);
        return ticket;
    }

    //Check Beverage - Snack to apply extra FREE
    private boolean isBeverageSnackOn(List<Item> list) {
		 boolean beverage = false;
		 boolean snack = false;
		 boolean isOn = false;
		 
    	 for (Item i : list){
    		 if(i.getItemType().equals("B")) {
    			 beverage = true;
    		 }
    		 if(i.getItemType().equals("S")) {
    			 snack = true;
    		 }
    	 }
    	
    	if(beverage && snack) {
    		isOn = true;
    	}
    	return isOn;
    }

    //Check stamp card number
    private boolean isStampCardOn(int stamp) {
    	boolean isOn = false;
    	
   		 if(stamp%5 == 0) {
   			 isOn = true;
   		 }
   		 
   		 return isOn;
   	 }
    
}
