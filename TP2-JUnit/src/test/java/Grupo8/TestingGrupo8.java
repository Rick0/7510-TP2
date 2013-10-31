package Grupo8;

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
		
		fillTest1(test1);
		fillTest2(test2);
		fillTest3(test3a, test3b);
		fillTest4(test4a, test4b, test4c);
		
		testsList.addTest(test1);
		testsList.addTest(test2);
		testsList.addTest(test3a);
		testsList.addTest(test3b);
		testsList.addTest(test4a);
		testsList.addTest(test4b);
		testsList.addTest(test4c);
		
		testsList.runTest(result);
		result.showResults();
	}

	
	public static void fillTest1(TestCase test) {
		Assertions tester = new Assertions();
		int a = 0;
		int b = 0;
		try {
			tester.assertEqual(a, b);
		}
		catch (Throwable e) {			
			test.setUp(e instanceof OkException, true);
		}
	}
	
	
	public static void fillTest2(TestCase test) {
		Assertions tester = new Assertions();
		int a = 0;
		int b = 1;
		try {
			tester.assertEqual(a, b);
		}
		catch (Throwable e) {
			test.setUp(e instanceof FailureException, true);
		}
	}
	
	
	public static void fillTest3(TestCase test3a, TestCase test3b) {		
		TestCase test = new TestCase("test");
		TestResult result = new TestResult ();
		test3a.setUp(result.getListError().size(), 0);
		test.runTest(result);
		test3b.setUp(result.getListError().size(), 1);		
	}
		
	
	public static void fillTest4(TestCase a, TestCase b, TestCase c) {
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
		a.setUp(result.getListError().size(), 1);
		b.setUp(result.getListFailure().size(), 1);
		c.setUp(result.getListPassed().size(), 1);		
	}

}
