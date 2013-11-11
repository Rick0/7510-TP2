package Grupo8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
	private Set<String> tagsSet;
	private boolean tagsConditionAll;	// true = all	false = any
	

	public TestCase() {
		testName = "Unnamed TestCase";		
		testCaseInitialValues();
	}

	
	public TestCase(String name) {
		testName = name;
		testCaseInitialValues();	
	}
	
	
	private void testCaseInitialValues() {
		testType = "TestCase";
		fixtureMap = new HashMap<String, Object>();
		hasToBeSkipped = false;
		testConditions = new TestConditionsBuilder().buildTestConditions();
		testConditionsCaseAND = true;
		elapsedTime = "notRun";
		
		valuesQuantity = 0;
		valuesAreSeted = false;
		tagsSet = new HashSet<String>();
		tagsConditionAll = true;
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
	
	
	// runTest:
	final public void runTest(TestResult result) {
		if (!hasToBeSkipped) {
			if (testConditionsOK()) {
				internalRunTest(result);
			}
		}
	}


	private void internalRunTest(TestResult result) {
		Timer timer = new Timer();
		timer.startCounting();
		
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
		
		elapsedTime = timer.getElapsedTimeInNs();
	}
	
	
	// Checkeador de testCondicions para 'testCase':
	private boolean testConditionsOK() {
		if (testConditionsCaseAND) {
			return (testConditionTags()  &&  testConditionRegEx());
		}
		else {
			return (testConditionTags()  ||  testConditionRegEx());
		}
	}


	private boolean testConditionTags() {
		if (!testConditions.tags.isEmpty()) {
			if (tagsConditionAll) {
				if ( !tagsSet.containsAll(testConditions.tags) ) {
					return false;
				}
			}
			else {
				for (String oneTag : testConditions.tags) {
					if ( tagsSet.contains(oneTag) ) {
						return true;
					}
			    }
				return false;
			}
		}
		
		return true;
	}


	private boolean testConditionRegEx() {
		if (testConditions.testCaseRegEx != "") {
			Pattern regularExpression = Pattern.compile(testConditions.testCaseRegEx);
		    Matcher matcher = regularExpression.matcher(testName);

		    if ( !matcher.find() ) {
		    	return false;
		    }
		}
		
		return true;
	}
	
	
	// Operaciones con el HashSet "tags":
	public void addTag(String newTag) {
		if (!tagsSet.contains(newTag)) {
			tagsSet.add(newTag);
		}
	}
	
	
	public void removeTag(String oneTag) {
		if (tagsSet.contains(oneTag)) {
			tagsSet.remove(oneTag);
		}
	}
	
	
	public void addAllTags(Collection<String> newTags) {
		for (String oneTag : newTags) {
			addTag(oneTag);
	    }
	}
	
	
	public void removeAllTags(Collection<String> someTags) {
		for (String oneTag : someTags) {
			removeTag(oneTag);
	    }
	}
	
	
	// testBody, setUp y tearDown vacios por defecto, para que el cliente los redefina
	public void testBody() {
	}
	
	public void setUp() {	
	}
	
	public void tearDown() {
	}

}
