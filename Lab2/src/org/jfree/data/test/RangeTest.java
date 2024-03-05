package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
						0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	// 3.2.1 getLowerBound() //

	// Test Case 1 // 
	@Test
	public void testPositiveLowerAndUpperBound() {
	    rangeObjectUnderTest = new Range(1.0, 8.0);
	    assertEquals("Positive lower and upper bound", 1.0, rangeObjectUnderTest.getLowerBound(), 0.000001);
	}

	// Test Case 2 //
	@Test
	public void testNegativeLowerAndPositiveUpperBound() {
	    rangeObjectUnderTest = new Range(-2.0, 4.0);
	    assertEquals("Negative lower bound and positive upper bound", -2.0, rangeObjectUnderTest.getLowerBound(), 0.000001);
	}

	// Test Case 3 //
	@Test
	public void testNegativeLowerAndZeroUpperBound() {
	    rangeObjectUnderTest = new Range(-2.0, 0.0);
	    assertEquals("Negative lower bound and zero upper bound", -2.0, rangeObjectUnderTest.getLowerBound(), 0.000001);
	}

	// Test Case 4 //
	@Test
	public void testNegativeLowerAndUpperBound() {
	    rangeObjectUnderTest = new Range(-2.0, -1.0);
	    assertEquals("Negative lower and upper bound", -2.0, rangeObjectUnderTest.getLowerBound(), 0.000001);
	}

	// 3.2.2 getLength()

	// Test Case 1 //
	@Test
	public void testLengthPositiveLowerAndUpperBound() {
	    rangeObjectUnderTest = new Range(2.0, 6.0);
	    assertEquals("Positive lower and upper bound", 4.0, rangeObjectUnderTest.getLength(), 0.000001);
	}

	// Test Case 2 //
	@Test
	public void testLengthNegativeLowerAndPositiveUpperBound() {
	    rangeObjectUnderTest = new Range(-4.0, 4.0);
	    assertEquals("Negative lower and positive upper bound", 0.0, rangeObjectUnderTest.getLength(), 0.000001);
	}

	// Test Case 3 //
	@Test
	public void testLengthNegativeLowerAndZeroUpperBound() {
	    rangeObjectUnderTest = new Range(-6.0, 0);
	    assertEquals("Negative lower and zero upper bound", -3.0, rangeObjectUnderTest.getLength(), 0.000001);
	}

	// Test Case 4 //
	@Test
	public void testLengthNegativeLowerAndUpperValues() {
	    rangeObjectUnderTest = new Range(-8.0, -4.0);
	    assertEquals("Negative lower and upper values", -4.0, rangeObjectUnderTest.getLength(), 0.000001);
	}

	// Test Case 5 //
	@Test
	public void testLengthPositiveLowerAndNegativeUpperBound() {
	    try {
	        rangeObjectUnderTest = new Range(5.0, -5.0);
	        fail("Expected IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	    }
	}

	// 3.2.5 expand(Range range, double lowerMargin, double upperMargin) //

	// Test Case 1 //
	@Test
	public void testPositiveMargins() {
	    Range expandedRange = Range.expand(new Range(2.0, 6.0), 0.25, 0.5);
	    assertEquals("Positive margins", new Range(1.0, 8.0), expandedRange);
	}

	// Test Case 2 //
	@Test
	public void testNegativeMargins() {
	    try {
	        Range expandedRange = Range.expand(new Range(2.0, 6.0), -0.25, -0.5);
	        fail("Expected IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	    }
	}

	// Test Case 3 //
	@Test
	public void testZeroMargins() {
	    Range expandedRange = Range.expand(new Range(2.0, 6.0), 0, 0);
	    assertEquals("Zero margins", 0.0, expandedRange.getLength(), 0.000001);
	}

	// Test Case 4 //
	@Test
	public void testLowerBoundEqualsUpperBound() {
	    Range expandedRange = Range.expand(new Range(2.0, 2.0), 0.5, 0.5);
	    assertEquals("Lower bound = upper bound", new Range(2.0, 3.0), expandedRange);
	}

	
}

