package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

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
	
	//this should throw an illgeal argument as the value is null which "InvalidParameterException - if null range object is passed in."
	@Test(expected = IllegalArgumentException.class)
	public void testExpandNullRange() {
	    Range.expand(null, 0.25, 0.5);
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
	
	
	
	
	//test case to test the contains(double) to improve line coverage 
	//it was not tested before so will implement test case to test this method
	//contains will check if a value is in a range (and if the value is the lower or upper bound in the range)
	
	//this will return true as 1.0 is in the range
	@Test
	public void testContainsValidValueInRange_TC1() {
		rangeObjectUnderTest = new Range (-2.0 , 4.0);
	    boolean result = rangeObjectUnderTest.contains(1.0);
	    assertTrue(result);
	}
	
	
	//this will return false as 5.0 is not in the range
	@Test
	public void testContainsInValidValueInRange_TC2() {
		rangeObjectUnderTest = new Range (-2.0 , 4.0);
		boolean result = rangeObjectUnderTest.contains(5.0);
		assertFalse(result);
	}
	
	//this will return false as -10.0 is not in the range
	@Test
	public void testContainsInValidValueInRange_TC3() {
		rangeObjectUnderTest = new Range (-2.0 , 4.0);
		boolean result = rangeObjectUnderTest.contains(-10.0);
		assertFalse(result);
	}
		
	//this will return true as -2.0 is the lower bound in the range
	@Test
	public void testContainsValidLowerBoundValueInRange_TC4() {
		rangeObjectUnderTest = new Range (-2.0 , 4.0);
		boolean result = rangeObjectUnderTest.contains(-2.0);
		assertTrue(result);
	}
		
		
	//this will return true as 4.0 is the upper bound
	@Test
	public void testContainsInValidUpperBoundValueInRange_TC5() {
		rangeObjectUnderTest = new Range (-2.0 , 4.0);
		boolean result = rangeObjectUnderTest.contains(4.0);
		assertTrue(result);
	}

	
	
	//the intersects (double, double) checks if the new range overlaps with the values in the range
	// it should return false if no values overlap etc
	
	//this will return true as the values in the second range intersect/overlap with initial 
	@Test
	public void testIntersectsContainedWithinRangeTrue_TC6() {
	    rangeObjectUnderTest = new Range(5.0, 10.0);
	    boolean result = rangeObjectUnderTest.intersects(6.0, 9.0);
	    assertTrue(result);
	}
	
	//this should return true as 7.0 is overlapping but 14.0 isnt - it failed - BUG
	@Test
	public void testIntersectsPartialOverlapInRange_TC7() {
	    rangeObjectUnderTest = new Range(5.0, 10.0);
	    boolean result = rangeObjectUnderTest.intersects(7.0, 14.0);
	    assertTrue(result);
	}
	
	
	// this should return false as both 1.0 and 3.0 are below the range 
	@Test
	public void testIntersectsAllBelowRange_TC8() {
	    rangeObjectUnderTest = new Range(5.0, 10.0);
	    boolean result = rangeObjectUnderTest.intersects(1.0, 3.0);
	    assertFalse(result);
	}
	
	// this should return false as both 1.0 and 3.0 are below the range 
	@Test
	public void testIntersectsAllAboveRange_TC9() {
	   rangeObjectUnderTest = new Range(5.0, 10.0);
	    boolean result = rangeObjectUnderTest.intersects(15.0, 30.0);
	    assertFalse(result);
	}
	
	// this should return true as they are the same range
	@Test
	public void testIntersectsBoundsEqual_TC10() {
	    rangeObjectUnderTest = new Range(5.0, 10.0);
	    boolean result = rangeObjectUnderTest.intersects(5.0, 10.0);
	    assertTrue(result);
	}
	
	// this should false as the lower bound is greater than the upper bound
	@Test
	public void testIntersectsUpperEqualToUpperBound_TC11() {
	    rangeObjectUnderTest = new Range(5.0, 10.0);
	    boolean result = rangeObjectUnderTest.intersects(10.0, 3.0);
	    assertFalse(result);
	}
	
	
	
	
	//equals function
	
	
	// this should return null as the value it is being comapred to to see if its equal is null
	@Test
	public void testEqualsWithNullObject() {
	    Range range = new Range(2.0, 5.0);
	    assertFalse(range.equals(null));
	}

	// this should return true as both of the ranges are equal to the same range
	@Test
	public void testEqualsWithSameRanges() {
	    Range range1 = new Range(2.0, 5.0);
	    Range range2 = new Range(2.0, 5.0);
	    assertTrue(range1.equals(range2));
	}

	// Test case to check if the input object has different lower bound, expecting false
	@Test
	public void testEqualsWithDifferentLowerBound() {
	    Range range1 = new Range(2.0, 5.0);
	    Range range2 = new Range(3.0, 5.0);
	    assertFalse(range1.equals(range2));
	}


	
	
	// testing the SHIFT function
	
	//this should pass as the delta range is positive 
    @Test
    public void testShiftPositiveDelta() {
        Range baseRange = new Range(0, 10);
        Range shiftedRange = Range.shift(baseRange, 2);
        Range expectedRange = new Range(2, 12);
        assertEquals(expectedRange, shiftedRange);
    }
    
    
    //this will be true as its testing the negative delta range
    @Test
    public void testShiftNegativeDelta() {
        Range baseRange = new Range(0, 10);
        Range shiftedRange = Range.shift(baseRange, -3);
        Range expectedRange = new Range(-3, 7);
        assertEquals(expectedRange, shiftedRange);
    }
    
    
    
    
    //to string function 
    @Test
    public void testToString() {
        Range range = new Range(0, 10);
        String expectedString = "Range[0.0,10.0]";
        assertEquals(expectedString, range.toString());
    }
    
    
    // expandToInclude
    
    
    //testing input range is null expects the method to return a new range with the value as both the lower and upper bounds.
    @Test
    public void testExpandToIncludeNullRange_TC1() {
        Range range = Range.expandToInclude(null, 5.0);
        Range expectedRange = new Range(5.0, 5.0);
        assertEquals(expectedRange, range);
    }
    
    
    //testing value is smaller than lower bound range. 
    @Test
    public void testExpandToIncludeLowerValue_TC2() {
        Range inputRange = new Range(0.0, 10.0);
        Range range = Range.expandToInclude(inputRange, -5.0);
        Range expectedRange = new Range(-5.0, 10.0);
        assertEquals(expectedRange, range);
    }
    
    //testing when the value is a larger value than the upper bound fo range 
    @Test
    public void testExpandToIncludeUpperValue_TC3() {
        Range inputRange = new Range(0.0, 10.0);
        Range range = Range.expandToInclude(inputRange, 15.0);
        Range expectedRange = new Range(0.0, 15.0);
        assertEquals(expectedRange, range);
    }   
    
    
    //testing whetre the value is already is within the range
    @Test
    public void testExpandToIncludeInRangeValue() {
        Range inputRange = new Range(0.0, 10.0);
        Range range = Range.expandToInclude(inputRange, 5.0);
        Range expectedRange = new Range(0.0, 10.0);
        assertEquals(expectedRange, range);
    }
    
    
    
    //constrain function will return the value within the range that is closest to the value.
    
    
    //testing value thats already in the rang e
    @Test
    public void testConstrainValidInRange() {
        Range range = new Range(0.0, 10.0);
        double constrainedValue = range.constrain(5.0);
        assertEquals(5.0, constrainedValue, 0.0001);
    }

    
    //testing value that is above / higher than the range
    @Test
    public void testConstrainInvalidAboveUpperBound() {
        Range range = new Range(0.0, 10.0);
        double constrainedValue = range.constrain(15.0);
        assertEquals(10.0, constrainedValue, 0.0001);
    }
    

    // tetsing the value when its below / less than the lower bound
    @Test
    public void testConstrainBelowLowerBound() {
        Range range = new Range(0.0, 10.0);
        double constrainedValue = range.constrain(-5.0);
        assertEquals(0.0, constrainedValue, 0.0001);
    }

    
    // the value is equal to the upper bound (10.0)
    @Test
    public void testConstrainOnUpperBound() {
        Range range = new Range(0.0, 10.0);
        double constrainedValue = range.constrain(10.0);
        assertEquals(10.0, constrainedValue, 0.0001);
    }

    
    //value is same as teh lower bound (0.0)
    @Test
    public void testConstrainOnLowerBound() {
        Range range = new Range(0.0, 10.0);
        double constrainedValue = range.constrain(0.0);
        assertEquals(0.0, constrainedValue, 0.0001);
    }
    
    //value is in the upper bound of the range 
    @Test
    public void testConstrainLessUpperBound() {
        Range range = new Range(5.0, 10.0);
        double constrainedValue = range.constrain(7.0);
        assertEquals(7.0, constrainedValue, 0.0001);
    }
    
    
    
    //shift - Returns a range the size of the input range, which has been moved positively (to the right) by the delta value. If allowZeroCrossing is false, any bound which 
    //crosses the zero mark after shifting (either from negative to positive, or positive to negative), will become zero.
    
    // Test shift with zero crossing not allowed
    @Test
    public void testShiftNoZeroCrossing() {
        Range baseRange = new Range(-5.0, 5.0);
        double delta = 2.0;
        boolean allowZeroCrossing = false;
        Range shiftedRange = Range.shift(baseRange, delta, allowZeroCrossing);
        assertEquals(new Range(-3.0, 7.0), shiftedRange);
    }

    
    // Test shift with zero crossing allowed
    @Test
    public void testShiftWithZeroCrossing() {
        Range baseRange = new Range(-5.0, 5.0);
        double delta = 2.0;
        boolean allowZeroCrossing = true;
        Range shiftedRange = Range.shift(baseRange, delta, allowZeroCrossing);
        assertEquals(new Range(-3.0, 7.0), shiftedRange);
    }
    
    
    
    
    
 // Test hashCode method
    @Test
    public void testHashCode() {
        Range range1 = new Range(0.0, 5.0);
        Range range2 = new Range(0.0, 5.0);

        // Since range1 and range2 have equal lower and upper bounds, they should have the same hash code
        assertEquals(range1.hashCode(), range2.hashCode());
    }
    
    
    
    
    //range combine - this should create a new range by combining two inputted ranges
    
    
    // testing combine when both of the ranges are postive intergers 
    @Test
    public void testCombineBothRangesPositive_TC6() {
        Range range1 = new Range(0.0, 5.0);
        Range range2 = new Range(2.0, 8.0);
        Range combinedRange = Range.combine(range1, range2);
        assertEquals(new Range(0.0, 8.0), combinedRange);
    }

    
    //testing combine when one of the ranges is null 
    @Test
    public void testCombineRangeOneNull_TC7() {
        Range range1 = null;
        Range range2 = new Range(2.0, 8.0);
        Range combinedRange = Range.combine(range1, range2);
        assertEquals(range2, combinedRange);
    }

    
    //tetsing the combine when they are both null ranges
    @Test
    public void testCombineBothNull_TC8() {
        Range range1 = null;
        Range range2 = null;
        Range combinedRange = Range.combine(range1, range2);
        assertNull(combinedRange);
    }
}

