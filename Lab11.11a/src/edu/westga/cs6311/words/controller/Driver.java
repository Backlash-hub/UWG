package edu.westga.cs6311.words.controller;

import edu.westga.cs6311.words.view.StartGui;

/**
 * Controller with the entry point for the application.
 * **********************************************
 * ***  DO NOT MODIFY THE CODE IN THIS CLASS  ***
 * ********************************************** 
 * 
 * @author 	CS6311
 * @version	Fall 2020
 */
public class Driver {

	/**
	 * Schedules a job for the event-dispatching thread that
	 * creates and shows this application's GUI.
	 * 
	 * @param args	not used
	 */
	public static void main(String[] args) {
        StartGui theGui = new StartGui();
        theGui.run();
    }
}
