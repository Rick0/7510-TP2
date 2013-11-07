package Grupo8;

public class TestSuiteA extends TestSuite {

	public TestSuiteA(String name){
		super(name);
	}	
	
	public void setUp() {
		addAFixtureItem("A",1);
	}
}
