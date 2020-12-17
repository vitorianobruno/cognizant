package com.coding.app.model;

public enum Products {
	SMALLCOFFEE("Small Coffee", 2.50, "CHF", "B", ""), MEDIUMCOFFEE("Medium Coffee", 3.00, "CHF", "B", ""),
	LARGECOFFEE("Large Coffee", 3.50, "CHF", "B", ""), BACONROLL("Bacon Roll", 4.50, "CHF", "S", ""),
	ORANGEJUICE("Orange Juice", 3.95, "CHF", "B", ""), EXTRAMILK("Extra milk", 0.30, "CHF", "E", ""),
	FOAMEDMILK("Foamed milk", 0.50, "CHF", "E", ""), SPECIALROAST("Special roast", 0.90, "CHF", "E", "");

	private final String description;
	private Double price;
	private final String currency;
	private final String type;
	private String promo;

	Products(String description, Double price, String currency, String type, String promo) {
		this.description = description;
		this.price = price;
		this.currency = currency;
		this.type = type;
		this.promo = promo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getDescription() {
		return description;
	}

	public String getCurrency() {
		return currency;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Item      : " + description + ", " + price + ", " + currency + " " + promo + "\n";
	}
}
