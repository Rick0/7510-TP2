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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
		}
	}
	
	
	@Test
	public void testEqualBooleanFalse() {
		boolean testValue1 = false;
		boolean testValue2 = false;
		try {
			Assertions.assertEqual(testValue1, testValue2);
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
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
	
	/*TP2.1*/
	
	@Test
	public void testForUnexistingNameRegEx() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");
		TestCase test4 = new TestCase("a test");
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);
		test3.setAssertValue(0, 0);
		test4.setAssertValue(0, 0);
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		suite.addTest(test4);
		
		result = suite.runRegEx(".*unexisting name");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 0);
	}
	
	@Test
	public void testForExistingName() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");
		TestCase test4 = new TestCase("a test");
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);
		test3.setAssertValue(0, 0);
		test4.setAssertValue(1, 0);
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		suite.addTest(test4);
		
		result = suite.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 3);
	}

	@Test
	public void testForTestWithErrorWhichThrowAnException() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");
		
		//We are not setting the asserts values
		/*test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);
		test3.setAssertValue(0, 0);*/
		
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
				
		result = suite.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 3);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 0);
	}
	
	@Test
	public void testForAFailedTest() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");
		
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);
		test3.setAssertValue(1, 0);
		
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
				
		result = suite.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 2);
	}
	
	@Test
	public void testTheAccessToTheFixtureOfATestCaseAndATestSuite() {
//		TestResult result = new TestResult();
//		TestSuite suiteA = new TestSuite("Suite A");
//		TestSuite suiteB = new TestSuite("Suite B");
//		TestCase test = new TestCase("my special test case");
//		
//		suiteB.addAFixtureItem("numberA", 1);		
//		suiteA.addAFixtureItem("numberB", 2);		
//		test.addAFixtureItem("numberC", 3);		
//		
//		suiteA.addTest(test);
//		suiteB.addTest(suiteA);			
//		
//		double suma1 = (double)test.getAFixtureItemFromSuite("NumberB");
		//double suma2 = 
		//double assertValueA = suma1 + suma2;
		//double assertValueB = (double) test.getAFixtureItem("numberC");
		
		//test.setAssertValue(assertValueA, assertValueB);		
				
		//result = suiteB.runRegEx(".*special");		
		//Assert.assertEquals(result.getListError().size(), 0);
		//Assert.assertEquals(result.getListFailure().size(), 0);
		//Assert.assertEquals(result.getListPassed().size(), 1);
		TestCaseC c = new TestCaseC("TestCaseC");
		//c.setUp();
		TestSuiteB b = new TestSuiteB("TestSuiteB");
		//b.setUp();
		TestSuiteA a = new TestSuiteA("TestSuiteA");
		//a.setUp();
		a.addTest(c);
		b.addTest(a);
		TestResult result = b.runTest();
		assertEquals(result.getListPassed().size(),1);		
	}
	
	@Test
	public void testForNameUnicityOfTestCases() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case");		
		
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);		
		
		suite.addTest(test1);
		suite.addTest(test2);		
				
		result = suite.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 1);
	}
	
	@Test
	public void testForNameUnicityOfTestSuites() {
		TestResult result = new TestResult();
		TestSuite suite1 = new TestSuite("suite");
		TestSuite suite2 = new TestSuite("suite");
		TestSuite suite3 = new TestSuite("suite");
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case");
		TestCase test3 = new TestCase("my special test case");
		
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);		
		test3.setAssertValue(0, 0);
		
		suite1.addTest(test1);
		suite1.addTest(suite2);
		suite1.addTest(suite3);		
				
		result = suite1.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 1);
	}
	
	@Test
	public void testForSetUpForATestCase() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite("suite");
		TestCase test = new TestCase("my special test case");
		
		//This is the set up
		test.addAFixtureItem("numberA", 1);
		test.addAFixtureItem("numberB", 2);
		
		test.setAssertValue(test.getAFixtureItem("numberA"), test.getAFixtureItem("numberB"));		
		
		suite.addTest(test);
				
		result = suite.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 0);
	}
	
	@Test
	public void testForTwoTestAndEachSetUp() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite("suite");
		TestCase test1 = new TestCase("my special test case 1");
		TestCase test2 = new TestCase("my special test case 2");
		
		//This is the set up
		test1.addAFixtureItem("numberA", 1);
		test2.addAFixtureItem("numberA", 2);
		
		test1.setAssertValue(test1.getAFixtureItem("numberA"), 1);
		test2.setAssertValue(test1.getAFixtureItem("numberA"), 1);
		
		suite.addTest(test1);
		suite.addTest(test2);
				
		result = suite.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 2);
	}
	
	@Test
	public void testForASuiteWithTwoSuitesWithATestEachOne() {
		TestResult result = new TestResult();
		TestSuite suite1 = new TestSuite("suite 1");
		TestSuite suite2 = new TestSuite("suite 2");
		TestSuite suite3 = new TestSuite("suite 3");
		TestCase test1 = new TestCase("my special test case 1");
		TestCase test2 = new TestCase("my special test case 2");
		
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);
		
		
		suite2.addTest(test1);
		suite3.addTest(test2);
		suite1.addTest(suite2);
		suite1.addTest(suite3);
				
		result = suite1.runRegEx(".*special");
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 2);
	}
	
}


