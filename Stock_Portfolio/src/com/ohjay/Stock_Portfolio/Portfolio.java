package com.ohjay.Stock_Portfolio;

import java.util.ArrayList;

public class Portfolio {
	
	//name of owner
	private String owner;
	
	//totalBalance
	private double totalBalance;
	
	//isRisky
	private boolean isRisky;
	
	//theList
	private ArrayList<Forex> forexList = new ArrayList<Forex>();
	private ArrayList<Stocks> stockList = new ArrayList<Stocks>();
	
	
	
	
	//Constructors ("a method that lets you define how to initialize the class
		public Portfolio() {
			
		}
		
		
		
		//Overloading the constructor(create another constructor  with the same exact name. ) so that it generates a set data.
		public Portfolio(String owner, double totalBalance) {
			this.owner = owner;
			this.totalBalance = totalBalance;
		}
		
	
	
	//Generate getters and Setters after top
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	public boolean isRisky() {
		return isRisky;
	}
	public void setRisky(boolean isRisky) {
		this.isRisky = isRisky;
	}
	public ArrayList<Forex> getForexList() {
		return forexList;
	}
	public void setForexList(ArrayList<Forex> forexList) {
		this.forexList = forexList;
	}
	public ArrayList<Stocks> getStockList() {
		return stockList;
	}
	public void setStockList(ArrayList<Stocks> stockList) {
		this.stockList = stockList;
	}
	
	public void addStock(Stocks stockObj) {
		this.stockList.add(stockObj);
	}
	
	
	
	
	
}
