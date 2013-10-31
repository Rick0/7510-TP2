package Grupo8;

public abstract class Test {
	
	protected Assertions evaluador;
	
	
	Test () {
		evaluador = new Assertions();
	}
	
	public void runTest(TestResult result) {};
}
