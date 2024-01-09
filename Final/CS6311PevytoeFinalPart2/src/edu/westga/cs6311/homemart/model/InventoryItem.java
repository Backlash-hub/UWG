
package edu.westga.cs6311.homemart.model;

/**
 * 
 * Manages information (name, cost, and quantity) about a InventoryItem
 * 
 * @author William Pevytoe
 * 
 * @version 11/30/23
 * 
 */
public class InventoryItem {
	private String name;
	private double cost;
	private int quantity;
	
	/**
	 * Constructs the Inventory Object
	 * 
	 * @param name a String that represents the tool name
	 * @param cost a double that represents the tool value
	 * @param quantity an double that represents the amount in the inventory 
	 */
	public InventoryItem(String name, double cost, int quantity) {
		if (name == null || name.isEmpty()) {
			this.name = "";
		} else {
			this.name = name;
		}
		
		if (cost < 0) {
			this.cost = 0;
		} else {
			this.cost = cost;
		}
		
		if (quantity < 0) {
			this.quantity = 0;
		} else {
			this.quantity = quantity;
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
	 * get the cost of an item
	 * 
	 * @return the cost of an item
	 */
	public double getCost() {
		return this.cost;
	}
	
	/**
	 * Get the quantity of an item
	 * 
	 * @return the quantity of an item
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Checks to make sure a new quantity variable is >= 0
	 * 
	 * @param newQuantity is a possible new quantity for an InventoryItem
	 */
	public void setQuantity(int newQuantity) {
		if (newQuantity >= 0) {
			this.quantity = newQuantity;
		}
	}
	
	/**
	 * Checks that there is enough of an item in inventory and that the
	 * amount to be purchased is >= 0
	 * 
	 * @param amountPuchased object 
	 */
	public void purchaseItem(int amountPuchased) {
		if (amountPuchased <= this.quantity && amountPuchased >= 0) {
			this.quantity -= amountPuchased;
		} 
	}
	
	/**
	 * Converts the cost, quantity, and name into a string
	 * 
	 * @return a string that is shows the name, cost and quantity of an item
	 * 
	 */
	public String toString() {
		String formattedCost = String.format("%6s", String.format("%.2f", this.getCost()));
		String formattedQuantity = String.format("%3s", Integer.toString(this.getQuantity()));
		String formattedName = String.format("%-10s", this.getName());
		
		return formattedName + " $" + formattedCost + " Quantity: " + formattedQuantity + "\n";		
	}
}
