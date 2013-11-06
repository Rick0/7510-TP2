package Grupo8.ExampleUserTest;

import Grupo8.TestCase;


public class MyTestCase1OK extends TestCase {
	
	int a;
	int b;

	
	public MyTestCase1OK (String testName) {
		super(testName);
	}
	
	
	public void setUp() {
		a = 1;
	}
	
	
	public void testBody() {
		b = a * 2;
		a = a + b;
		
		int c = 3;
		setAssertValue(a, c);
	}

}
