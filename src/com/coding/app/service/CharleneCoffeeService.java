package com.coding.app.service;

import java.util.List;

import com.coding.app.model.Products;
import com.coding.app.model.Ticket;

public interface CharleneCoffeeService {

	public List<Products> prepare(String order);
	public Ticket execute(List<Products> items, int stamp);
}
