package Grupo8;

public class TestCaseSetUpTest extends TestCase {

	public TestCaseSetUpTest(String name){
		super(name);
	}	
	
	public void setUp() {
		addAFixtureItem("A",1);
	}	
	
	public void testBody(){
		setAssertValue(getAFixtureItem("A"),1);
	}
	
}
