package Grupo8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collection;
import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;

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
		testType = "TestCase";
		fixtureMap = new HashMap<String, Object>();
		hasToBeSkipped = false;
		testConditions = new TestConditionsBuilder().buildTestConditions();
		
		valuesQuantity = 0;
		valuesAreSeted = false;
	//	tagsSet = new HashSet<String>();
	}
	
	
	public TestCase (String name) {
		testCaseName = name;
		valuesQuantity = 0;
		valuesAreSeted = false;
		testType = "TestCase";
		fixtureMap = new HashMap<String, Object>();				
	}
	
	
	// Familia de setAssertValue:
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
	
	
	// Familia de runTest:
	final public void runTagTest(TestResult result, Collection<String> tags) {
		if (!hasToBeSkipped) {
	//		if (tagsSet.containsAll(tags)) {
				this.runTest(result);
	//		}
		}
	}
	
	
	final public void runTagTest(TestResult result, String tag) {
		if (!hasToBeSkipped) {
	//		if (tagsSet.contains(tag)) {
				this.runTest(result);
	//		}
		}
	}
	
	
	final public void runRegExTest(TestResult result, String regEx) {
		if (!hasToBeSkipped) {
		    Pattern regularExpression = Pattern.compile(regEx);
		    Matcher matcher = regularExpression.matcher(this.testCaseName);
		    
		    if (matcher.find()) {
		    	this.runTest(result);
		    }
		}
	}
	
	
	final public void runTest(TestResult result) {
		if (!hasToBeSkipped) {
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
	}
	
	
	// Operaciones con el HashSet "tags":
//	public void addTag(String newTag) {
//		if (!tagsSet.contains(newTag)) {
//			tagsSet.add(newTag);
//		}
//	}
//	
//	
//	public void removeTag(String oneTag) {
//		if (tagsSet.contains(oneTag)) {
//			tagsSet.remove(oneTag);
//		}
//	}
//	
//	
//	public void addAllTags(Collection<String> newTags) {
//		for (String oneTag : newTags) {
//			addTag(oneTag);
//	    }
//	}
//	
//	
//	public void removeAllTags(Collection<String> someTags) {
//		for (String oneTag : someTags) {
//			removeTag(oneTag);
//	    }
//	}
	
	
	// testBody, setUp y tearDown vacios por defecto, para que el cliente los redefina
	public void testBody() {
	}
	
	public void setUp() {	
	}
	
	public void tearDown() {
	}

}
