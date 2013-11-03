package Grupo8;

import java.util.Enumeration;
import java.util.Vector;

/*
 * Clase que contiene a todos los "tests individuales".
 */
public class TestSuite extends Test {

	private Vector<Test> tests = new Vector<Test>();
	
	
	public TestSuite(String name){
		testCaseName = name;
		testType = "TestSuite";
	}
	
	
	public TestSuite(){
		testCaseName = "Unnamed TestSuite";
		testType = "TestSuite";
	}

	
	public void runRegEx(TestResult result, String regEx) {
		setUp();
		TestResult newTestResult = result.addTestResult(testCaseName);
		for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
			Test test = elements.nextElement();
			test.runRegEx(newTestResult, regEx);		
		}  
		tearDown();
	}

	public TestResult runRegEx(String regEx) {
		setUp();
		TestResult newTestResult = new TestResult(testCaseName);
		for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
			Test test = elements.nextElement();
			test.runRegEx(newTestResult, regEx);		
		}  
		tearDown();
		return newTestResult;
	}
	
	
	
	public void runTest(TestResult result) {
		setUp();
		TestResult newTestResult = result.addTestResult(testCaseName);
		for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) {			
			Test test = elements.nextElement();
			test.runTest(newTestResult);		
		}
		tearDown();
	}

	public TestResult runTest() {
		setUp();
		TestResult newTestResult = new TestResult(testCaseName);
		for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) {			
			Test test = elements.nextElement();
			test.runTest(newTestResult);		
		}
		
		tearDown();
		return newTestResult;
	}
	
	
	public void addTest(Test test) {
		boolean found = false;
		Enumeration<Test> elements = tests.elements();
		while ((!found) && (elements.hasMoreElements())) {			
			Test chargedTest = elements.nextElement();
			if (chargedTest.repeatedTest(test)){
				found = true;
			}							
		}
	    if (!found) tests.addElement(test); 
	}
	
	
	// setUp y tearDown vacios por defecto.
	public void testBody() {
	}
	
	public void setUp() {	
	}
	
	public void tearDown() {
	}

}
