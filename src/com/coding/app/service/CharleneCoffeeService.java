package com.coding.app.service;

import java.util.List;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;

public interface CharleneCoffeeService {

	    public Ticket receipt(List<Item> list, int stamp);

}
