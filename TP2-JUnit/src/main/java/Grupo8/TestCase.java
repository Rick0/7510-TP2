package Grupo8;

/*
 * Clase que representa un "test individual".
 * Para poder ejecutar correctamente "runTest", primero hay que setear los valores a comparar,
 * con "setUp".
 */
public class TestCase extends Test {
	
	private Object testValue1;
	private Object testValue2;
	private int valuesQuantity;
	private boolean valuesAreSeted;
	
	
	public TestCase (String aTestCaseName) {
		testCaseName = aTestCaseName;
		valuesQuantity = 0;
		valuesAreSeted = false;
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
	
	public void runTest(TestResult result) {
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
	
	// setUp y tearDown vacios por defecto.
	public void setUp() {	
	}
	
	public void tearDown() {
	}
	
}
