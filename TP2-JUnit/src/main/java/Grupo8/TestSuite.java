package Grupo8;

import java.util.Enumeration;
import java.util.Vector;

public class TestSuite extends Test {

	private Vector<TestCase> tests = new Vector<TestCase>();


	public void runTest(TestResult result) {
		for (Enumeration<TestCase> elements = tests.elements(); elements.hasMoreElements(); ) { 
			TestCase test = (TestCase)elements.nextElement();
			test.runTest(result);		
		}  
	}
	
	public void addTest(TestCase test) { 
	    tests.addElement(test); 
	}

}
