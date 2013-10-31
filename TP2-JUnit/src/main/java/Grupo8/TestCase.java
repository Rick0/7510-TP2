package Grupo8;

public class TestCase extends Test {
	
	private String testCaseName;	
	private Object testValue1;
	private Object testValue2;
	private int valuesQuantity;
	private boolean valuesAreSeted;
	
	
	public TestCase (String aTestCaseName) {
		testCaseName = aTestCaseName;
		valuesQuantity = 0;
		valuesAreSeted = false;
	}
	
	public void setUp(Object aTestValue1, Object aTestValue2) {
		testValue1 = aTestValue1;
		testValue2 = aTestValue2;
		valuesQuantity = 2;
		valuesAreSeted = true;
	}
	
	public void setUp(Object aTestValue) {
		testValue1 = aTestValue;
		valuesQuantity = 1;
		valuesAreSeted = true;
	}
	
	public void runTest(TestResult result) {
		if (valuesAreSeted) {
			try {
				if (valuesQuantity == 2) {
					evaluator.assertEqual(testValue1, testValue2);
				}
				else if (valuesQuantity == 1) {
					evaluator.assertTrue((boolean)testValue1);
				}
				else {
					result.addError(this);
				}
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
