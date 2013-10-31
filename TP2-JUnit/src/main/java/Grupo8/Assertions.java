package Grupo8;

public class Assertions {
	
	public void assertEqual (Object testValue1, Object testValue2) throws Throwable {
		if (!testValue1.equals(testValue2)) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}	
	
}
