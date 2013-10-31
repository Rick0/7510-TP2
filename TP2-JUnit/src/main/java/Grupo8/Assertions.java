package Grupo8;

public class Assertions {

	public void assertTrue (boolean testValue) throws Throwable {
		if (!testValue) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}
	
	
	public void assertEqual (int testValue1, int testValue2) throws Throwable {
		if (! (testValue1 == testValue2) ) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}
	
	
	public void assertEqual (char testValue1, char testValue2) throws Throwable {
		if (! (testValue1 == testValue2) ) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}
	
	
	public void assertEqual (float testValue1, float testValue2) throws Throwable {
		if (! (testValue1 == testValue2) ) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}
	
	
	public void assertEqual (Object testValue1, Object testValue2) throws Throwable {
		if (!testValue1.equals(testValue2)) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}
	
}
