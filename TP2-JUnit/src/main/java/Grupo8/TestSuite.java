package Grupo8;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

/*
 * Clase que contiene a todos los "tests individuales".
 * Puede contener otro TestSuite.
 */
public class TestSuite extends Test {	

	private Vector<Test> tests = new Vector<Test>();
	
	
	public TestSuite(String name) {
		testCaseName = name;
		testType = "TestSuite";
		hasToBeSkipped = false;
		fixtureMap = new HashMap<String, Object>();
		testConditions = new TestConditionsBuilder().buildTestConditions();
	}
	
	
	public TestSuite() {
		testCaseName = "UnnamedTestSuite";
		testType = "TestSuite";
		hasToBeSkipped = false;
		fixtureMap = new HashMap<String, Object>();
		testConditions = new TestConditionsBuilder().buildTestConditions();
	}
	
	
	// Familia de runTest:
	final public void runTagTest(TestResult result, Collection<String> tags) {
		if (!hasToBeSkipped) {
			setUp();
			TestResult newTestResult = result.addTestResult(testCaseName);
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
				Test test = elements.nextElement();
				test.runTagTest(newTestResult, tags);		
			}  
			tearDown();
		}
	}
	
	
	final public TestResult runTagTest(Collection<String> tags) {
		TestResult newTestResult = new TestResult(testCaseName);
		
		if (!hasToBeSkipped) {
			setUp();	
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
				Test test = elements.nextElement();
				test.runTagTest(newTestResult, tags);		
			}  
			tearDown();
		}
		
		return newTestResult;
	}
	
	
	final public void runTagTest(TestResult result, String tag) {
		if (!hasToBeSkipped) {
			setUp();
			TestResult newTestResult = result.addTestResult(testCaseName);
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
				Test test = elements.nextElement();
				test.runTagTest(newTestResult, tag);		
			}  
			tearDown();
		}
	}

	
	final public TestResult runTagTest(String tag) {
		TestResult newTestResult = new TestResult(testCaseName);
		
		if (!hasToBeSkipped) {
			setUp();	
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
				Test test = elements.nextElement();
				test.runTagTest(newTestResult, tag);		
			}  
			tearDown();
		}
		
		return newTestResult;
	}
	
	
	final public void runRegExTest(TestResult result, String regEx) {
		if (!hasToBeSkipped) {
			setUp();
			TestResult newTestResult = result.addTestResult(testCaseName);
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
				Test test = elements.nextElement();
				test.runRegExTest(newTestResult, regEx);		
			}  
			tearDown();
		}
	}

	
	final public TestResult runRegExTest(String regEx) {
		TestResult newTestResult = new TestResult(testCaseName);
		
		if (!hasToBeSkipped) {
			setUp();	
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
				Test test = elements.nextElement();
				test.runRegExTest(newTestResult, regEx);		
			}  
			tearDown();
		}
		
		return newTestResult;
	}
	
	
	final public void runTest(TestResult result) {
		if (!hasToBeSkipped) {
			setUp();
			TestResult newTestResult = result.addTestResult(testCaseName);		
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) {			
				Test test = elements.nextElement();
		    	test.setUpVariablesFromSuite(fixtureMap);
				test.runTest(newTestResult);		
			}
			tearDown();
		}
	}

	
	final public TestResult runTest() {
		TestResult newTestResult = new TestResult(testCaseName);	
		
		if (!hasToBeSkipped) {
			setUp();	
			for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) {			
				Test test = elements.nextElement();
		    	test.setUpVariablesFromSuite(fixtureMap);
				test.runTest(newTestResult);		
			}
			tearDown();
		}
		
		return newTestResult;
	}
	
	
	// addTest:
	public void addTest(Test test) {
		boolean found = false;
		Enumeration<Test> elements = tests.elements();
		while ((!found) && (elements.hasMoreElements())) {			
			Test chargedTest = elements.nextElement();
			if (chargedTest.repeatedTest(test)) {
				found = true;
			}							
		}
	    if (!found) {
	    	tests.addElement(test); 
	    }
	}
	
	
	// setUp y tearDown vacios por defecto
	public void setUp() {	
	}
	
	public void tearDown() {
	}

}
