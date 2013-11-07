package Grupo8;

public class TestSuiteTest5 extends TestSuite {
	public TestSuiteTest5(String name){
		super(name);
	}
	
	public void setUp() {
		addAFixtureItem("A",1);
	}
}
