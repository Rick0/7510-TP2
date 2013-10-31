package Grupo8;

public class Assertions {
	public void testear (Object valorATestear1, Object valorATestear2) throws Throwable {
		if (!valorATestear1.equals(valorATestear2)) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}	
	
}
