package edu.westga.cs6311.homemart.view;

import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs6311.homemart.model.Inventory;
import edu.westga.cs6311.homemart.model.InventoryItem;
import edu.westga.cs6311.homemart.model.Shopper;

/**
 *The Shopper UI and Shopper info
 * 
 * @author William Pevytoe
 * 
 * @version 12/2/23
 */
public class ShopperView {
	private Scanner userInput;
	private Inventory theInventory;
	private Shopper theShopper;
	
	/**
	 * Constructs the User inputs and Inventory
	 * 
	 * @param items is theInventory objects
	 */
	public ShopperView(Inventory items) {
		this.userInput = new Scanner(System.in);
		this.theInventory = items;
	}
	
	/**
	 * Runs the program
	 */
	public void runShopper() {
		System.out.println("\nWelcome to the Shopper Application\n");
		this.getShopperInformation();
		int numberSelection = 0;
		while (numberSelection != 6) {
			this.displayMenu();
	        numberSelection = this.validateSelection(1, 6);
	        this.selectTask(numberSelection);
	        }
	    }
	
	private void getShopperInformation() {
		String name = "";
		Double budget = 0.0;
		while (name.isEmpty()) {
			System.out.println("Please enter your name: ");
			name = this.userInput.nextLine();
		}
		while (budget <= 0) {
			System.out.println("Please enter the amount you have to spend:  ");
			budget = this.userInput.nextDouble();
		}
		this.theShopper = new Shopper(name, budget);
		System.out.println("Welcome " + name + ". " + "Enjoy spending your " + String.format("$%6.2f", budget));	
	}
	
	private void displayMenu() {
		System.out.println("\n1 ‐ View inventory");
		System.out.println("2 ‐ Add item to the cart");
		System.out.println("3 ‐ View cart");
		System.out.println("4 ‐ View money remaining");
		System.out.println("5 ‐ Checkout");
		System.out.println("6 ‐ Quit shopper application\n");
	}
	
	private int validateSelection(int minimum, int maximum) {
        int numberSelection = 0;
        System.out.println("Enter your choice: ");
        numberSelection = this.userInput.nextInt();
        if (numberSelection < minimum || numberSelection > maximum) {
        	System.out.println("That's not a valid choice.  Please try again\n");
        }
        return numberSelection;
    }
	 
	private void selectTask(int numberSelection) {
		if (numberSelection == 1) {
			this.viewInventory();
		} else if (numberSelection == 2) {
			this.addNewItem();
		} else if (numberSelection == 3) {
			this.viewCart();
		} else if (numberSelection == 4) {
			this.viewRemainingBudget();
		} else if (numberSelection == 5) {
			this.checkout();
		} else if (numberSelection == 6) {			
			System.out.println("Thank you for using the shopper application.\n");
        	HomemartView homeMartView = new HomemartView(this.theInventory);
        	homeMartView.runHomemart();
		}
	}

	private void viewInventory() {
		System.out.println(this.theInventory.toString());
	}
	
	private void addNewItem() {
		String name = "";
		int quantity = 0;
		while (name.isEmpty()) {
			System.out.println("\nEnter item name to be purchased: ");
			name = this.userInput.next();
			if (this.theInventory.findItem(name) == null) {
				System.out.println("That item does not exist");
				return;
			}
		}
		while (quantity <= 0) {
			System.out.println("Enter the number of " + name + "(s) to buy: ");
			quantity = this.userInput.nextInt();
			if (this.theInventory.findItem(name).getQuantity() < quantity) {
				System.out.println("There are not enough " + name + "(s) in the inventory.");
				return;
			}
		}
		
		InventoryItem item = this.theInventory.findItem(name);
		
		if (this.theShopper.haveEnoughToBuy(item, quantity)) {
			this.theShopper.addItem(item, quantity);
			System.out.println("You have added " + quantity + " " + name + "(s) to your cart");
			System.out.println("You have " + String.format("$%6.2f", this.theShopper.getBudget()) + " remaining to spend.");
			} else {
				System.out.println("You don't have enough money to purchase " + quantity + " " + name + "(s).");
			}
	}
	
	private void viewCart() {
		ArrayList<InventoryItem> cartItems = this.theShopper.getTheCart();
		if (cartItems.isEmpty()) {
			System.out.println("\nNo items in Cart");
			
		} else {
			for (InventoryItem item : cartItems) {
				System.out.println("\n" + item);
			}
		}
		
	}
	
	private void viewRemainingBudget() {
		System.out.println("\nAmount remaining to spend: " + String.format("$%6.2f", this.theShopper.getBudget()));
	}
	
	private void checkout() {
		this.theShopper.purchaseCart();
		System.out.println("\nYour purchase has been completed.");
	}

}
