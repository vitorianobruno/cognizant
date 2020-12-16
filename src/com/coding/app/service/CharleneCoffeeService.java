package com.coding.app.service;

import java.util.List;

import com.coding.app.model.Item;
import com.coding.app.model.Ticket;

public interface CharleneCoffeeService {

	public List<Item> prepare(String order);
	public Ticket execute(List<Item> list, int stamp);
}
