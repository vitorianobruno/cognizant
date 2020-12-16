package com.coding.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {
	
	private static final String CTE_CURRENCY = "CHF";
    String id;
    Date date = new Date();
    List<Item> items = new ArrayList<Item>();
    Double total;

    public Ticket() {
		super();
	}
    
    public Ticket(String id, Date date, List<Item> items, Double total) {
		super();
		this.id = id;
		this.date = date;
		this.items = items;
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public static String getCteCurrency() {
		return CTE_CURRENCY;
	}

	public String toString() {
       
		StringBuilder sb = new StringBuilder();
        sb.append("Id Receipt: ").append(id).append("\n");
        sb.append("Date      : ").append(date).append("\n");
        for (Item i : items) {
            sb.append(i.toString());
        }
        sb.append("Total     : ").append(String.format("%.2f", total)).append(" ").append(CTE_CURRENCY).append("\n");
        return sb.toString();
    }

}
