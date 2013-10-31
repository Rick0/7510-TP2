package Grupo8.ExampleUserTest;

import Grupo8.TestCase;
import Grupo8.TestResult;
import Grupo8.TestSuite;


public class ExampleUserTests {

    public static void main (String[] args) {
    	
		TestSuite testsList = new TestSuite();
    
		TestCase test1 = new TestCase("UnoYUno");
		test1.setUp(1,1);		
		TestCase test2 = new TestCase("DosYUno");
		test2.setUp(2,1);
		TestCase test3 = new TestCase("AbYAb");
		test3.setUp("Ab", "Ab");
		TestCase test4 = new TestCase("AbYAB");
		test4.setUp("Ab", "AB");
		TestCase test5 = new TestCase("eeYaa");
		
		testsList.addTest(test1);
		testsList.addTest(test2);
		testsList.addTest(test3);
		testsList.addTest(test4);
		testsList.addTest(test5);
		
		TestResult results = new TestResult();
		testsList.runTest(results);
		results.showResults();
	}
	
}
