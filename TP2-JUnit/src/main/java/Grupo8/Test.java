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
	protected Map<String,Object> fixtures;
	

	public abstract void runTest(TestResult result);
	
	
	public abstract void runRegEx (TestResult result, String regEx);
	
	
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
		if (!fixtures.isEmpty()) {
			if (!fixtures.containsKey(name)) {
				fixtures.put(name, value);
			}
		}
		else {
			fixtures.put(name, value);
		}
	}
	

	public void setUpVariablesFromSuite(Map<String, Object> fixtures) {
		/*Iterator it = fixtures.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();			
			addAFixtureItem((String)e.getKey(),e.getValue());
		}*/
		Iterator<String> it = fixtures.keySet().iterator();
		while (it.hasNext()){
			String key = it.next();
			addAFixtureItem(key,fixtures.get(key));
		}

	}
	

	public Object getAFixtureItem(String name) {
		if (fixtures.containsKey(name)) {
			return fixtures.get(name);
		}
		return null;
	}

}
