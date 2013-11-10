package Grupo8;

public class TestSuiteTest5A extends TestSuite {
	public TestSuiteTest5A(String name){
		super(name);
	}
	
	public void setUp() {
		addAFixtureItem("B",2);
	}
}
