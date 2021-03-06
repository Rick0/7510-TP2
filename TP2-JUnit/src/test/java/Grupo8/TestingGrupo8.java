package Grupo8;

import java.util.Collection;
import java.util.LinkedList;

/*
 * TestingGrupo8: se testea el correcto funcionamiento de nuestro framework, usando el mismo framework.
 */
public class TestingGrupo8 {

	public static void main(String[] args) {
		TestResult result = new TestResult();
		result.setPrint(true);
		TestSuite testsList = new TestSuite("TestingGrupo8");
		testsList.setPrintTests(true);

		fillTest1(testsList);
		fillTest2(testsList);
		fillTest3(testsList);
		fillTest4(testsList);
		fillTest5(testsList);
		fillTest6(testsList);
		fillTest7(testsList);
		fillTest8(testsList);
		fillTest9(testsList);
		fillTest10(testsList);
		fillTest11(testsList);

		testForUnexistingName(testsList, result);		// 10
		testForExistingName(testsList, result);			//  9
		testThatThrowsAnException(testsList, result);	//  8
		testThatFails(testsList, result);				//  7
		testForNameUnicityOfTestCases(testsList, result);	//  1
		testForNameUnicityOfTestSuites(testsList, result);	//  2
		testForSetUpForATestCase(testsList, result);		//  3
		testForTwoTestAndEachSetUp(testsList, result);		//  4
		testForASuiteWithTwoSuitesWithATestEachOne(testsList, result);	//  5
		testTheAccessToTheFixtureOfATestCaseAndATestSuite(testsList, result);	//  6

		testForATag(testsList, result);		// 1
		testForSkippedTestWithTag(testsList, result);		// 3
		testForVariousTags(testsList, result);		// 4
		testForTagsAndRegex(testsList, result);		// 5
		testForVariousTagsAndNames(testsList, result);		// 6
		testForElapsedTime(testsList, result);		// 7

//		testsList.runTest(result);		
//		result.showResults();
		result = testsList.runTest();
		result.showReport();
	}


	/* Tests TP2 */

	public static void fillTest1(TestSuite testFather) {
		TestCase test  = new TestCase("test1");
		int a = 0;
		int b = 0;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
		testFather.addTest(test);
	}


	public static void fillTest2(TestSuite testFather) {
		TestCase test = new TestCase("test2");
		int a = 0;
		int b = 1;
		try {
			Assertions.assertEqual(a, b);
		}
		catch (Throwable e) {
			test.setAssertValue(e instanceof FailureException, true);
		}
		testFather.addTest(test);
	}


	public static void fillTest3(TestSuite testFather) {
		TestCase test3a = new TestCase("test3a");
		TestCase test3b = new TestCase("test3b");		
		TestCase test = new TestCase("test");
		TestResult result = new TestResult ();
		test3a.setAssertValue(result.getListError().size(), 0);
		test.runTest(result);
		test3b.setAssertValue(result.getListError().size(), 1);
		testFather.addTest(test3a);
		testFather.addTest(test3b);
	}


	public static void fillTest4(TestSuite testFather) {
		TestCase a = new TestCase("test4a");
		TestCase b = new TestCase("test4b");
		TestCase c = new TestCase("test4c");
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
		a.setAssertValue(result.getListError().size(), 1);
		b.setAssertValue(result.getListFailure().size(), 1);
		c.setAssertValue(result.getListPassed().size(), 1);
		testFather.addTest(a);
		testFather.addTest(b);
		testFather.addTest(c);
	}


	public static void fillTest5(TestSuite testFather) {
		TestCase test = new TestCase("test5");
		float a = 12.3f;
		float b = 12.3f;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
		testFather.addTest(test);
	}


