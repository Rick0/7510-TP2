package Grupo8;

/*
 * Clase abstracta, y padre de TestCase y TestSuite.
 * Se usa para poder aplicar el patron Composite.
 */
public abstract class Test {
	
	protected String testCaseName;
	protected String testType;
	
	
	public abstract void runTest(TestResult result);
	
	
	public abstract void runRegEx (TestResult result, String regEx);
	
	
	public abstract void testBody();
	
	
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

}
