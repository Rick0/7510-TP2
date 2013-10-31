package Grupo8;

public abstract class Test {
	
	protected Assertions evaluator;
	
	
	Test () {
		evaluator = new Assertions();
	}
	
	public void runTest(TestResult result) {};
}
