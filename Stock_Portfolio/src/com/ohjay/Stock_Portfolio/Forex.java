package com.ohjay.Stock_Portfolio;

public class Forex {
	
	//pairs
	private String pairs;
	
	//price
	private	 double price;
	
	//name
	private String name;
	
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