	public static void fillTest6(TestSuite testFather) {
		TestCase test = new TestCase("test6");
		float a = 12.3f;
		float b = 12.28f;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(false);
		}
		catch (Throwable e) {			
			test.setAssertValue(e instanceof FailureException, true);
		}
		testFather.addTest(test);
	}


	public static void fillTest7(TestSuite testFather) {
		TestCase test = new TestCase("test7");
		boolean a = true;
		boolean b = true;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
		testFather.addTest(test);
	}


	public static void fillTest8(TestSuite testFather) {
		TestCase test = new TestCase("test8");
		boolean a = true;
		boolean b = false;
		try {
			Assertions.assertEqual(a, b);			
		}
		catch (Throwable e) {			
			test.setAssertValue(e instanceof FailureException, true);
		}
		testFather.addTest(test);
	}


	public static void fillTest9(TestSuite testFather) {
		TestCase test = new TestCase("test9");
		char a = 'f';
		char b = 'f';
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
		testFather.addTest(test);
	}


	public static void fillTest10(TestSuite testFather) {
		TestCase test = new TestCase("test10");
		char a = 'f';
		char b = 'j';
		try {
			Assertions.assertEqual(a, b);
		}
		catch (Throwable e) {			
			test.setAssertValue(e instanceof FailureException, true);
		}
		testFather.addTest(test);
	}


	public static void fillTest11(TestSuite testFather) {
		TestCase test = new TestCase("test11");
		boolean a = true;
		try {
			Assertions.assertTrue(a);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
		testFather.addTest(test);
	}


	/* Tests TP2.1 */

	public static void testForUnexistingName(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite("testForUnexistingName 1");
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
		suiteFather.addTest(suite);

		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*unexisting name").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		resultFather = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(resultFather.getListError().size(), 0);
		test6.setAssertValue(resultFather.getListFailure().size(), 0);
		test7.setAssertValue(resultFather.getListPassed().size(), 0);
		TestSuite testSuite = new TestSuite ("testForUnexistingName 2");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testForExistingName(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite("testForExistingName 1");
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
		suiteFather.addTest(suite);

		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		resultFather = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(resultFather.getListError().size(), 0);
		test6.setAssertValue(resultFather.getListFailure().size(), 0);
		test7.setAssertValue(resultFather.getListPassed().size(), 4);
		TestSuite testSuite = new TestSuite ("testForExistingName 2");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testThatThrowsAnException(TestSuite suiteFather, TestResult resultFather) {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");
		TestCase test4 = new TestCase("a test");
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		suite.addTest(test4);

		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(result.getListError().size(), 4);
		test6.setAssertValue(result.getListFailure().size(), 0);
		test7.setAssertValue(result.getListPassed().size(), 0);
		TestSuite testSuite = new TestSuite ("testThatThrowsAnException");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testThatFails(TestSuite suiteFather, TestResult resultFather) {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");
		TestCase test4 = new TestCase("a test");
		test1.setAssertValue(0, 1);
		test2.setAssertValue(0, 2);
		test3.setAssertValue(0, 3);
		test4.setAssertValue(0, 4);
		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		suite.addTest(test4);

		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(result.getListError().size(), 0);
		test6.setAssertValue(result.getListFailure().size(), 4);
		test7.setAssertValue(result.getListPassed().size(), 0);
		TestSuite testSuite = new TestSuite ("testThatFails");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testForNameUnicityOfTestCases(TestSuite suiteFather, TestResult resultFather) {
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

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(result.getListError().size(), 0);
		test6.setAssertValue(result.getListFailure().size(), 0);
		test7.setAssertValue(result.getListPassed().size(), 1);
		TestSuite testSuite = new TestSuite ("testForNameUnicityOfTestCases");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testForNameUnicityOfTestSuites(TestSuite suiteFather, TestResult resultFather) {
		TestResult result = new TestResult();
		TestSuite suite1 = new TestSuite("testForNameUnicityOfTestSuites 1");
		TestSuite suite2 = new TestSuite("testForNameUnicityOfTestSuites 1");
		TestSuite suite3 = new TestSuite("testForNameUnicityOfTestSuites 1");
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

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(result.getListError().size(), 0);
		test6.setAssertValue(result.getListFailure().size(), 0);
		test7.setAssertValue(result.getListPassed().size(), 1);
		TestSuite testSuite = new TestSuite ("testForNameUnicityOfTestSuites");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testForSetUpForATestCase(TestSuite suiteFather, TestResult resultFather) {
		TestResult result = new TestResult();
		TestSuite suite = new TestSuite("suite");
		TestCase test = new TestCase("my special test case");

		//This is the set up
		test.addAFixtureItem("numberA", 1);
		test.addAFixtureItem("numberB", 2);

		test.setAssertValue(test.getAFixtureItem("numberA"), test.getAFixtureItem("numberB"));		
		suite.addTest(test);

		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(result.getListError().size(), 0);
		test6.setAssertValue(result.getListFailure().size(), 1);
		test7.setAssertValue(result.getListPassed().size(), 0);
		TestSuite testSuite = new TestSuite ("testForSetUpForATestCase");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testForTwoTestAndEachSetUp(TestSuite suiteFather, TestResult resultFather) {
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

		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite.setTestConditions(oneTestCondition);
		result = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(result.getListError().size(), 0);
		test6.setAssertValue(result.getListFailure().size(), 0);
		test7.setAssertValue(result.getListPassed().size(), 2);
		TestSuite testSuite = new TestSuite ("testForTwoTestAndEachSetUp");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testForASuiteWithTwoSuitesWithATestEachOne(TestSuite suiteFather, TestResult resultFather) {
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

		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*special").buildTestConditions();
		suite1.setTestConditions(oneTestCondition);
		result = suite1.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(result.getListError().size(), 0);
		test6.setAssertValue(result.getListFailure().size(), 0);
		test7.setAssertValue(result.getListPassed().size(), 2);
		TestSuite testSuite = new TestSuite ("testForASuiteWithTwoSuitesWithATestEachOne");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	public static void testTheAccessToTheFixtureOfATestCaseAndATestSuite(TestSuite suiteFather, TestResult resultFather) {
		TestCaseC  caseC  = new TestCaseC ("TestCaseC");
		TestSuiteB suiteB = new TestSuiteB("testTheAccessToTheFixtureOfATestCaseAndATestSuite");
		TestSuiteA suiteA = new TestSuiteA("TestSuiteA");
		suiteA.addTest(caseC);
		suiteB.addTest(suiteA);

		suiteFather.addTest(suiteB);
		resultFather = suiteB.runTest();
	}


	/* Tests TP2.2 */

	//1
	public static void testForATag(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");

		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);
		test3.setAssertValue(0, 0);

		test1.addTag("SLOW");
		test3.addTag("SLOW");

		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);		

		Collection<String> someTags = new LinkedList<String>();
		someTags.add("SLOW");
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).buildTestConditions();
		suite.setTestConditions(oneTestCondition);

		suiteFather.addTest(suite);
		resultFather = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(resultFather.getListError().size(), 0);
		test6.setAssertValue(resultFather.getListFailure().size(), 0);
		test7.setAssertValue(resultFather.getListPassed().size(), 2);
		TestSuite testSuite = new TestSuite ("testForATag");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	//3
	public static void testForSkippedTestWithTag(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("my special test case");
		TestCase test2 = new TestCase("my special test case 1");
		TestCase test3 = new TestCase("my special");

		test1.setAssertValue(0, 0);
		test2.setAssertValue(0, 0);
		test3.setAssertValue(0, 0);

		test1.addTag("SLOW");
		test3.addTag("SLOW");

		test1.beSkipped();

		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);		

		Collection<String> someTags = new LinkedList<String>();
		someTags.add("SLOW");
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).buildTestConditions();
		suite.setTestConditions(oneTestCondition);

		suiteFather.addTest(suite);
		resultFather = suite.runTest();

		TestCase test4 = new TestCase ("for list error");
		TestCase test5 = new TestCase ("for list failure");
		TestCase test6 = new TestCase ("for list passed");
		test4.setAssertValue(resultFather.getListError().size(), 0);
		test5.setAssertValue(resultFather.getListFailure().size(), 0);
		test6.setAssertValue(resultFather.getListPassed().size(), 1);
		TestSuite testSuite = new TestSuite ("testForSkippedTestWithTag");
		testSuite.addTest(test4);
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	//4
	public static void testForVariousTags(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("T1");
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");
		TestCase test4 = new TestCase("T4");
		TestCase test5 = new TestCase("T5");
		TestCase test6 = new TestCase("T6");

		test1.addTag("SLOW");
		test1.addTag("DB");
		test2.addTag("SLOW");
		test3.addTag("DB");
		test4.addTag("FAST");
		test5.addTag("SMOKE");
		test6.addTag("-");
		test1.setTagsConditionAll(false);
		test2.setTagsConditionAll(false);
		test3.setTagsConditionAll(false);
		test4.setTagsConditionAll(false);
		test5.setTagsConditionAll(false);
		test6.setTagsConditionAll(false);

		test1.setAssertValue(0, 0);		
		test4.setAssertValue(0, 1);
		test5.setAssertValue(0, 0);

		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);		
		suite.addTest(test4);
		suite.addTest(test5);
		suite.addTest(test6);

		Collection<String> someTags = new LinkedList<String>();
		someTags.add("DB");
		someTags.add("FAST");
		someTags.add("SMOKE");
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).buildTestConditions();
		suite.setTestConditions(oneTestCondition);

		suiteFather.addTest(suite);
		resultFather = suite.runTest();

		TestCase test7 = new TestCase ("for list error");
		TestCase test8 = new TestCase ("for list failure");
		TestCase test9 = new TestCase ("for list passed");
		test7.setAssertValue(resultFather.getListError().size(), 1);
		test8.setAssertValue(resultFather.getListFailure().size(), 1);
		test9.setAssertValue(resultFather.getListPassed().size(), 2);
		TestSuite testSuite = new TestSuite ("testForVariousTags");
		testSuite.addTest(test7);
		testSuite.addTest(test8);
		testSuite.addTest(test9);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	//5
	public static void testForTagsAndRegex(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("T1");
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");
		TestCase test4 = new TestCase("no correr");

		test1.addTag("SLOW");
		test2.addTag("FAST");
		test3.addTag("SLOW");
		test4.addTag("SLOW");		

		test1.setAssertValue(0, 0);		
		test4.setAssertValue(0, 0);

		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		suite.addTest(test4);		

		Collection<String> someTags = new LinkedList<String>();
		someTags.add("SLOW");
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).testCaseRegEx("^[^no correr].*").buildTestConditions();
		suite.setTestConditions(oneTestCondition);

		suiteFather.addTest(suite);
		resultFather = suite.runTest();

		TestCase test5 = new TestCase ("for list error");
		TestCase test6 = new TestCase ("for list failure");
		TestCase test7 = new TestCase ("for list passed");
		test5.setAssertValue(resultFather.getListError().size(), 1);
		test6.setAssertValue(resultFather.getListFailure().size(), 0);
		test7.setAssertValue(resultFather.getListPassed().size(), 1);
		TestSuite testSuite = new TestSuite ("testForTagsAndRegex");
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	//6
	public static void testForVariousTagsAndNames(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite();
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
		test4.setAssertValue(0, 0);
		test5.setAssertValue(0, 1);

		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);
		suite.addTest(test4);
		suite.addTest(test5);	
		suite.addTest(test6);	

		Collection<String> someTags = new LinkedList<String>();
		someTags.add("DB");
		TestConditions oneTestCondition = new TestConditionsBuilder().tags(someTags).testCaseRegEx("mysql").buildTestConditions();
		suite.setTestConditions(oneTestCondition);

		suiteFather.addTest(suite);
		resultFather = suite.runTest();

		TestCase test7 = new TestCase ("for list error");
		TestCase test8 = new TestCase ("for list failure");
		TestCase test9 = new TestCase ("for list passed");
		test7.setAssertValue(resultFather.getListError().size(), 0);
		test8.setAssertValue(resultFather.getListFailure().size(), 1);
		test9.setAssertValue(resultFather.getListPassed().size(), 1);
		TestSuite testSuite = new TestSuite ("testForVariousTagsAndNames");
		testSuite.addTest(test7);
		testSuite.addTest(test8);
		testSuite.addTest(test9);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*for").buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}


	//7
	public static void testForElapsedTime(TestSuite suiteFather, TestResult resultFather) {
		TestSuite suite = new TestSuite();
		TestCase test1 = new TestCase("T1");
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");

		test1.setAssertValue(0, 1);
		test2.setAssertValue(false);
		test3.setAssertValue("daytime", "nighttime");	

		suite.addTest(test1);
		suite.addTest(test2);
		suite.addTest(test3);

		TestConditions oneTestCondition = new TestConditionsBuilder().buildTestConditions();
		suite.setTestConditions(oneTestCondition);

		suiteFather.addTest(suite);
		resultFather = suite.runTest();

		TestCase test4 = new TestCase("T1 time");
		TestCase test5 = new TestCase("T2 time");
		TestCase test6 = new TestCase("T3 time");
		TestCase test7 = new TestCase("Suite time");

		final long ESTIMATEDTIME = 60;	// in micro seconds

		test4.setAssertValue(test1.getElapsedTime() < ESTIMATEDTIME);
		test5.setAssertValue(test2.getElapsedTime() < ESTIMATEDTIME);
		test6.setAssertValue(test3.getElapsedTime() < ESTIMATEDTIME);
		test7.setAssertValue(suite.getElapsedTime() < ESTIMATEDTIME*4);

		TestSuite testSuite = new TestSuite ("testForElapsedTime");
		testSuite.addTest(test4);
		testSuite.addTest(test5);
		testSuite.addTest(test6);
		testSuite.addTest(test7);
		suiteFather.addTest(testSuite);

		oneTestCondition = new TestConditionsBuilder().buildTestConditions();
		testSuite.setTestConditions(oneTestCondition);
		resultFather = testSuite.runTest();
	}

}
