package Grupo8;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/*
 * Testing: se testea el correcto funcionamiento de nuestro framework, usando el JUnit.
 */
public class Testing {

	/* Tests TP2 */
	
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
	
	
	/* Tests TP2.1 */

	@Test //1
	public void testForNameUnicityOfTestCases() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case");		
		
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);		
		
		suite.addTest(test1);
		suite.addTest(test2);		
		
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();
		
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 1);
	}
	
	
	@Test //2
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
				
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite1.setTestConditions(oneTestCondition);
		result = suite1.runTest();
		
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 1);
	}
	
	
	@Test //3
	public void testForSetUpForATestCase() {
		TestResult result = new TestResult();
		TestCaseSetUpTest test = new TestCaseSetUpTest("TestCaseSetUpTest");
		test.runTest(result);
		assertEquals(1,result.getListPassed().size());
	}
	
	
	@Test //4
	public void testForTwoTestAndEachSetUp() {
		TestSuiteTest4 suite = new TestSuiteTest4("TestSuiteTest4");
		TestCaseTest4A caseA = new TestCaseTest4A("TestCaseTest4A");
		TestCaseTest4B caseB = new TestCaseTest4B("TestCaseTest4B");
		suite.addTest(caseA);
		suite.addTest(caseB);
		TestResult result = suite.runTest();
		assertEquals(2,result.getListPassed().size());
	}
	
	
	@Test //5
	public void testForASuiteWithTwoSuitesWithATestEachOne() {
		TestSuiteTest5 test5 = new TestSuiteTest5("TestSuiteTest5");
		TestSuiteTest5A test5A = new TestSuiteTest5A("TestSuiteTest5A");
		TestSuiteTest5B test5B = new TestSuiteTest5B("TestSuiteTest5B");
		TestCaseTest5A case5A = new TestCaseTest5A("TestCaseTest5A");
		TestCaseTest5B case5B = new TestCaseTest5B("TestCaseTest5B");
		test5A.addTest(case5A);
		test5B.addTest(case5B);
		test5.addTest(test5A);
		test5.addTest(test5B);
		TestResult result = test5.runTest();
		assertEquals(2,result.getListPassed().size());
	}
	
	
	@Test //6
	public void testTheAccessToTheFixtureOfATestCaseAndATestSuite(){
		TestCaseC c = new TestCaseC("TestCaseC");
		TestSuiteB b = new TestSuiteB("TestSuiteB");
		TestSuiteA a = new TestSuiteA("TestSuiteA");
		a.addTest(c);
		b.addTest(a);
		TestResult result = b.runTest();
		assertEquals(result.getListPassed().size(),1);	
	}
	
	
	@Test //7
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
				
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();
		
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 2);
	}
	
	
	@Test //8
	public void testForTestWithErrorWhichThrowAnException() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");
		
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
				
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();
		
		Assert.assertEquals(result.getListError().size(), 3);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 0);
	}
	
	
	@Test //9
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
		
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();
		
		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 3);
	}
	
	
	@Test //10
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
		
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*unexisting name").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();

		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 0);
	}
	
	/*Tercera entrega*/
	
	@Test //1
	public void testForATag() {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
		test1.addTag("SLOW");
		test3.addTag("SLOW");
		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 1);				
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);		
		
		Collection<String> newTags = new LinkedList<String>();
		newTags.add("SLOW");		
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(newTags).buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();

		Assert.assertEquals(result.getListError().size(), 1);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 1);
	}	
		
	@Test //3
	public void testForSkippedTestWithTag() {
		TestResult result = new TestResult();
		TestSuite suite1 = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
		test1.addTag("SLOW");
		test1.beSkipped();
		test3.addTag("SLOW");
				
		test1.setAssertValue(0, 0); 
		test2.setAssertValue(0, 0); 
		test3.setAssertValue(0, 1);
		suite1.addTest(test1);
		suite1.addTest(test2);
		suite1.addTest(test3);		
		
		Collection<String> someTags = new LinkedList<String>();
		someTags.add("SLOW");
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).buildTestConditions();
		suite1.setTestConditions(oneTestCondition);				
				
		result = suite1.runTest();

		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 0);
	}
	
	@Test //4
	public void testForVariousTags() {
		TestResult result = new TestResult();
		TestSuite suite1 = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");		
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
		TestCase test4 = new TestCase("T4");
		TestCase test5 = new TestCase("T5");
		TestCase test6 = new TestCase("T6");		
		Collection<String> tags = new LinkedList<String>();
		tags.add("DB");
		tags.add("SLOW");
		test1.addAllTags(tags);
		test2.addTag("SLOW");
		test3.addTag("DB");
		test4.addTag("FAST");
		test5.addTag("SMOKE");
		test6.addTag("-");
		
		test1.setAssertValue(0, 0); 
		test3.setAssertValue(0, 0); 
		test4.setAssertValue(0, 1);								
		suite1.addTest(test1);
		suite1.addTest(test2);
		suite1.addTest(test3);		
		suite1.addTest(test4);
		suite1.addTest(test5);
		suite1.addTest(test6);
				
		Collection<String> someTags = new LinkedList<String>();
		someTags.add("DB");
		someTags.add("FAST");
		someTags.add("SMOKE");
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).buildTestConditions();
		suite1.setTestConditions(oneTestCondition);		
					
		result = suite1.runTest();

		Assert.assertEquals(result.getListError().size(), 1);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 2);
	}
	
	@Test //5
	public void testForTagsAndRegex() {
		TestResult result = new TestResult();
		TestSuite suite1 = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");		
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
		TestCase test4 = new TestCase("no correr");
		test1.addTag("SLOW");
		test2.addTag("FAST");
		test3.addTag("SLOW");
		test4.addTag("SLOW");		
		
		test1.setAssertValue(0, 0); 
		test2.setAssertValue(0, 0);
		test3.setAssertValue(0, 0); 
		test4.setAssertValue(0, 1);								
		suite1.addTest(test1);
		suite1.addTest(test2);
		suite1.addTest(test3);		
		suite1.addTest(test4);
		
		Collection<String> someTags = new LinkedList<String>();
		someTags.add("SLOW");		
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).testCaseRegEx("^[^correr]*").buildTestConditions();
		suite1.setTestConditions(oneTestCondition);		
					
		result = suite1.runTest();

		Assert.assertEquals(result.getListError().size(), 0);
		Assert.assertEquals(result.getListFailure().size(), 0);
		Assert.assertEquals(result.getListPassed().size(), 2);
	}
	
	@Test //6
	public void testForVariousTagsAndNames() {
		TestResult result = new TestResult();
		TestSuite suite1 = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");		
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
		TestCase test4 = new TestCase("...mysql...1");
		TestCase test5 = new TestCase("...mysql...2");
		TestCase test6 = new TestCase("...mysql...3");		
		test1.addTag("DB");
		test2.addTag("DB");
		test3.addTag("SLOW");
		test4.addTag("DB");
		test5.addTag("DB");
		test6.addTag("-");
		
		test1.setAssertValue(0, 0); 
		test3.setAssertValue(0, 0); 
		test4.setAssertValue(0, 1);
		
		suite1.addTest(test1);
		suite1.addTest(test2);
		suite1.addTest(test3);		
		suite1.addTest(test4);
		suite1.addTest(test5);
		suite1.addTest(test6);
				
		Collection<String> someTags = new LinkedList<String>();
		someTags.add("DB");		
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).testCaseRegEx(".*mysql*.").buildTestConditions();
		suite1.setTestConditions(oneTestCondition);		
					
		result = suite1.runTest();

		Assert.assertEquals(result.getListError().size(), 1);
		Assert.assertEquals(result.getListFailure().size(), 1);
		Assert.assertEquals(result.getListPassed().size(), 0);
	}	
	
	@Test //7
	public void testForElapsedTime() {		
		TestSuite suite1 = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");		
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
				
		test1.setAssertValue(0, 0); 
		test2.setAssertValue(0, 1);		
		
		suite1.addTest(test1);
		suite1.addTest(test2);
		suite1.addTest(test3);		
						
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*T*.").testCaseRegEx(".*mysql*.").buildTestConditions();
		suite1.setTestConditions(oneTestCondition);		
					
		suite1.runTest();

		Assert.assertNotNull(test1.getElapsedTime());
		Assert.assertNotNull(test2.getElapsedTime());
		Assert.assertNotNull(test3.getElapsedTime());		
	}	

}
