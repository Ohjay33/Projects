package com.ohjay.Stock_Portfolio;

public class Stocks {
	
	//name
	private String name;
	
	//price
	private double price;
	
	//color
	private String color;
	
	
	
	//Constructors ("a method that lets you define how to initialize the class
	public Stocks() {
		
	}
	
	//Overloading the constructor(create another constructor  with the same exact name. ) so that it generates a set data.
	public Stocks(String name, double price) {
		this.name = name;
		this.price = price;
		
	}
	
	
	
	//Generate getters and Setters after top

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

}
