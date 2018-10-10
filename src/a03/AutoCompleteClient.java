/************************************************
 * Author(s): William McConnell, Spencer Rosenvall
 * Class: CSIS 2420
 * Professor: Frau Posch
 * Assignment: A03_AutoComplete
 ************************************************/

package a03;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Class AutoCompleteClient is a test client for Autocomplete.java,
 * BinarySearchDeluxe.java and Term.java. Operation is tested by providing a
 * text file and int k, which is the number of max searches that should be
 * listed.
 * 
 * @authors William McConnell, Spencer Rosenvall
 *
 */
public class AutoCompleteClient {
	/**
	 * Tests the main operation of the classes mentioned in the class doc-comment
	 * above.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String filename = "src/wiktionary.txt";
		In in = new In(filename);
		int N = in.readInt();
		Term[] terms = new Term[N];
		for (int i = 0; i < N; i++) {
			double weight = in.readDouble();
			in.readChar();
			String query = in.readLine();
			terms[i] = new Term(query, weight);
		}

		int k = 20;
		Autocomplete autocomplete = new Autocomplete(terms);
		while (StdIn.hasNextLine()) {
			String prefix = StdIn.readLine();
			Term[] results = autocomplete.allMatches(prefix);
			for (int i = 0; i < Math.min(k, results.length); i++)
				StdOut.println(results[i]);
		}
	}
}
