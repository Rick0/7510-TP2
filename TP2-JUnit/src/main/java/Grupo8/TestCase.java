package Grupo8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;;

/*
 * Clase que representa un "test individual".
 * Para poder ejecutar correctamente "runTest", primero hay que setear los valores a comparar,
 * con "setAssertValue".
 */
public class TestCase extends Test {
	
	private Object testValue1;
	private Object testValue2;
	private int valuesQuantity;
	private boolean valuesAreSeted;
	private Map<String,Object> fixtures;
	
	
	public TestCase (String name) {
		testCaseName = name;
		valuesQuantity = 0;
		valuesAreSeted = false;
		testType = "TestCase";
		fixtures = new HashMap<String, Object>();
	}
	
	public void addAFixtureItem(String name, Object value) {
		if (!fixtures.isEmpty()) {
			if (!fixtures.containsKey(name)) {
				fixtures.put(name, value);
			}
		}
		else {
			fixtures.put(name, value);
		}
	}
	
	public Object getAFixtureItem(String name) {
		if (fixtures.containsKey(name)) {
			return fixtures.get(name);
		}
		return null;
	}
	
	
	private void removeAllFixturesItems() {
		fixtures.clear();
	}	
	
	
	public void setAssertValue(Object aTestValue1, Object aTestValue2) {
		testValue1 = aTestValue1;
		testValue2 = aTestValue2;
		valuesQuantity = 2;
		valuesAreSeted = true;
	}
	
	
	public void setAssertValue(Object aTestValue) {
		testValue1 = aTestValue;
		valuesQuantity = 1;
		valuesAreSeted = true;
	}
	
	
	public void runRegEx (TestResult result, String regEx) {
	    Pattern regularExpression = Pattern.compile(regEx);
	    Matcher matcher = regularExpression.matcher(this.testCaseName);
	    if (matcher.find()) {
	    	this.runTest(result);
	    }
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
	
	}
	
	
	// testBody, setUp y tearDown vacios por defecto.
	public void testBody() {
	}
	
	public void setUp() {	
	}
	
	public void tearDown() {
	}
	
}
