package Grupo8;

import java.util.Iterator;
import java.util.Map;

/*
 * Clase abstracta, y padre de TestCase y TestSuite.
 * Se usa para poder aplicar el patron Composite.
 */
public abstract class Test {
	
	protected String testCaseName;
	protected String testType;
	protected boolean hasToBeSkipped;
	protected Map<String,Object> fixtureMap;
	

	public abstract void runTest(TestResult result);
	
	
	public abstract void runRegExTest(TestResult result, String regEx);
	
	
	public abstract void runTagTest(TestResult result, String regEx);
	
	
	public abstract void setUp();

	
	public abstract void tearDown();
		
	
	public String getName() {
		return testCaseName;
	}

	
	public void setName(String aName) {
		testCaseName = aName;
	}
	
	
	public boolean repeatedTest(Test anotherTest) {
		if ((testType.equals(anotherTest.testType)) && (testCaseName.equals(anotherTest.testCaseName))) {			
				return true;
		}		
		return false;			
	}
	
	
	public void addAFixtureItem(String name, Object value) {
		if (!fixtureMap.isEmpty()) {
			if (!fixtureMap.containsKey(name)) {
				fixtureMap.put(name, value);
			}
		}
		else {
			fixtureMap.put(name, value);
		}
	}

	
	public Object getAFixtureItem(String name) {
		if (fixtureMap.containsKey(name)) {
			return fixtureMap.get(name);
		}
		return null;
	}
	
	
	public void setUpVariablesFromSuite(Map<String, Object> fixtures) {
		Iterator<String> it = fixtures.keySet().iterator();
		while (it.hasNext()){
			String key = it.next();
			addAFixtureItem(key,fixtures.get(key));
		}
	}
	
	
	public void beSkipped() {
		hasToBeSkipped = true;
	}

	
	public void dontBeSkipped() {
		hasToBeSkipped = false;
	}
	
}
