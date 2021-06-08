package com.capgemini.hotelbilling.bean;


public class FoodItems {

	private int itemCode;
	private String foodName;
	private double price;

	public FoodItems(int itemCode, String foodName, double price) {
		super();
		this.itemCode = itemCode;
		this.foodName = foodName;
		this.price = price;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FoodItems() {
	}
}

