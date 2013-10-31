package Grupo8;

import java.util.Enumeration;
import java.util.Vector;

/*
 * Clase que contiene a todos los "tests individuales".
 */
public class TestSuite extends Test {

	private Vector<Test> tests = new Vector<Test>();


	public void runTest(TestResult result) {
		for (Enumeration<Test> elements = tests.elements(); elements.hasMoreElements(); ) { 
			TestCase test = (TestCase)elements.nextElement();
			test.runTest(result);		
		}  
	}
	
	public void addTest(Test test) { 
	    tests.addElement(test); 
	}

}
