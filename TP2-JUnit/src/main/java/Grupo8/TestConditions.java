package Grupo8;

import java.util.Collection;

/*
 * Clase que contiene todas las condiciones para correr un test (caso ó suite),
 * como una expresion regular y/o tags.
 */
public class TestConditions {

	public String testCaseRegEx;
	public String testSuiteRegEx;
	public Collection<String> tags;


	public TestConditions(String oneTestCaseRegEx, String oneTestSuiteRegEx, Collection<String> someTags) {
		testCaseRegEx  = oneTestCaseRegEx;
		testSuiteRegEx = oneTestSuiteRegEx;
		tags           = someTags;
	}

}
