package com.coding.app.model;

public class Item implements Comparable<Item> {
	
	String description;
    Double price;
    String currency;
    String itemType;
	
	public Item(String description, Double price, String currency, String itemType) {
		super();
		this.description = description;
		this.price = price;
		this.currency = currency;
		this.itemType = itemType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Override
	public int compareTo(Item item) {
		return this.price.compareTo(item.price);
	}

	@Override
	public String toString() {
		return "Item: " + description + ", " + price + ", " + currency + "\n";
	}
      
}
