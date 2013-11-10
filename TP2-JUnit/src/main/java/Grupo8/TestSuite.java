package Grupo8;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Clase que contiene a todos los "tests individuales".
 * Puede contener otro TestSuite.
 */
public class TestSuite extends Test {	

	private Vector<Test> tests = new Vector<Test>();
	
	
	public TestSuite() {
		testName = "UnnamedTestSuite";
		testSuiteInitialValues();
	}
	
	
	public TestSuite(String name) {
		testName = name;
		testSuiteInitialValues();
	}


	private void testSuiteInitialValues() {
		testType = "TestSuite";
		hasToBeSkipped = false;
		fixtureMap = new HashMap<String, Object>();
		testConditions = new TestConditionsBuilder().buildTestConditions();
	}
	

	// Familia de runTest:	
	final public void runTest(TestResult result) {
		TestResult newTestResult = result.addTestResult(testName);		
		
		if (!hasToBeSkipped) {
			if (testConditionsOK()) {
				internalRunTest(newTestResult);
			}
		}
	}

	
	final public TestResult runTest() {
		TestResult newTestResult = new TestResult(testName);	
		
		if (!hasToBeSkipped) {
			if (testConditionsOK()) {
				internalRunTest(newTestResult);
			}
		}
		
		return newTestResult;
	}
	
	
	private void internalRunTest(TestResult newTestResult) {
		setUp();
		for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) {			
			Test test = elements.nextElement();
			test.setUpVariablesFromSuite(fixtureMap);	// se propagan las variables del fixture
			test.setTestConditions(testConditions);		// se propagan las condiciones de test
			test.runTest(newTestResult);		
		}
		tearDown();
	}
	
	
	// Checkeador de testCondicions para 'testSuite':
	private boolean testConditionsOK() {
		if (testConditions.testSuiteRegEx != "") {
			Pattern regularExpression = Pattern.compile(testConditions.testSuiteRegEx);
		    Matcher matcher = regularExpression.matcher(testName);

		    if ( !matcher.find() ) {
		    	return false;
		    }
		}
		
		return true;
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
