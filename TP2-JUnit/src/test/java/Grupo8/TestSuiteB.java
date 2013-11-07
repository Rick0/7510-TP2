package Grupo8;

public class TestSuiteB extends TestSuite {
	public TestSuiteB(String name){
		super(name);
	}
	
	public void setUp() {
		addAFixtureItem("B",2);
	}
}
