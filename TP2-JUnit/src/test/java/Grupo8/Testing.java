package Grupo8;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Test;

public class Testing {

	@Test
	public void test1() {
		Assertions tester = new Assertions();
		int a = 0;
		int b = 0;
		try {
			tester.testear(a, b);
		}
		catch (Throwable e){
			assertEquals(e instanceof OkException,true);
		}
	}
	
	@Test
	public void test2() {
		Assertions tester = new Assertions();
		int a = 0;
		int b = 1;
		try {
			tester.testear(a, b);
		}
		catch (Throwable e){
			assertEquals(e instanceof OkException,false);
			assertEquals(e instanceof FailureException,true);
		}
	}
	
	@Test
	public void test3() {		
		TestCase test = new TestCase("test");
		TestResult result = new TestResult ();
		Assert.assertEquals(result.getListError().size(), 0);
		test.runTest(result);
		Assert.assertEquals(result.getListError().size(), 1);		
	}
	
	@Test
	public void test4() {
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
