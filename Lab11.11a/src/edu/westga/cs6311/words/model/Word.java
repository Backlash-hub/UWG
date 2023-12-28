package edu.westga.cs6311.words.model;

/**
 * Word represents a string of characters at an x, y location.
 * 
 * @author William Pevytoe
 * 
 * @version 10/26/2023
 * 
 */
public class Word {
	private static final int MAXIMUM_X = 500;	
	private static final int MAXIMUM_Y = 500;

	private String theCharacters;
	private int xLocation;
	private int yLocation;

	/**
	 * Creates a new Word object with the specified String at location 0,0.
	 * 
	 * @param 			characters 		the String of characters	 
	 * @precondition 	characters != null
	 * 
	 */
	public Word(String characters) {
		if (characters == null) {
			characters = "";
		}
		
		this.theCharacters = characters;
		this.xLocation = 0;
		this.yLocation = 0;
	}

	/**
	 * Returns the x-location of this object.
	 * 
	 * @return the location on the x-axis
	 */
	public int getXLocation() {
		return this.xLocation;
	}

	/**
	 * Returns the y-location of this object.
	 * 
	 * @return the location on the y-axis
	 */
	public int getYLocation() {
		return this.yLocation;
	}
	
	/**
	 * Changes the location of this object to random x and y values.
	 * 
	 * @precondition none
	 */
	public void moveToRandomLocation() {
		this.xLocation = (int) (Math.random() * Word.MAXIMUM_X);
		this.yLocation = (int) (Math.random() * Word.MAXIMUM_Y);
	}
	
	/**
	 * Returns the length of this object. Its length is equal to 
	 * the number of characters it contains.
	 * 
	 * @return the length of the sequence of characters stored in this object
	 */
	public int length() {
		return this.theCharacters.length();
	}
	
	/**
	 * Returns the characters represented by this object.
	 * 
	 * @return the String of characters
	 */
	public String getCharacters() {
		return this.theCharacters;
	}

}
