package Grupo8.ExampleUserTest;

import Grupo8.TestCase;
import Grupo8.TestResult;
import Grupo8.TestSuite;


public class ExampleUserTests {

    public static void main (String[] args) {
    	
		TestSuite testsList = new TestSuite();
    
		TestCase test1 = new TestCase("UnoYUno");
		test1.setAssertValue(1, 1);		
		TestCase test2 = new TestCase("DosYUno");
		test2.setAssertValue(2, 1);
		TestCase test3 = new TestCase("AbYAb");
		test3.setAssertValue("Ab", "AB");
		TestCase test4 = new TestCase("AbYAB");
		test4.setAssertValue("Ab", "AB");
		TestCase test5 = new TestCase("aYa");
		test5.setAssertValue('a', 'a');
		TestCase test6 = new TestCase("bYB");
		test6.setAssertValue('b', 'B');
		TestCase test7 = new TestCase("eeYaa");
		
		TestSuite padreSuite = new TestSuite("aYa");
		TestSuite unSuite = new TestSuite("aYa");
		
		TestCase test8 = new TestCase("aYae");
		test8.setAssertValue(1,1);
		TestCase test9 = new TestCase("aYae");
		test9.setAssertValue(1,1);
		unSuite.addTest(test9);		
		
//		MyTestCase1OK test10 = new MyTestCase1OK("3y3");

		testsList.addTest(test1);
		testsList.addTest(test2);
		testsList.addTest(test3);
		testsList.addTest(test4);
		testsList.addTest(test5);
		testsList.addTest(test6);
		testsList.addTest(test7);
		testsList.addTest(test8);
//		testsList.addTest(test10);
		
		padreSuite.addTest(unSuite);
		testsList.addTest(padreSuite);
		
		TestResult results = new TestResult();
		testsList.runTest(results);
		//testsList.runRegEx(results, "aYa");
		results.showResults();
		results = testsList.runRegEx("aYa");
		results.showReport();
	}
	
}
