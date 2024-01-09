package edu.westga.cs6311.homemart.model;

import java.util.ArrayList;

/**
 * The Shopper class will keep track of a collection of InventoryItems objects 
 * in relation to the shopper
 * 
 * @author William Pevytoe
 * 
 * @version 12/1/2023
 */
public class Shopper {
	private String name;
	private double budget;
	private ArrayList<InventoryItem> theCart;
	
	/**
	 * Constructs the Array, checks that name and budget are not null or 0
	 * 
	 * @param theName a String that represents the tool name
	 * @param theBudget double that represents the budget of a customer
	 */
	public Shopper(String theName, double theBudget) {
		this.theCart = new ArrayList<>();
		if (theName == null || theName.isEmpty()) {
			this.name = "";
		} else {
			this.name = theName;
		}
		
		if (theBudget <= 0) {
			this.budget = 0;
		} else {
			this.budget = theBudget;
		}
	}
	
	/**
	 * Get the item name
	 * 
	 * @return with the name of the item
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the shopper budget
	 * 
	 * @return with the budget of the shopper
	 */
	public double getBudget() {
		return this.budget;
	}
	
	/**
	 * Gets the objects in the cart
	 * 
	 * @return theCart of objects
	 */
	public ArrayList<InventoryItem> getTheCart() {
	    return this.theCart;
	}
	
	/**
	 * Checks if the shopper has enough of a budget to purchase an item of a select quantity
	 * 
	 * @param item InventoryItem Object
	 * @param quantity the number of the object to purchase
	 * @return True or False of the shopper has the budget to purchase items
	 */
	public boolean haveEnoughToBuy(InventoryItem item, int quantity) {
		double totalPrice = item.getCost() * quantity;
		return (totalPrice <= this.budget);
	}
	
	/**
	 * Adds the item to the shoppers cart
	 * 
	 * @param item InventoryItem Object
	 * @param quantity the number of the object to purchase
	 */
	public void addItem(InventoryItem item, int quantity) {
		if (!this.haveEnoughToBuy(item, quantity) || (quantity > item.getQuantity())) {
			return;
		}
		double totalPrice = item.getCost() * quantity;
		if (totalPrice <= this.getBudget()) {
			InventoryItem newItem = new InventoryItem(item.getName(), item.getCost(), quantity);
			this.theCart.add(newItem);
			this.budget -= totalPrice;
			item.purchaseItem(quantity);
		}
	}

	/**
	 * Clears the cart (array list of all objects)s
	 */
	public void purchaseCart() {
		this.theCart.clear();
	}
}
