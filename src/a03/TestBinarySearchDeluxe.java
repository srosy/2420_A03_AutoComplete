/************************************************
 * Author(s): William McConnell, Spencer Rosenvall
 * Class: CSIS 2420
 * Professor: Frau Posch
 * Assignment: A03_AutoComplete
 ************************************************/

package a03;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Class TestBinarySearchDeluxe tests methods in BinarySearchDeluxe.java.
 * 
 * @authors William McConnell, Spencer Rosenvall
 *
 */
class TestBinarySearchDeluxe {

	static Term t1;
	static Term t2;
	static Term t3;
	static Term t4;
	static Term t5;

	static Term test;
	static Term[] t;

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
	}

	/**
	 * Tests if expected and actual index are true for first index found.
	 */
	@Test
	void testFirstIndexOf() {
		int expectedIndex = 3;
		int actualIndex = BinarySearchDeluxe.firstIndexOf(t, test, Term.byPrefixOrder(test.query.length()));
		assertTrue(expectedIndex == actualIndex);
		assertFalse(actualIndex == BinarySearchDeluxe.firstIndexOf(t, t2, Term.byPrefixOrder(t2.query.length())));
	}

	/**
	 * Tests if expected and actual index are true for last index found.
	 */
	@Test
	void testLastIndexOf() {
		int expectedIndex = 4;
		int actualIndex = BinarySearchDeluxe.lastIndexOf(t, test, Term.byPrefixOrder(test.query.length()));
		assertTrue(expectedIndex == actualIndex);
		assertFalse(actualIndex == BinarySearchDeluxe.lastIndexOf(t, t2, Term.byPrefixOrder(t2.query.length())));
	}

}
