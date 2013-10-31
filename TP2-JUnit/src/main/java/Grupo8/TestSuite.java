package Grupo8;

import java.util.Enumeration;
import java.util.Vector;

public class TestSuite extends Test {
	private Vector<Test> tests= new Vector<Test>();


	public void runTest(TestResult result){
		for (Enumeration<Test> elements= tests.elements(); elements.hasMoreElements(); ) { 
			Test test= (Test)elements.nextElement();
			test.runTest(result);		
		}  
	}
	
	public void addTest(Test test) { 
	    tests.addElement(test); 
	}

}
