package Grupo8;

import java.util.Enumeration;
import java.util.Vector;

public class TestSuite extends Test {
	private String nombre;
	private Vector tests= new Vector();

	TestSuite(String name){
		nombre = name;
	}

	public void run(TestResult result){
		for (Enumeration elements= tests.elements(); elements.hasMoreElements(); ) { 
			Test test= (Test)elements.nextElement();
			try{
				test.run();
			}
			catch(NullPointerException e){
				result.addPassed(test);
			}
			catch(ExceptionInInitializerError e){
				result.addFailure(test);
			}
		} 
	}
	
	public void addTest(Test test) { 
	    tests.addElement(test); 
	}

}