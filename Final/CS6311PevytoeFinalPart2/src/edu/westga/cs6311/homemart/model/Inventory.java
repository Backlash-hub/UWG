package edu.westga.cs6311.homemart.model;

import java.util.ArrayList;

/**
 * The Inventory class will keep track of a collection of InventoryItems objects
 * 
 * @author William Pevytoe
 * 
 * @version 11/30/23
 * 
 */
public class Inventory {
	private ArrayList<InventoryItem> theInventory;
	
	/**
	 * Create a new instance of the Inventory with an
	 * empty collection of InventoryItem objects
	 */
	public Inventory() {
		this.theInventory = new ArrayList<>();
	}
	
	/**
	 * Adds hammer and nails to the InventoryItem ArrayList
	 */
	public void openStore() {
		InventoryItem hammer = new InventoryItem("Hammer", 9.99, 5);
		InventoryItem nails = new InventoryItem("Nails", 0.98, 100);
		this.theInventory.add(hammer);
		this.theInventory.add(nails);
	}
	
	/**
	 * Finds and return the first InventoryItem that matches
	 * the specified name
	 * 
	 * @param	searchName		The name to be searched for
	 * @precondition			searchName != null
	 * @return					Found InventoryItem object or null if not found
	 */
	public InventoryItem findItem(String searchName) {
		if (searchName == null) {
			return null;
		}
		
		for (InventoryItem current : this.theInventory) {
			if (current.getName().equalsIgnoreCase(searchName)) {
				return current;
			}
		}
		return null;
	}
	
	/**
	 * Adding a new object to InventoryItem array
	 * 
	 * @param name string name of new item
	 * @param cost double value of new item
	 * @param quantity int number of new item
	 */
	public void addItem(String name, double cost, int quantity) {
		InventoryItem newItem = new InventoryItem(name, cost, quantity);
		this.theInventory.add(newItem);
	}
	
	/**
	 * Gets the cheapest object in InventoryItem array
	 * 
	 * @return cheapestItem in array
	 */
	public InventoryItem getCheapestItem() {
		InventoryItem cheapestItem = this.theInventory.get(0);
		for (InventoryItem item : this.theInventory) {
			if (item.getCost() < cheapestItem.getCost()) {
				cheapestItem = item;
			}
		}
		return cheapestItem;
	}
	
	/**
	 * Gets the most expensive object in the Inventory array
	 * 
	 * @return mostExpensiveItem in array
	 */
	public InventoryItem getMostExpensiveItem() {
		InventoryItem mostExpensiveItem = this.theInventory.get(0);
		for (InventoryItem item : this.theInventory) {
			if (item.getCost() > mostExpensiveItem.getCost()) {
				mostExpensiveItem = item;
			}
		}
		return mostExpensiveItem;
	}
	
	/**
	 * Get the total quantity of items in for all objects  
	 * 
	 * @return total quantity of items 
	 */
	public int getTotalQuantity() {
		int total = 0;
		for (InventoryItem item : this.theInventory) {
			total += item.getQuantity();
		}
		return total;
	}
	
	/**
	 * Gets the average cost of all the items combined 
	 * 
	 * @return average cost all objects costs combined
	 */
	public double getAverageCost() {
		double average = 0.00;
		double total = 0.0;
		int numItems = this.theInventory.size();
		for (InventoryItem item : this.theInventory) {
			total += item.getCost();
		}
		average = total / numItems;
		return average;
	}
	
	/**
	 * Adds items in inventory it string
	 * 
	 * @return inventoryDescription string
	 */
	public String toString() {
		if (this.theInventory.isEmpty()) {
			return "Inventory is Empty";
		}
		
		String inventoryDescription = "";
		for (InventoryItem item : this.theInventory) {
			inventoryDescription += item.toString();
		}
		inventoryDescription += "\nNumber of items: " + this.theInventory.size() + "\n"; 
		inventoryDescription += "Total quantity of all items: " + this.getTotalQuantity() + "\n";
		inventoryDescription += "Most expensive item:  \t" + String.format("%-12s", this.getMostExpensiveItem());
		inventoryDescription += "Least expensive item: \t" + String.format("%-12s", this.getCheapestItem());
		inventoryDescription += "Average item cost: " + String.format("$%.02f", this.getAverageCost()) + "\n"; 
		
		return inventoryDescription;
	}
}
