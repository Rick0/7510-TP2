package Grupo8;

/*
 * Clase encargada de comparar los valores de los tests, o sea de evaluar los asserts.
 * Si el assert falla, retorna un FailureException.
 * En el caso de que se produzca un error, se lanzara un error acorde a eso (propio de java). 
 */
public class Assertions {

	public static void assertTrue (boolean testValue) throws Throwable {
		if (!testValue) {
			throw new FailureException();			
		}
	}
	
	
	public static void assertEqual (boolean testValue1, boolean testValue2) throws Throwable {
		if (! (testValue1 == testValue2) ) {
			throw new FailureException();			
		}
	}
	
	
	public static void assertEqual (int testValue1, int testValue2) throws Throwable {
		if (! (testValue1 == testValue2) ) {
			throw new FailureException();			
		}
	}
	
	
	public static void assertEqual (char testValue1, char testValue2) throws Throwable {
		if (! (testValue1 == testValue2) ) {
			throw new FailureException();			
		}
	}
	
	
	public static void assertEqual (float testValue1, float testValue2) throws Throwable {
		if (! (testValue1 == testValue2) ) {
			throw new FailureException();			
		}
	}
	
	
	public static void assertEqual (Object testValue1, Object testValue2) throws Throwable {
		if (!testValue1.equals(testValue2)) {
			throw new FailureException();			
		}
	}
	
}
