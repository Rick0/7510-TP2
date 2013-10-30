package Grupo8;

import java.util.List;

public class TestResult {
	List<Test> testsPassed;
	List<Test> testsFailed;
	List<Test> testsError;
	
	
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
	
	public void addFailure(Test test){
		testsFailed.add(test);
	}
	
	public void addError(Test test){
		testsError.add(test);		
	}
	
	public void addPassed(Test test){
		testsPassed.add(test);
	}
	
	public List<Test> getListPassed(){
		return testsPassed;
	}
	
	public List<Test> getListFailure(){
		return testsFailed;
	}

	public List<Test> getListError(){
		return testsError;
	}
	
	
}
