package Grupo8;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/*
 * Clase que contiene a todos los "tests individuales".
 * Puede contener otro TestSuite.
 */
public class TestSuite extends Test {	

	private Vector<Test> tests = new Vector<Test>();
	boolean print;


	
	public TestSuite() {
		testName = "UnnamedTestSuite";
		testSuiteInitialValues();
		print = false;
	}
		
		
		
	public TestSuite(String name) {
		testName = name;		
		testSuiteInitialValues();
		print = false;
		
		
	}
	
	
	public void setPrintTests(boolean mustPrint){
		print = mustPrint;
	}
	
	
	private void testSuiteInitialValues() {
		testType = "TestSuite";
		hasToBeSkipped = false;
		fixtureMap = new HashMap<String, Object>();
		testConditions = new TestConditionsBuilder().buildTestConditions();
		testConditionsCaseAND = true;
		elapsedTime = "notRun";
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
		newTestResult.setPrint(print);
		if (!hasToBeSkipped) {			
			if (testConditionsOK()) {				
				internalRunTest(newTestResult);				
				newTestResult.consoleResume();
			}
		}
		
		return newTestResult;
	}
	
	
	private void internalRunTest(TestResult newTestResult) {
		setUp();		
		newTestResult.printResultName();
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
		if (testConditionsCaseAND) {
			return testConditionRegEx();
		}
		else {
			return true;
		}
	}


	private boolean testConditionRegEx() {
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
