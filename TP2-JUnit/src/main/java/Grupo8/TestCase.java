package Grupo8;

public class TestCase extends Test {
	
	private String testCaseName;	
	private Object testValue1;
	private Object testValue2;
	private boolean valuesAreSeted;
	
	
	public TestCase (String aTestCaseName) {
		testCaseName = aTestCaseName;
		valuesAreSeted = false;
	}
		
	public void setUp(Object aTestValue1, Object aTestValue2) {
		testValue1 = aTestValue1;
		testValue2 = aTestValue2;
		valuesAreSeted = true;
	}
	
	public void runTest(TestResult result) {
		if (valuesAreSeted) {
			try {
				evaluator.assertEqual(testValue1, testValue2);
			}		
			catch(OkException e) {
				result.addPassed(this);
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
	
	public String getNombre() {
		return testCaseName;
	}

	public void setNombre(String aName) {
		testCaseName = aName;
	}
	
}
