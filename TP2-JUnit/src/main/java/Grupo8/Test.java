package Grupo8;

/*
 * Clase abstracta, y padre de TestCase y TestSuite.
 * Se usa para poder aplicar el patron Composite.
 */
public abstract class Test {
	
	public void runTest(TestResult result) {};
	
	public void setUp() {};
	
	public void tearDown() {};
	
}
