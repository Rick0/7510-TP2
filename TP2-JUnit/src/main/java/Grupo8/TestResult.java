package Grupo8;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TestResult {
	
	List<Test> testsPassed;
	List<Test> testsFailed;
	List<Test> testsError;
	
	
	public TestResult() {
		testsPassed = new ArrayList<Test>();
		testsFailed = new ArrayList<Test>();
		testsError  = new ArrayList<Test>();
	}	
	
	public void addFailure(Test test) {
		testsFailed.add(test);
	}
	
	public void addError(Test test) {
		testsError.add(test);		
	}
	
	public void addPassed(Test test) {
		testsPassed.add(test);
	}
	
	public List<Test> getListPassed() {
		return testsPassed;
	}
	
	public List<Test> getListFailure() {
		return testsFailed;
	}

	public List<Test> getListError() {
		return testsError;
	}
	
	public void showResults() {
		System.out.println("");
		System.out.println("Resultado de los tests corridos");
		System.out.println("");
		System.out.println("Tests OK (" + getListPassed().size() + "):");
		printList(getListPassed());
		System.out.println("\n");
		System.out.println("Tests fallados (" + getListFailure().size() + "):");
		printList(getListFailure());
		System.out.println("\n");
		System.out.println("Tests con errores (" + getListError().size() + "):");
		printList(getListError());
		System.out.println("");
	}
	
	private void printList(List<Test> aList) {
		if (aList.isEmpty()) {
			System.out.println("\t-");
		}
		else {
			Iterator<Test> it = aList.iterator();
			while (it.hasNext()) {
				TestCase t = (TestCase)it.next();
				System.out.println("\t" + t.getNombre());
			}
		}
	}

}
