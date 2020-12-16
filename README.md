# Coding Assignment: Charlene's Coffee Corner - Details

Recently, Charlene decided to open her very own little coffee shop on a busy street corner.
Being the careful entrepreneur, she decided to start off with a limited offering, with the option to expand her
choice of products, as business goes.

## Task

simple program whose output is formatted like a receipt you would receive at a supermarket.
The input to the program is a list of products the shopper wants to purchase (large coffee with extra milk, small
coffee with special roast, bacon roll, orange juice)

## Main class structure

```bash
CharleneCoffeeService order = new CharleneCoffeeServiceImp();;
		
		List<Item> list = new ArrayList<Item>();
		
		list.add(new Item("Coffee small",2.50,"CHF","B"));
		list.add(new Item("Bacon Roll",4.50,"CHF","S"));
		list.add(new Item("Extra Milk",0.30,"CHF","E"));
		
		System.out.println("======================");
		System.out.println("Order 1. With 5 stamps \n");
		Ticket receipt1 = order.receipt(list, 5); 
		System.out.println(receipt1.toString());
```

## Expected result

```bash
======================
Order 1. With 5 stamps 

Extra PROMO applyed.
Beverage PROMO applyed.

Id Receipt: 873055a6-9e91-459b-bade-4eed79e30eb7
Date      : Wed Dec 16 18:26:55 CET 2020
Item: Bacon Roll, 4.5, CHF
Total     : 4.50 CHF
```

