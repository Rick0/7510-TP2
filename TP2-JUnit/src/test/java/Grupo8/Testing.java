package Grupo8;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class Testing {

	@Test
	public void testEqualInt() {
		int testValue1 = 0;
		int testValue2 = 0;
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testNotEqualInt() {
		int testValue1 = 0;
		int testValue2 = 1;
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof FailureException, true);
		}
	}
	
	
	@Test
	public void testEqualChar() {
		int testValue1 = 'a';
		int testValue2 = 'a';
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testNotEqualChar() {
		int testValue1 = 'b';
		int testValue2 = 'B';
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof FailureException, true);
		}
	}
	
	
	@Test
	public void testEqualFloat() {
		float testValue1 = 1.2f;
		float testValue2 = 1.2f;
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testNotEqualFloat() {
		float testValue1 = 1.2f;
		float testValue2 = 1.19f;
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof FailureException, true);
		}
	}
	
	
	@Test
	public void testEqualBooleanTrue() {
		boolean testValue1 = true;
		boolean testValue2 = true;
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testEqualBooleanFalse() {
		boolean testValue1 = false;
		boolean testValue2 = false;
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testNotEqualBoolean() {
		boolean testValue1 = true;
		boolean testValue2 = false;
		try {
			Assertions.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof FailureException, true);
		}
	}
	
	
	@Test
	public void testResultErrorListGrowth() {		
		TestCase test = new TestCase("test");
		TestResult result = new TestResult ();
		Assert.assertEquals(result.getListError().size(), 0);
		
		test.runTest(result);
		Assert.assertEquals(result.getListError().size(), 1);		
	}
	
	
	@Test
	public void testResultListsGrowth() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("test1");
		TestCase test2 = new TestCase("test2");
		TestCase test3 = new TestCase("test3");
		test1.setAssertValue(1, 1);
		test2.setAssertValue(1, 0);
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		
		suite.runTest(result);
		Assert.assertEquals(result.getListError().size(), 1);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 1);
	}

}
