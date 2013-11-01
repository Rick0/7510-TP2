package Grupo8;

import static org.junit.Assert.assertTrue;

public class TestingGrupo8 {

	public static void main(String[] args) {
		TestResult result = new TestResult();
		TestSuite testsList = new TestSuite();
		
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
		fillTest2(test5);
		fillTest2(test6);
		fillTest2(test7);
		fillTest2(test8);
		fillTest2(test9);
		fillTest2(test10);
		fillTest2(test11);
		
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
	}

	
	public static void fillTest1(TestCase test) {
		int a = 0;
		int b = 0;
		try {
			Assertions.assertEqual(a, b);
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
		}
	}
	
	
	public static void fillTest6(TestCase test) {
		float a = 12.3f;
		float b = 12.28f;
		try {
			Assertions.assertEqual(a, b);
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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
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
			assertTrue(true);
		}
		catch (Throwable e) {
			assertTrue(false);
		}
	}

}
