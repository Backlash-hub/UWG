package edu.westga.cs6311.homemart.view;

import java.util.Scanner;

import edu.westga.cs6311.homemart.model.Inventory;

/**
 *The user UI and user info
 * 
 * @author William Pevytoe
 * 
 * @version 12/2/23
 */
public class HomemartView {
	private Scanner userInput;
	private Inventory theInventory;
	
	/**
	 * Constructs the User inputs and Inventory
	 * 
	 * @param item is theCart objects
	 */
	public HomemartView(Inventory item) {
		this.userInput = new Scanner(System.in);
		this.theInventory = item;
	}
	
	/**
	 * Runs the program
	 */
	public void runHomemart() {
        System.out.println("Welcome to the Homemart Application");
        this.displayMenu();
        int numberSelection = this.validateSelection(1, 3);
        this.selectTask(numberSelection);
    }

    private void displayMenu() {
        System.out.println("\n1 ‐ Start manager application");
        System.out.println("2 ‐ Start shopper application");
        System.out.println("3 ‐ Quit\n");
    }

    private int validateSelection(int minimum, int maximum) {
    	int numberSelection = 0;
        System.out.println("Enter your choice: ");
        numberSelection = this.userInput.nextInt();
        if (numberSelection < minimum || numberSelection > maximum) {
        	System.out.println("That's not a valid choice.  Please try again\n");
        	this.runHomemart();
        }
        return numberSelection;
    }
	
	private void selectTask(int numberSelection) {
			if (numberSelection == 1) {
				this.managerApp();
			} else if (numberSelection == 2) {
				this.shopperApp();
			} else if (numberSelection == 3) {
				System.out.println("Thank you for using the Homemart application.  Have a nice day.");
			} 
		}
	
	private void managerApp() {
		ManagerView managerView = new ManagerView(this.theInventory);
		managerView.runManager();
	}
	
	private void shopperApp() {
		ShopperView shopperview = new ShopperView(this.theInventory);
		shopperview.runShopper();
	}
}
