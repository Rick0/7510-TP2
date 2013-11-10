package Grupo8;

public class TestCaseTest5A extends TestCase {

	public TestCaseTest5A(String name){
		super(name);
	}	
	
	public void testBody(){
		int a = (int)getAFixtureItem("A");
		int b = (int)getAFixtureItem("B");
		setAssertValue(a+b,3);
	}
}
