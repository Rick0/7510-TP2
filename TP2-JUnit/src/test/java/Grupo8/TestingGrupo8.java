package Grupo8;

/*
 * TestingGrupo8: se testea el correcto funcionamiento de nuestro framework, usando el mismo framework.
 */
public class TestingGrupo8 {
	
	public static void main(String[] args) {
		TestResult result = new TestResult();
		TestSuite testsList = new TestSuite("TestingGrupo8");
		
		TestCase test1  = new TestCase("test1");
		TestCase test2  = new TestCase("test2");
		TestCase test3a = new TestCase("test3a");
		TestCase test3b = new TestCase("test3b");
		TestCase test4a = new TestCase("test4a");
		TestCase test4b = new TestCase("test4b");
		TestCase test4c = new TestCase("test4c");
		TestCase test5  = new TestCase("test5");
		TestCase test6  = new TestCase("test6");
		TestCase test7  = new TestCase("test7");
		TestCase test8  = new TestCase("test8");
		TestCase test9  = new TestCase("test9");
		TestCase test10  = new TestCase("test10");
		TestCase test11  = new TestCase("test11");
		
		fillTest1(test1);
		fillTest2(test2);
		fillTest3(test3a, test3b);
		fillTest4(test4a, test4b, test4c);
		fillTest5(test5);
		fillTest6(test6);
		fillTest7(test7);
		fillTest8(test8);
		fillTest9(test9);
		fillTest10(test10);
		fillTest11(test11);
		
		testForUnexistingName(testsList, result);
		testForExistingName(testsList, result);
		testThatThrowsAnException(testsList, result);
		testThatFails(testsList, result);
		testForNameUnicityOfTestCases(testsList, result);
		testForNameUnicityOfTestSuites(testsList, result);
		testForSetUpForATestCase(testsList, result);
		testForTwoTestAndEachSetUp(testsList, result);
		testForASuiteWithTwoSuitesWithATestEachOne(testsList, result);
		
		testsList.addTest(test1);
		testsList.addTest(test2);
		testsList.addTest(test3a);
		testsList.addTest(test3b);
		testsList.addTest(test4a);
		testsList.addTest(test4b);
		testsList.addTest(test4c);
		testsList.addTest(test5);
		testsList.addTest(test6);
		testsList.addTest(test7);
		testsList.addTest(test8);
		testsList.addTest(test9);
		testsList.addTest(test10);
		testsList.addTest(test11);
		
		testsList.runTest(result);
		result.showResults();
		result = testsList.runTest();
		result.showReport();
	}

	/* Tests TP2 */
	
	public static void fillTest1(TestCase test) {
		int a = 0;
		int b = 0;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
	}
	
	
	public static void fillTest2(TestCase test) {
		int a = 0;
		int b = 1;
		try {
			Assertions.assertEqual(a, b);
		}
		catch (Throwable e) {
			test.setAssertValue(e instanceof FailureException, true);
		}
	}
	
	
	public static void fillTest3(TestCase test3a, TestCase test3b) {		
		TestCase test = new TestCase("test");
		TestResult result = new TestResult ();
		test3a.setAssertValue(result.getListError().size(), 0);
		test.runTest(result);
		test3b.setAssertValue(result.getListError().size(), 1);		
	}
		
	
	public static void fillTest4(TestCase a, TestCase b, TestCase c) {
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
	}

	
	public static void fillTest5(TestCase test) {
		float a = 12.3f;
		float b = 12.3f;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
	}
	
	
	public static void fillTest6(TestCase test) {
		float a = 12.3f;
		float b = 12.28f;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(false);
		}
		catch (Throwable e) {			
			test.setAssertValue(e instanceof FailureException, true);
		}
	}
	
	
	public static void fillTest7(TestCase test) {
		boolean a = true;
		boolean b = true;
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
	}
	
	
	public static void fillTest8(TestCase test) {
		boolean a = true;
		boolean b = false;
		try {
			Assertions.assertEqual(a, b);			
		}
		catch (Throwable e) {			
			test.setAssertValue(e instanceof FailureException, true);
		}
	}
	
	
	public static void fillTest9(TestCase test) {
		char a = 'f';
		char b = 'f';
		try {
			Assertions.assertEqual(a, b);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
	}
	
	
	public static void fillTest10(TestCase test) {
		char a = 'f';
		char b = 'j';
		try {
			Assertions.assertEqual(a, b);
		}
		catch (Throwable e) {			
			test.setAssertValue(e instanceof FailureException, true);
		}
	}
	
	
	public static void fillTest11(TestCase test) {
		boolean a = true;
		try {
			Assertions.assertTrue(a);
			test.setAssertValue(true);
		}
		catch (Throwable e) {
			test.setAssertValue(false);
		}
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
		resultFather = suite.runRegEx(".*unexisting name");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		resultFather = suite.runRegEx(".*");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		result = suite.runRegEx(".*");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		result = suite.runRegEx(".*");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		result = suite.runRegEx(".*special");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		result = suite1.runRegEx(".*special");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		result = suite.runRegEx(".*special");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		result = suite.runRegEx(".*special");
		
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
		resultFather = testSuite.runRegEx(".*for");
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
		result = suite1.runRegEx(".*special");
		
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
		resultFather = testSuite.runRegEx(".*for");
	}
	
}
