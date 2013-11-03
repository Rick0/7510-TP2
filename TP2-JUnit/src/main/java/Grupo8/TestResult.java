package Grupo8;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/*
 * Clase encargado de la logica de los resultados de los tests.
 * Tiene 3 listas que guarda, acordemente, los tests correctos, los tests fallidos,
 * y los tests con errores, para luego mostrarlos ordenadamente por consola.
 */
public class TestResult {

	List<TestAssertResult> tests;	
	List<TestResult> testsResults;
	
	List<Test> testsPassed;	
	List<Test> testsFailed;
	List<Test> testsError;	
	private String name;
	
	
	public TestResult() {
		tests = new ArrayList<TestAssertResult>();
		testsResults = new ArrayList<TestResult>();
		name = "Unnamed";
	}
	
	public TestResult(String aName) {
		tests = new ArrayList<TestAssertResult>();
		testsResults = new ArrayList<TestResult>();
		name = aName;
	}	
	
	public TestResult addTestResult(String testResultName){
		TestResult newTestResult = new TestResult(name+"."+testResultName);
		testsResults.add(newTestResult);
		return newTestResult;
	}	
	
	public void addFailure(Test test) {
		tests.add(new TestAssertResult(test,"Fail"));
	}
	
	public void addError(Test test) {		
		tests.add(new TestAssertResult(test,"Error"));
	}
	
	public void addPassed(Test test) {		
		tests.add(new TestAssertResult(test,"OK"));
	}
	
	public List<Test> getListPassed() {
		List<Test> list = new ArrayList<Test>();
		fillList(list,"OK",this);
		return list;
	}		
	
	private void fillList(List<Test> list, String result, TestResult testResult){
		Iterator<TestAssertResult> it = testResult.tests.iterator();		
		while (it.hasNext()) {
			TestAssertResult t = (TestAssertResult)it.next();
			if (t.getResult().equals(result)){
				list.add(t.getTest());
			}
		}
		Iterator<TestResult> itResults = testResult.testsResults.iterator();
		while (itResults.hasNext()){
			TestResult tr = (TestResult)itResults.next();
			fillList(list,result,tr);
		}
		
	}
	
	
	public List<Test> getListFailure() {
		List<Test> list = new ArrayList<Test>();
		fillList(list,"Fail",this);
		return list;
	}

	public List<Test> getListError() {
		List<Test> list = new ArrayList<Test>();
		fillList(list,"Error",this);
		return list;
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
				System.out.println("\t" + t.getName());
			}
		}
	}
		
	public void showReport() {
		showTestResultData();
		int errors = getListError().size();
		int oks = getListPassed().size();
		int failures = getListFailure().size(); 
		if (errors + failures > 0) {
			System.out.print("[failure]");
		}else{
			System.out.print("[OK]");
		}		
		System.out.println("Summary");
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println("Run: "+(oks+errors+failures));
		if (errors > 0){
			System.out.println("Errors: "+errors);
		}
		if (failures > 0){
			System.out.println("Failures: "+failures);
		}

	}

	public void showTestResultData(){
		System.out.println(name);
		System.out.println("-------------------------");
		printTestsList();
		System.out.println("");
		printTestsResults();
	}
	
	private void printTestsList() {
		if (tests.isEmpty()) {
			System.out.println("\t-");
		}else{
			Iterator<TestAssertResult> it = tests.iterator();
			while (it.hasNext()) {
				TestAssertResult t = (TestAssertResult)it.next();
				System.out.println("\t" + "[" + t.getResult()+"] "+t.getTest().getName());
			}
		}
	}
	
	private void printTestsResults() {
		if (!testsResults.isEmpty()) {
			Iterator<TestResult> it = testsResults.iterator();
			while (it.hasNext()) {
				TestResult t = (TestResult)it.next();
				t.showTestResultData();
			}
		}
	}
	
}