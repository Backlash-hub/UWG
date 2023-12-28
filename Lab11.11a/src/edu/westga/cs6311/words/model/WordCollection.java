package edu.westga.cs6311.words.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * WordCollection manages a collection of Word objects.
 * 
 * @author William Pevytoe
 * 
 * @version 10/27/2023
 * 
 */
public class WordCollection implements Iterable<Word> {
	private ArrayList<Word> theWords;

	/**
	 * Creates a new instance of WordCollection with
	 * an empty collection of Word objects.
	 */
	public WordCollection() {
		this.theWords = new ArrayList<Word>();
	}
	
	/**
	 * Adds the specified Word object to this collection.
	 * 
	 * @param 			newWord			the word to added 
	 * @precondition 	newWord != null
	 */
	public void add(Word newWord) {
		if (newWord == null) {
			newWord = new Word("");
		} else {
			this.theWords.add(newWord);
		}
	}
	
	/**
	 * Returns the number of elements in this collection.
	 *   
	 * @return 	the number of words
	 * 
	 */
	public int size() {
		return this.theWords.size();
	}
	
	/**
	 * Returns true if the size of this collection is 0,
	 * and false otherwise.
	 * 
	 * @return 	true if and only if size() == 0
	 */
	public boolean isEmpty() {
		return this.theWords.isEmpty();
	}
	
	/**
	 * Returns true if this collection contains the specified element,
	 * and false otherwise.
	 * 
	 * @param 		aWord		the object to look for
	 * 
	 * @return		true if and only if theWord is an element of this collection
	 */
	public boolean contains(Word aWord) {
		return this.theWords.contains(aWord);
	}
	
	/**
	 * Returns the element in this collection that is farthest left, that
	 * is, the Word object with the lowest x-coordinate.
	 * 
	 * @precondition	!isEmpty()
	 *  
	 * @return 			the Word with the minimal x value
	 * 
	 */
	public Word getLeftmostWord() {
		if (this.isEmpty()) {
			return null;
		}
		
		Word leftmostSoFar = this.theWords.get(0);
		
		for (Word current : this.theWords) {
			if (current.getXLocation() < leftmostSoFar.getXLocation()) {
				leftmostSoFar = current;
			}
		}
		
		return leftmostSoFar;
	}
	
	/**
	 * Returns the element in this collection with the most letters.
	 * If there are several with that number, returns the first of them.
	 * 
	 * @precondition	!isEmpty()	 
	 * 
	 * @return 			the first Word with the longest length
	 * 
	 */
	public Word getLongestWord() {
		if (this.isEmpty()) {
			return null;
		}
		
		Word longestWord = this.theWords.get(0);
		
		for (Word current : this.theWords) {
			if (current.length() > longestWord.length()) {
				longestWord = current;
			}
		}
		
		return longestWord;
	}
	
	/**
	 * Returns the element in this collection that is nearest the
	 * top of the window, that is, the Word object with the lowest 
	 * y-coordinate.
	 * 
	 * @precondition	!isEmpty()	 
	 * 
	 * @return 			the Word with the lowest y value
	 * 
	 */
	public Word getHighestWord() {
		if (this.isEmpty()) {
			return null;
		}
		
		Word highestWord = this.theWords.get(0);
		
		for (Word current : this.theWords) {
			if (current.getYLocation() < highestWord.getYLocation()) {
				highestWord = current;
			}
		}
		
		return highestWord;
	}

	/** 
	 * Returns an iterator over the collection of Word objects.
	 * This lets this object be used as the target of a foreach loop.
	 * 
	 * @return an iterator 
	 */
	@Override
	public Iterator<Word> iterator() {
		return this.theWords.iterator();
	}
}
