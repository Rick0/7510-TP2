package Grupo8;

import java.util.Collection;
import java.util.Vector;

/*
 * Clase encargada de contruir un TestConditions.
 * Facilita las multiples posibilidades de combinacion de condiciones que el cliente requiere.
 */
public class TestConditionsBuilder {

	private String testCaseRegEx = "";
	private String testSuiteRegEx = "";
	private Collection<String> tags = new Vector<String>();


    public TestConditionsBuilder() {
    }

    
    public TestConditions buildTestConditions() {
    	return new TestConditions(testCaseRegEx, testSuiteRegEx, tags);
    }

    
    public TestConditionsBuilder testCaseRegEx(String oneRegEx) {
    	testCaseRegEx = oneRegEx;
        return this;
    }

    
    public TestConditionsBuilder testSuiteRegEx(String oneRegEx) {
    	testSuiteRegEx = oneRegEx;
        return this;
    }

    
    public TestConditionsBuilder tags(Collection<String> someTags) {
    	tags = someTags;
        return this;
    }
    
}
