package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	private Values2D values2D;
	private Values values;

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

	// White Box Testing 1 - updated original test code from Lab 2. 
	@Test
	public void testValidDataAndColumnColumnTotal() {
	    DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
	    testValues.addValue(1, 0, 0);
	    testValues.addValue(4, 1, 0);
	    assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(testValues, 0), 
	    		0.0000001d);
	}

	// White Box Testing 2 - updated original test code from Lab 2. 
	@Test
	public void testNullDataColumnTotal() {
	    Values2D data = new DefaultKeyedValues2D(); 
	    try {
	        DataUtilities.calculateColumnTotal(data, 0);
	        fail("No exception thrown. The expected outcome was: a thrown exception of type IllegalArgumentException");
	    } catch (IllegalArgumentException e) {
	        assertNotNull("Expected IllegalArgumentException was thrown", e);
	    }
	}


	// White Box Testing 3 - Added a new test to check the behaviour when a null value is passed.  
	@Test
	public void testNullValueInColumnTotalWhiteBox() {
	    DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
	    testValues.addValue(1, 0, 0);
	    testValues.addValue(null, 1, 0); // Adding a null value to cover the null branch
	    assertEquals("Wrong sum returned. It should be 1.0", 1.0, DataUtilities.calculateColumnTotal(testValues, 0), 
	    		0.0000001d);
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

	// White Box Testing 1 - Add new test to check the behaviour when a null value is in the row. 
	
	@Test
	public void testNullValueInRowWhiteBox() {
	    DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
	    testObject.addValue(2, 0, 0);
	    testObject.addValue(null, 0, 1); 
	    testObject.addValue(6, 0, 2);
	    
	    assertEquals("Incorrect output", 
	            8, DataUtilities.calculateRowTotal(testObject, 0), 0.0000001d);
	}
	
	// White Box Testing 2 - Add new test to check the behaviour when a non-null value is in the row. 

	@Test
	public void testNonNullValuesInRowWhiteBox() {
	    DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
	    testObject.addValue(2, 0, 0);
	    testObject.addValue(4, 0, 1);
	    testObject.addValue(6, 0, 2);
	    
	    assertEquals("Incorrect output", 
	            12, DataUtilities.calculateRowTotal(testObject, 0), 0.0000001d);
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
	
	// White Box Testing 1 - Add new test to check behaviour when the data passed is null. 
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullDataWhiteBox() {
	    double[][] nullData = null;
	    DataUtilities.createNumberArray2D(nullData);
	}

	
	
    //3.1.1
    
    
    // Test case 1 for valid data matrix and valid column number
    @Test
    public void testValidDataAndValidColumnSucceeds_TC1() {
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
        testObject.addValue(2, 0, 0);
        testObject.addValue(8, 0, 1);
        testObject.addValue(9, 0, 2);
        testObject.addValue(4, 1, 0);
        testObject.addValue(8, 1, 1);
        testObject.addValue(3, 1, 2);
        
        assertEquals("Incorrect output", 6.0, DataUtilities.calculateColumnTotal(testObject, 0), 0.0000001d); 
    }
    
    // Test case 2 for valid data matrix and invalid column number
    // valid datas and 3 (# not minus 1)
    @Test
    public void testValidDataAndInvalidColumnCatchesException_TC2() {
        DefaultKeyedValues2D testObject = new DefaultKeyedValues2D();
        testObject.addValue(2, 0, 0);
        testObject.addValue(8, 0, 1);
        testObject.addValue(9, 0, 2);
        testObject.addValue(4, 1, 0);
        testObject.addValue(8, 1, 1);
        testObject.addValue(3, 1, 2);
        
        try {
            DataUtilities.calculateColumnTotal(testObject, 3);
            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    
    
    
    
    // Test case 3 for invalid data matrix and valid column number
    //null and 0
    @Test
    public void testInvalidNullDataAndValidColumnCatchesException_TC3() {
    	try {
            DataUtilities.calculateColumnTotal(null, 0);
            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    // Test case 4 for invalid data matrix and valid column number
    //[] and 1
    @Test
    public void testInvalidDataAndValidColumnReturns0_TC4() {
        Values2D emptyMatrix = new DefaultKeyedValues2D();
        assertEquals("Expected 0 for an invalid data matrix and column number", 0.0, DataUtilities.calculateColumnTotal(emptyMatrix, 1), 0.000001);
    
    }
    
    // Test case 5 for invalid data matrix and invalid column number
    //[] and -1
    public void testInvalidDataAndInvalidColumnCatchesException_TC5() {
    	Values2D emptyMatrix = null;
    	try {
            DataUtilities.calculateColumnTotal(emptyMatrix, -1);
            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
        }
    
    }
    
    
    
    
    //3.1.3 create number array
    
    @Test
    public void testValidDoubleArrayDataInputs_TC6() {
        double[] input = {1.0, 3.0, 6.0};
        Number[] expected = {1.0, 3.0, 6.0}; // Change to Double objects
        assertArrayEquals(expected, DataUtilities.createNumberArray(input));
    }
  
    
    @Test
    public void testInvalidDoubleArrayDataInputs_TC7() {
    	try {
            DataUtilities.createNumberArray(null);
            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    
    @Test
    public void testInvalidDoubleArrayDataInputs_TC8() {
    	double[] input = null;
    	try {
            DataUtilities.createNumberArray(input);
            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    
    
    //3.3.5
    
    
    @Test
    public void testCumulativePercentagesWithKey_TC18(){
    	DefaultKeyedValues dataValues = new DefaultKeyedValues();
		values = dataValues;
		dataValues.addValue("0", 5.0);
		dataValues.addValue("1", 9.0);
		dataValues.addValue("2", 2.0);
		
		KeyedValues result = DataUtilities.getCumulativePercentages(dataValues);

	    // Validate the calculated cumulative percentages
	    assertEquals("Cumulative percentage for key 0 should be 0.3125", 0.3125, result.getValue("0").doubleValue(), 0.000001d);
	    assertEquals("Cumulative percentage for key 1 should be 0.875", 0.875, result.getValue("1").doubleValue(), 0.000001d);
	    assertEquals("Cumulative percentage for key 2 should be 1.0", 1.0, result.getValue("2").doubleValue(), 0.000001d);

    }
    
    @Test
    public void testCumulativePercentagesNullIllegal_TC19() {
    	try {
            DataUtilities.getCumulativePercentages(null);
            fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    //White Box Testing 1 - Add new test case to check behaviour when provided with a null object. 
    
    @Test
    public void testCumulativePercentagesWithNullValuesWhiteBox() {
        DefaultKeyedValues dataValues = new DefaultKeyedValues();
        dataValues.addValue("0", null);
        dataValues.addValue("1", null);
        dataValues.addValue("2", null);

        KeyedValues result = DataUtilities.getCumulativePercentages(dataValues);

        assertEquals("Cumulative percentage for key 0 should be NaN", Double.NaN, result.getValue("0").doubleValue(), 0.000001d);
        assertEquals("Cumulative percentage for key 1 should be NaN", Double.NaN, result.getValue("1").doubleValue(), 0.000001d);
        assertEquals("Cumulative percentage for key 2 should be NaN", Double.NaN, result.getValue("2").doubleValue(), 0.000001d);
    }

    //White Box Testing 2 - Add new test case to check behaviour when provided with a non-null object. 

    @Test
    public void testCumulativePercentagesWithNonNullValueWhiteBox() {
        DefaultKeyedValues dataValues = new DefaultKeyedValues();
        dataValues.addValue("0", 5.0); 
        dataValues.addValue("1", null);
        dataValues.addValue("2", null);

        KeyedValues result = DataUtilities.getCumulativePercentages(dataValues);

        assertEquals("Cumulative percentage for key 0 should be 1.0", 1.0, result.getValue("0").doubleValue(), 0.000001d);

        assertEquals("Cumulative percentage for key 1 should be NaN", Double.NaN, result.getValue("1").doubleValue(), 0.000001d);
        assertEquals("Cumulative percentage for key 2 should be NaN", Double.NaN, result.getValue("2").doubleValue(), 0.000001d);
    }


    
}


