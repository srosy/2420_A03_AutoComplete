package a03;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestTerm {
	static Term t;
	static Term t2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t = new Term("test", 1);
		t2 = new Term("dog", 2);
	}

	@Test
	void testTerm() {
		int expectedWeight = 1;
		String expectedQuery = "test";
		assertTrue(t.query == expectedQuery);
		assertTrue(t.weight == expectedWeight);

		int expectedWeight2 = 2;
		String expectedQuery2 = "dog";
		assertTrue(t2.query == expectedQuery2);
		assertTrue(t2.weight == expectedWeight2);
	}

	@Test
	void testByReverseWeightOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testByPrefixOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
