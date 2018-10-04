/************************************************
 * Author(s): William McConnell, Spencer Rosenvall
 * Class: CSIS 2420
 * Professor: Frau Posch
 * Assignment: A03_AutoComplete
 ************************************************/

package a03;

import java.util.Arrays;

/**
 * Class Autocomplete has methods to return the number of terms in a term array
 * based on a given prefix and return a sub-array of terms given a prefix
 * 
 * @author SpencerR, William McConnell
 *
 */
public class Autocomplete {

	private Term[] terms;
	private Term term;
	private int firstPosition;
	private int lastPosition;
	
	/**
	 * Initialize the data structure from the given array of terms.
	 * 
	 * @param terms
	 */
	public Autocomplete(Term[] terms) {
    	Arrays.sort(terms);
    	this.terms = terms.clone();
    }

	/**
	 * Return all terms that start with the given prefix, in descending order of weight.
	 * 
     * @param prefix
     * @return
	 */
	public Term[] allMatches(String prefix) {
    	term = new Term(prefix, 0);
    	lastPosition =  BinarySearchDeluxe.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
    	firstPosition = BinarySearchDeluxe.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
    	
    	Term[] matchingTerms = Arrays.copyOfRange(terms, firstPosition, lastPosition);
    	Arrays.sort(matchingTerms, Term.byReverseWeightOrder());
		return matchingTerms; 
    }

	/**
	 * Return the number of terms that start with the given prefix.
	 * 
     * @param prefix
     * @return
	 */
	public int numberOfMatches(String prefix) {
    	term = new Term(prefix, 0);
    	firstPosition = BinarySearchDeluxe.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
    	lastPosition =  BinarySearchDeluxe.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
    	
    	if(lastPosition != firstPosition)
    		return lastPosition + 1 - firstPosition;
    	return lastPosition - firstPosition;
    }
}
