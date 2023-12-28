package edu.westga.cs6311.words.controller;

import edu.westga.cs6311.words.model.Word;
import edu.westga.cs6311.words.model.WordCollection;

/**
 * WordController directs the behaviors of Word objects.
 * 
 * @author William Pevytoe
 * 
 * @version 10/27/2023s
 * 
 */
public class WordController {
	private WordCollection theCollection;

	/**
	 * Creates a new WordController object to direct the
	 * Word objects in the specified WordCollection object.
	 * 
	 * @param aCollection	A collection of words	 
	 * 
	 * @precondition aCollection != null
	 * 
	 */
	public WordController(WordCollection aCollection) {
		if (aCollection == null) {
			aCollection = new WordCollection();
		}
		
		this.theCollection = aCollection;
	}
	
	/**
	 * Adds a new Word object for the the specified String to the collection.
	 * 
	 * @precondition 		characters != null	 
	 * @param characters	the characters from which to build a Word instance
	 * 
	 */
	public void addWord(String characters) {
		if (characters == null) {
			characters = "";
		} else {
			Word combindCharacters = new Word(characters);
			combindCharacters.moveToRandomLocation();
			this.theCollection.add(combindCharacters);
		}
	}
	
	/**
	 * Moves each Word object in the collection to a random location.
	 * 
	 */
	public void moveEveryWord() {
		for (Word current : this.theCollection) {
			current.moveToRandomLocation();
		}
	}

	/**
	 * Moves the leftmost Word object - the one with the lowest x value - to
	 * a random x,y location.
	 * 
	 */
	public void moveLeftmostWord() {	
		Word leftWord = this.theCollection.getLeftmostWord();
		leftWord.moveToRandomLocation();
	}
	
	/**
	 * Moves the longest Word object - the one that has the most 
	 * letters - to a random x,y location.
	 * 
	 */
	public void moveLongestWord() {
		Word longestWord = this.theCollection.getLongestWord();
		longestWord.moveToRandomLocation();
	}

	/**
	 * Moves the highest Word object - the one with the lowest y value - to
	 * a random x,y location.
	 * 
	 */
	public void moveHighestWord() {
		Word highestWord = this.theCollection.getHighestWord();
		highestWord.moveToRandomLocation();
	}
}
