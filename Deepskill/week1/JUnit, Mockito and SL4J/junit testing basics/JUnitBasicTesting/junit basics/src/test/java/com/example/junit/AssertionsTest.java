package com.example.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class AssertionsTest {

	@Test
	public void assertEqualsShouldCompareIntegersAndStrings() {
		// Compare integers using assertEquals.
		assertEquals(10, 5 + 5);

		// Compare strings using assertEquals.
		assertEquals("JUnit", "JU" + "nit");
	}

	@Test
	public void assertNotEqualsShouldVerifyDifferentValues() {
		// Verify two different numbers are not equal.
		assertNotEquals(10, 5);

		// Verify two different strings are not equal.
		assertNotEquals("JUnit", "JUnit 4");
	}

	@Test
	public void assertTrueAndAssertFalseShouldCheckBooleans() {
		boolean condition = 8 > 5;

		// Check that the condition is true.
		assertTrue(condition);

		// Check that the opposite condition is false.
		assertFalse(5 > 8);
	}

	@Test
	public void assertNullAndAssertNotNullShouldCheckObjects() {
		String nullableValue = null;
		String value = "JUnit";

		// Check that the object reference is null.
		assertNull(nullableValue);

		// Check that the object reference is not null.
		assertNotNull(value);
	}

	@Test
	public void assertSameAndAssertNotSameShouldCheckReferences() {
		String sameReference = "JUnit";
		String anotherSameReference = sameReference;
		String differentReference = new String("JUnit");

		// Check that both variables point to the same object reference.
		assertSame(sameReference, anotherSameReference);

		// Check that these variables point to different object references.
		assertNotSame(sameReference, differentReference);
	}

	@Test
	public void assertArrayEqualsShouldCompareArrays() {
		int[] expected = {1, 2, 3};
		int[] actual = {1, 2, 3};

		// Compare both arrays element by element.
		assertArrayEquals(expected, actual);
	}

	@Test
	public void tryCatchShouldVerifyException() {
		// Try the code that should throw an exception.
		try {
			int result = 10 / 0;
			fail("Expected ArithmeticException to be thrown");
		} catch (ArithmeticException exception) {
			// Verify that the exception type is the expected one.
			assertTrue(exception instanceof ArithmeticException);
		}
	}
}