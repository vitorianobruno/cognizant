# Coding Assignment: Charlene's Coffee Corner - Details

Recently, Charlene decided to open her very own little coffee shop on a busy street corner.
Being the careful entrepreneur, she decided to start off with a limited offering, with the option to expand her
choice of products, as business goes.

## Task

A simple program whose output is formatted like a receipt you would receive at a supermarket.
The input to the program is a list of products the shopper wants to purchase (large coffee with extra milk, small
coffee with special roast, bacon roll, orange juice)

## Main class structure

```bash
CharleneCoffeeService service = new CharleneCoffeeServiceImp();;
		
		String order = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";
			
		List<Item> items = service.prepare(order);
		
		int stamp = (int)(Math.random()*20);
		//System.out.println("STAMPS: " + stamp);
		
		Ticket receipt = service.execute(items, stamp);
		
		System.out.println("  TICKET ## Charlene's Coffee Corner ##");
		System.out.println(receipt.toString());
```

## Expected result

```bash
  TICKET ## Charlene's Coffee Corner ##
Id Receipt: 20ee28a5-ba44-4d59-89eb-c77e51e9e9bd
Date      : Thu Dec 17 00:52:43 CET 2020
Item      : Extra milk, 0.0, CHF * PROMO *
Item      : Special roast, 0.9, CHF 
Item      : Coffee small, 0.0, CHF * PROMO *
Item      : Coffee large, 3.5, CHF 
Item      : Orange Juice, 3.95, CHF 
Item      : Bacon Roll, 4.5, CHF 
Total     : 12.85 CHF
```

