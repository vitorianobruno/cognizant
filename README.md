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
public class CharleneCoffeeApp {
	
	public static void main(String[] args) {
        
		CharleneCoffeeService service = new CharleneCoffeeServiceImp();;
		
		String order = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";
		
		List<Products> products = service.prepare(order);
		
```

## Expected result

```bash
   TICKET ## Charlene's Coffee Corner ##
Id Receipt: f3bd358d-93f9-443f-9c3a-472931fdf17d
Date      : Thu Dec 17 19:11:41 CET 2020
Item      : Small Coffee, 0.0, CHF * PROMO *
Item      : Large Coffee, 3.5, CHF 
Item      : Bacon Roll, 4.5, CHF 
Item      : Orange Juice, 3.95, CHF 
Item      : Extra milk, 0.0, CHF * PROMO *
Item      : Special roast, 0.9, CHF 
Total     : 12.85 CHF
```

