package edu.westga.cs6311.homemart.controller;

import edu.westga.cs6311.homemart.model.Inventory;
import edu.westga.cs6311.homemart.view.HomemartView;

/**
 * The Program start
 * 
 * @author William Pevytoe
 * 
 * @version 12/01/2023
 */
public class HomemartDriver {

	/**
	 * Starts the program
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		HomemartView homemartView = new HomemartView(inventory);
		homemartView.runHomemart();
	}
}
