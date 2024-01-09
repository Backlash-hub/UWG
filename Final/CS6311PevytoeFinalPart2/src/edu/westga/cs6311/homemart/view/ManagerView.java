package edu.westga.cs6311.homemart.view;

import java.util.Scanner;

import edu.westga.cs6311.homemart.model.Inventory;

/**
 * The user UI and user info
 * 
 * @author William Pevytoe
 * 
 * @version 12/1/2023
 */
public class ManagerView {
	private Scanner userInput;
	private Inventory theInventory;
	
	/**
	 * Constructs the User inputs and Inventory
	 * 
	 * @param items is theInventory objects
	 */
	public ManagerView(Inventory items) {
		this.userInput = new Scanner(System.in);
		this.theInventory = items;
	}
	
	/**
	 * Runs the program
	 */
	public void runManager() {
		System.out.println("\nWelcome to the Manager Application");
		int numberSelection = 0;
		while (numberSelection != 4) {
			this.displayMenu();
	        numberSelection = this.validateSelection(1, 4);
	        this.selectTask(numberSelection);
	        }
	    }

	private void displayMenu() {
		System.out.println("\n1 ‐ Open new store");
		System.out.println("2 ‐ Add new item");
		System.out.println("3 ‐ View inventory");
		System.out.println("4 ‐ Quit manager application\n");
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
            this.theInventory.openStore();
        } else if (numberSelection == 2) {
            this.addNewItem();
        } else if (numberSelection == 3) {
            this.displayInventory();
        } else if (numberSelection == 4) {
        	System.out.println("Thank you for using the manager application.\n");
        	HomemartView homeMartView = new HomemartView(this.theInventory);
        	homeMartView.runHomemart();
        }
    }

	private void displayInventory() {
		System.out.println("\n" + this.theInventory.toString());
	}
	
	private void addNewItem() {
		this.userInput = new Scanner(System.in);
		String name = "";
		Double cost = 0.0;
		int quantity = 0;
		while (name.isEmpty()) {
			System.out.println("Please enter item's name: ");
			name = this.userInput.nextLine();

		}
		while (cost <= 0) {
			System.out.println("Please enter the item's cost: ");
			cost = this.userInput.nextDouble();
		}
		
		while (quantity <= 0) {
			System.out.println("Please enter the item's quantity: ");
			quantity = this.userInput.nextInt();
		}
		
		this.theInventory.addItem(name, cost, quantity);
		System.out.println("You added " + quantity + " " + name + "(s)" + " at a cost of " + String.format("$%6.2f", cost) + " to the inventory");
	}
}
