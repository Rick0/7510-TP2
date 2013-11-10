package Grupo8;

import java.util.Collection;

/*
 * Clase que contiene todas las condiciones para correr un test,
 * como una expresion regular y/o un tag.
 */
public class TestConditions {

	private String testCaseRegEx;
	private String testSuitRegEx;
	private Collection<String> tags;
	
	
	public TestConditions(String oneTestCaseRegEx, String oneTestSuitRegEx, Collection<String> someTags) {
		testCaseRegEx = oneTestCaseRegEx;
		testSuitRegEx = oneTestSuitRegEx;
		tags          = someTags;
	}
	
	
	// getters y setters:
	public String getTestCaseRegEx() {
		return testCaseRegEx;
	}

	public void setTestCaseRegEx(String testCaseRegEx) {
		this.testCaseRegEx = testCaseRegEx;
	}

	public String getTestSuitRegEx() {
		return testSuitRegEx;
	}

	public void setTestSuitRegEx(String testSuitRegEx) {
		this.testSuitRegEx = testSuitRegEx;
	}

	public Collection<String> getTags() {
		return tags;
	}

	public void setTags(Collection<String> tags) {
		this.tags = tags;
	}
	
}
