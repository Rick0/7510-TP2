package Grupo8;

/*
 * Clase abstracta, y padre de TestCase y TestSuite.
 * Se usa para poder aplicar el patron Composite.
 */
public abstract class Test {
	protected String testCaseName;
	protected String testType;
	
	public void runTest(TestResult result) {};
	
	public void runRegEx (TestResult result, String regEx){};
	
	public void setUp() {};
	
	public void tearDown() {};
	
	public String getName() {
		return testCaseName;
	}

	public void setName(String aName) {
		testCaseName = aName;
	}
	
	public boolean repeatedTest(Test anotherTest){
		if ((testType.equals(anotherTest.testType)) && (testCaseName.equals(anotherTest.testCaseName))){			
				return true;
		}		
		return false;			
	}
	
}
