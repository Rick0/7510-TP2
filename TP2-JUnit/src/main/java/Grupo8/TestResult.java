package Grupo8;

public class TestResult {
	
	public TestResult(){
		
	}
	
	public void startTest(Test unTest){		
	
	}
	
	public void addFailure(Throwable excepcion){
		if (excepcion instanceof NullPointerException) {
			/*fallo*/
		}
		else {
			/*todo bien*/
		}
	}

}
