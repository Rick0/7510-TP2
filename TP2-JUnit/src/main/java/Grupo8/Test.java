package Grupo8;

/*
 * Clase abstracta, y padre de TestCase y TestSuite.
 * Se usa para poder aplicar el patron Composite.
 */
public abstract class Test {
	protected String testCaseName;		
	
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
	
}
