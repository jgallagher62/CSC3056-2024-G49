package org.jfree.data;

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

	
	//3.2.2
	
	//test case 11 to test the get upper value of ranges 2 to 8
	@Test
	public void testPositiveLowerAndUpperBoundGetUpperSucceed_TC11() {
		rangeObjectUnderTest = new Range(2.0, 8.0);
		assertEquals("Upper bound should be 8.0", 8.0, rangeObjectUnderTest.getUpperBound(), 0.0000001d);
	}

		
	//test case 12 to test the get upper value of ranges -4.0 to 4.0
	@Test
	public void testNegativeLowerAndPositiveUpperBoundGetUpperSucceed_TC12() {
		rangeObjectUnderTest = new Range(-4.0, 4.0);
	    assertEquals("Upper bound should be 4.0", 4.0, rangeObjectUnderTest.getUpperBound(), 0.000001);
	}
		
		
	//test case 13 to test the get upper value of ranges -6.0 to 0
	@Test
	public void testNegativeLowerAnd0UpperGetUpperSucceed_TC13() {
		rangeObjectUnderTest = new Range(-6.0, 0);
	    assertEquals("Upper bound should be 0", 0, rangeObjectUnderTest.getUpperBound(), 0.000001);
	}
		
		
	//test case 14 to test the get upper value of ranges -8.0 to -2.0
	@Test
	public void testNegativeLowerAndUpperGetUpperSucceed_TC14() {
		rangeObjectUnderTest = new Range(-8.0, -2.0);
	    assertEquals("Upper bound should be -2.0", -2.0, rangeObjectUnderTest.getUpperBound(), 0.000001);
	}
		
		
		
		
	//3.2.4
		
		
	//test case 15 to test the central value of 6 and 12
	@Test
	public void testCentralValueOnPositiveValues_TC15() {
		rangeObjectUnderTest = new Range(6.0, 12.0);
		assertEquals("The central value of 6.0 and 12.0 should be 9.0",
		9.0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
		
	//test case 16 to test the central value on -4.0 and 4.0
	@Test
	public void testCentralValueOnNegLowerValues_TC16() {
		rangeObjectUnderTest = new Range(-4.0, 4.0);
		assertEquals("The central value of -4.0 and 4.0 should be 0.0",
		0.0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
			

	//test case 16 to test the central value on -4.0 and 4.0
	@Test
	public void testCentralValueOnNegLowerValueZeroUpper_TC17() {
		rangeObjectUnderTest = new Range(-6.0, 0.0);
		assertEquals("The central value of -6.0 and 0.0 should be -3.0",
		-3.0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
}

