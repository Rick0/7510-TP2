package Grupo8;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class Testing {

	@Test
	public void testEqualInt() {
		Assertions tester = new Assertions();
		int testValue1 = 0;
		int testValue2 = 0;
		try {
			tester.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testNotEqualInt() {
		Assertions tester = new Assertions();
		int testValue1 = 0;
		int testValue2 = 1;
		try {
			tester.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof FailureException, true);
		}
	}
	
	
	@Test
	public void testEqualChar() {
		Assertions tester = new Assertions();
		int testValue1 = 'a';
		int testValue2 = 'a';
		try {
			tester.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testNotEqualChar() {
		Assertions tester = new Assertions();
		int testValue1 = 'b';
		int testValue2 = 'B';
		try {
			tester.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof FailureException, true);
		}
	}
	
	
	@Test
	public void testEqualFloat() {
		Assertions tester = new Assertions();
		float testValue1 = 1.2f;
		float testValue2 = 1.2f;
		try {
			tester.assertEqual(testValue1, testValue2);
		}
		catch (Throwable e) {
			assertEquals(e instanceof OkException, true);
		}
	}
	
	
	@Test
	public void testNotEqualFloat() {
		Assertions tester = new Assertions();
		float testValue1 = 1.2f;
		float testValue2 = 1.19f;
		try {
			tester.assertEqual(testValue1, testValue2);
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
		test1.setUp(1, 1);
		test2.setUp(1, 0);
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		
		suite.runTest(result);
		Assert.assertEquals(result.getListError().size(), 1);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 1);
	}

}
