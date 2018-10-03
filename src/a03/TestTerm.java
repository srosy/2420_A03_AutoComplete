package a03;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestTerm {
	static Term t;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		t = new Term("test", 1);
	}

	@Test
	void testTerm() {
		int expectedWeight = 1;
		String expectedQuery = "test";
		assertTrue(t.query == expectedQuery);
		assertTrue(t.weight == expectedWeight);
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
