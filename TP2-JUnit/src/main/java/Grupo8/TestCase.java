package Grupo8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Clase que representa un "test individual".
 * Para poder ejecutar correctamente "runTest",
 * primero hay que setear los valores a comparar, con "setAssertValue".
 */
public class TestCase extends Test {
	
	private Object testValue1;
	private Object testValue2;
	private int valuesQuantity;	
	private boolean valuesAreSeted;	
	

	public TestCase () {
		testCaseName = "Unnamed TestCase";
		valuesQuantity = 0;
		valuesAreSeted = false;
		testType = "TestCase";
		fixtures = new HashMap<String, Object>();				
	}
	
	
	public TestCase (String name) {
		testCaseName = name;
		valuesQuantity = 0;
		valuesAreSeted = false;
		testType = "TestCase";
		fixtures = new HashMap<String, Object>();				
	}
		
	public Object getAFixtureItem(String name) {
		if (fixtures.containsKey(name)) {
			return fixtures.get(name);
		}
		return null;
	}

	public Object getAFixtureItemFromSuite(String name) {
		if (fixtures.containsKey(name)) {
			return fixtures.get(name);
		}
		return null;
	}
	
	private void removeAllFixturesItems() {
		fixtures.clear();
	}	
	
	
	final public void setAssertValue(Object aTestValue1, Object aTestValue2) {
		testValue1 = aTestValue1;
		testValue2 = aTestValue2;
		valuesQuantity = 2;
		valuesAreSeted = true;
	}
	
	
	final public void setAssertValue(Object aTestValue) {
		testValue1 = aTestValue;
		valuesQuantity = 1;
		valuesAreSeted = true;
	}
	
	
	final public void runRegEx (TestResult result, String regEx) {
		setUp();
		testBody();
		
	    Pattern regularExpression = Pattern.compile(regEx);
	    Matcher matcher = regularExpression.matcher(this.testCaseName);
	    if (matcher.find()) {
	    	this.runTest(result);
	    }
	    
	    tearDown();
	}
	
	
	final public void runTest(TestResult result) {
		setUp();
		testBody();
		
		if (valuesAreSeted) {			
			try {
				if (valuesQuantity == 2) {
					Assertions.assertEqual(testValue1, testValue2);
					result.addPassed(this);
				}
				else if (valuesQuantity == 1) {
					Assertions.assertTrue((boolean)testValue1);
					result.addPassed(this);
				}
				else {
					result.addError(this);
				}
			}		
			catch(FailureException e) {
				result.addFailure(this);
			}		
			catch(Throwable e) {
				result.addError(this);
			}
		}
		else {
			result.addError(this);
		}
		
		tearDown();
	}
		
	// testBody, setUp y tearDown vacios por defecto.
	public void testBody() {
	}
	
	public void setUp() {	
	}
	
	public void tearDown() {
	}
	
	
}
