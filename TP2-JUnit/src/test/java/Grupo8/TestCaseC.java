package Grupo8;

public class TestCaseC extends TestCase {
	
	public TestCaseC (String name){
		super(name);
	}
	
	public void setUp() {
		addAFixtureItem("C",3);
	}
	
	public void testBody(){
		int a = (int)getAFixtureItem("A");
		int b = (int)getAFixtureItem("B");
		int c = (int)getAFixtureItem("C");
		int sum =  a+b+c;
		setAssertValue(sum,6);
	}

}
