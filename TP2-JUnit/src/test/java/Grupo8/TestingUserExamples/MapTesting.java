package Grupo8.TestingUserExamples;

import Grupo8.TestCase;


public class MapTesting extends TestCase {

	public MapTesting(String aTestCaseName) {
		super(aTestCaseName);
	}
	
	
	public void setUp() {
		addAFixtureItem("a", 1);		
	}
	
	
	public void testBody () {
		int b = (int) getAFixtureItem("a");
		setAssertValue(b,1);
	}

}
