package Grupo8;

public class TestSuiteTest5B extends TestSuite {
	public TestSuiteTest5B(String name){
		super(name);
	}
	
	public void setUp() {
		addAFixtureItem("C",3);
	}	
}
