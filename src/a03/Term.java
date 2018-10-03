/************************************************
 * Author(s): William McConnell, Spencer Rosenvall
 * Class: CSIS 2420
 * Professor: Frau Posch
 * Assignment: A03_AutoComplete
 ************************************************/
package a03;

import java.util.Comparator;

/**
 * Class Term implements interface Comparable of type term. Term can create term
 * objects and compare them by reversed weight order, by prefix order, and
 * default.
 * 
 * @author SpencerR, William McConnell
 *
 */
public class Term implements Comparable<Term> {
	public String query;
	public double weight;

	/**
	 * Constructs and initializes a term with the given query string and weight.
	 * 
	 * @param query
	 * @param weight
	 */
	public Term(String query, double weight) {
		if (query != null) {
			if (weight < 0) {
				throw new java.lang.IllegalArgumentException();
			}
			this.query = query;
			this.weight = weight;
		} else {
			throw new java.lang.NullPointerException();
		}
	}

	/**
	 * Compares the terms in descending order by weight.
	 * 
	 * @return
	 */
	public static Comparator<Term> byReverseWeightOrder() {
		return new Comparator<Term>() {
			public int compare(Term first, Term second) {
				if (first.weight > second.weight) {
					return -1;
				} else if (first.weight == second.weight) {
					return 0;
				} else {
					return 1;
				}
			}
		};
	}

	/**
	 * Compare the terms in lexicographic order but using only the first r
	 * characters of each query.
	 * 
	 * @param r
	 * @return
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		final int firstQChar = r;

		if (r < 0) {
			throw new IllegalArgumentException("r must be greater than 0");
		}

		return new Comparator<Term>() {
			public int compare(Term first, Term second) {
				int minQLength;
				String firstPrefix = first.query;
				String secondPrefix = second.query;

				if (firstPrefix.length() < secondPrefix.length()) {
					minQLength = firstPrefix.length();
				} else {
					minQLength = secondPrefix.length();
				}

				if (minQLength >= firstQChar) {
					return firstPrefix.substring(0, firstQChar).compareTo(secondPrefix.substring(0, firstQChar));
				} else if (firstPrefix.substring(0, minQLength).compareTo(secondPrefix.substring(0, minQLength)) == 0) {
					if (firstPrefix.length() == minQLength)
						return -1;
					else
						return 1;
				} else
					return firstPrefix.substring(0, minQLength).compareTo(secondPrefix.substring(0, minQLength));
			}
		};
	}

	/**
	 * Compares the terms in lexicographic order by query.
	 */
	public int compareTo(Term t) {
		return this.query.compareTo(t.query);
	}

	/**
	 * Return a string representation of the term in the following format: the
	 * weight, followed by a tab, followed by the query.
	 */
	public String toString() {
		return Double.toString(this.weight) + "\t" + this.query;
	}
}