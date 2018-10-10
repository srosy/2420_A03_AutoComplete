/************************************************
 * Author(s): William McConnell, Spencer Rosenvall
 * Class: CSIS 2420
 * Professor: Frau Posch
 * Assignment: A03_AutoComplete
 ************************************************/

package a03;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Class TestTerm tests methods in Term.java.
 * 
 * @authors William McConnell, Spencer Rosenvall
 *
 */
class TestTerm {
	static Term t1;
	static Term t2;

	/**
	 * Initializes test objects.
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t1 = new Term("test", 1);
		t2 = new Term("dog", 2);
	}

	/**
	 * Tests using comparator if reverse weight order matches.
	 */
	@Test
	void testByReverseWeightOrder() {
		Comparator<Term> c = Term.byReverseWeightOrder();
		int expected = 1;
		int actual = c.compare(t1, t2);
		assertTrue(expected == actual);
		assertFalse(expected < actual);
		assertFalse(expected > actual);
	}

	/**
	 * Tests using comparator if prefix order matches.
	 */
	@Test
	void testByPrefixOrder() {
		Comparator<Term> c = Term.byPrefixOrder(2);
		int expected = 1;
		int actual = c.compare(t1, t2);
		assertFalse(expected == actual);
		assertFalse(expected > actual);
		assertTrue(expected < actual);
	}

	/**
	 * Tests using native comparator.
	 */
	@Test
	void testCompareTo() {
		int actual = t1.compareTo(t2);
		int expected = 16;
		assertTrue(expected == actual);
		assertFalse(expected < actual);
		assertFalse(expected > actual);
	}
}
