/************************************************
 * Author(s): William McConnell, Spencer Rosenvall
 * Class: CSIS 2420
 * Professor: Frau Posch
 * Assignment: A03_AutoComplete
 ************************************************/

package a03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Class TestAutocomplete tests methods in Autocomplete.java.
 * 
 * @authors William McConnell, Spencer Rosenvall
 *
 */
class TestAutocomplete {

	static Term t1;
	static Term t2;
	static Term t3;
	static Term t4;
	static Term t5;

	static Term test;
	static Term[] t;

	static Autocomplete a;

	/**
	 * Initializes test objects.
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t1 = new Term("amazonian", 1);
		t2 = new Term("banana", 2);
		t3 = new Term("car", 3);
		t4 = new Term("waifu", 4); // t[3]
		t5 = new Term("water", 5); // t[4]

		test = new Term("wa", 6);
		t = new Term[] { t1, t2, t3, t4, t5 };
		a = new Autocomplete(t);
	}

	/**
	 * Tests true if each query and weight to each Term[] match. Also tests if
	 * result are unique in length.
	 */
	@Test
	void testAllMatches() {
		Term[] expected = { new Term("water", 5), new Term("waifu", 4) };
		Term[] actual = a.allMatches("wa");
		for (int i = 0; i < actual.length; i++) {
			assertTrue(expected[i].query == actual[i].query);
			assertTrue(expected[i].weight == actual[i].weight);
		}
		assertFalse(a.allMatches("ba") == a.allMatches("wa"));
	}

	/**
	 * Tests for the number of matches by the given string(query).
	 */
	@Test
	void testNumberOfMatches() {
		int expected = 2;
		int actual = a.numberOfMatches("wa");
		assertTrue(expected == actual);
		assertFalse(a.numberOfMatches("wai") != a.numberOfMatches("wat"));
	}
}
