package Grupo8;

public class TestCaseTest5B extends TestCase {
	
	public TestCaseTest5B(String name){
		super(name);
	}		
	
	public void testBody(){
		int a = (int)getAFixtureItem("A");
		int c = (int)getAFixtureItem("C");
		setAssertValue(a+c,4);
	}
}
