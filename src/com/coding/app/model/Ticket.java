package com.coding.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {
	
	private static final String CTE_CURRENCY = "CHF";
    String id;
    Date date = new Date();
    List<Products> products = new ArrayList<Products>();
    Double total;

    public Ticket() {
		super();
	}
    
    public Ticket(String id, Date date, List<Products> products, Double total) {
		super();
		this.id = id;
		this.date = date;
		this.products = products;
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

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
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
        for (Products p : products) {
            sb.append(p.toString());
        }
        sb.append("Total     : ").append(String.format("%.2f", total)).append(" ").append(CTE_CURRENCY).append("\n");
        return sb.toString();
    }

}
