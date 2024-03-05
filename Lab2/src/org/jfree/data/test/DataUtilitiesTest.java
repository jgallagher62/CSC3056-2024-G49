package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	private Values2D values2D;

	@Before
	public void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
	}

	@Test
	public void testValidDataAndColumnColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0",
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testNullDataColumnTotal(){
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type IllegalArgumentException");
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	// 3.1.2 calculateRowTotal (Values2D data, int row) //

	// Test Case 1 //
	@Test
	public void testValidMatrixValidRow() {
	    DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
	    testObject.addValue(2, 0, 0);
	    testObject.addValue(4, 0, 1);
	    testObject.addValue(6, 0, 2);
	    testObject.addValue(5, 1, 0);
	    testObject.addValue(2, 1, 1);
	    testObject.addValue(7, 1, 2);
	    
	    assertEquals("Incorrect output", 
	            12, DataUtilities.calculateRowTotal(testObject, 0), 0.0000001d);
	}

	// Test Case 2 //
	@Test
	public void testValidMatrixInvalidRow() {
	    try {
	        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
	        testObject.addValue(2, 0, 0);
	        testObject.addValue(4, 0, 1);
	        testObject.addValue(6, 0, 2);
	        testObject.addValue(5, 1, 0);
	        testObject.addValue(2, 1, 1);
	        testObject.addValue(7, 1, 2);
	        
	        DataUtilities.calculateRowTotal(testObject, -1);
	        fail("Expected Out Of Bounds Exception");
	    } catch (IndexOutOfBoundsException e) {
	    }
	}

	// Test Case 3 //
	@Test
	public void testInvalidMatrixValidRow() {
	    try {
	        DataUtilities.calculateRowTotal(null, 1);
	    } catch (NullPointerException e) {
	        fail("The Data object is null");
	    }
	    fail("Expected Illegal Argument Exception");
	}

	// Test Case 4 //
	@Test
	public void testInvalidMatrixInvalidRow() {

	    DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
	    assertEquals("Incorrect output", 0, DataUtilities.calculateRowTotal(testObject, -3), 0.0000001d);
	}

	// 3.1.4 createNumberArray2D(double[][] data) //

	// Test Case 1 //
	@Test
	public void testValidData() {
	    double[][] validData = {{2.0, 4.0}, {5.0, 7.0}};
	    Number[][] expectedData = {{2.0, 4.0}, {5.0, 7.0}};
	    Number[][] result = DataUtilities.createNumberArray2D(validData);
	    assertEquals("Valid data input is", expectedData, result);
	}

	// Test Case 2 //
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidData() {
	    double[][] invalidData = {{Double.NaN, Double.POSITIVE_INFINITY}, {1.0, -1.0}};
	    DataUtilities.createNumberArray2D(invalidData);
	}

	// Test Case 3 //
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyData() {
	    double[][] emptyData = {};
	    DataUtilities.createNumberArray2D(emptyData);
	}


}
