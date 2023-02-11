package com.ohjay.Stock_Portfolio;

public class Forex {
	
	//pairs
	private String pairs;
	
	//price
	private	 double price;
	
	//name
	private String name;
	
	
	//Constructors ("a method that lets you define how to initialize the class
	public Forex() {
		
		
	}
	
	
	//Overloading the constructor(create another constructor  with the same exact name. ) so that it generates a set data.
	public Forex(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	
	// once turned private must use getters and setters to change variable(pairs,price,name)
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPairs() {
		return pairs;
	}

	public void setPairs(String pairs) {
		this.pairs = pairs;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
