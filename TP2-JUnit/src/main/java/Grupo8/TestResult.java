package Grupo8;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

/*
 * Clase encargado de la logica de los resultados de los tests.
 * Despues de ordenar los resultados de los tests, puede mostrar los resultados
 * tanto por consola como a traves de un archivo de texto.
 */
public class TestResult {

	List<TestAssertResult> tests;	
	List<TestResult> testsResults;
	private String name;
	private String reportPath;
	private String separator = "-----------------------------------";
	boolean print;
	
	
	public TestResult() {
		tests = new ArrayList<TestAssertResult>();
		testsResults = new ArrayList<TestResult>();
		name = "Unnamed";
		separator = repeatString("-",name.length()); 
		reportPath=name+".txt";		
		print = false;
	}
	
	
	public TestResult(String aName) {
		tests = new ArrayList<TestAssertResult>();
		testsResults = new ArrayList<TestResult>();
		name = aName;		
		reportPath=name+".txt";
		separator = repeatString("-",name.length());
		print = false;
	}	
	
	public void setPrint(boolean bool){
		print=bool;
	}
	
	public TestResult addTestResult(String testResultName){
		TestResult newTestResult = new TestResult(name+"."+testResultName);
		newTestResult.setPrint(print);
		newTestResult.setReportPath(reportPath);
		testsResults.add(newTestResult);
		newTestResult.setPrint(print);
		return newTestResult;
	}	
	
	
	public void addFailure(Test test) {
		tests.add(new TestAssertResult(test,"Fail"));
		if (print){
			System.out.println("[Failure] "+test.getName());		
		}
	}
	
	public void addError(Test test) {		
		tests.add(new TestAssertResult(test,"Error"));
		if (print){
			System.out.println("[Error] "+test.getName());	
		}		
	}
	
	public void addPassed(Test test) {		
		tests.add(new TestAssertResult(test,"OK"));
		if (print){
			System.out.println("[OK] "+test.getName());
		}
	}
	
	
	public void setReportPath(String path){
		reportPath = path;
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
	
	public String getResultName(){
		return name;
	}
	
	public void printResultName(){
		if (print){
			System.out.println("");
			System.out.println(name);
			System.out.println(separator);			
		}
	}
	
	public void showReport() {
		File file = new File(reportPath);
		file.delete();
		showTestResultData();
		printResume();

	}


	public void printResume() {
		List<String> summary = getSummaryLines();
		Iterator<String> it = summary.iterator();
		while (it.hasNext()) {
			String line = it.next();
			writeLine(line);
		}
	}
	
	public void consoleResume(){
		if (print){
			List<String> summary = getSummaryLines();
			Iterator<String> it = summary.iterator();
			while (it.hasNext()) {
				String line = it.next();
				System.out.println(line);
			}
		}
		
	}
	
	
	
	public List<String> getSummaryLines(){
		List<String> summary = new ArrayList<String>();

		int errors = getListError().size();
		int oks = getListPassed().size();
		int failures = getListFailure().size();
		
		String line;		
		if (errors + failures > 0) {
			line = "[failure]";
		}
		else {
			line = "[OK]";
		}
		summary.add("");
		line = line+"Summary";
		summary.add(line);		
		summary.add(separator);
		summary.add(separator);
		summary.add("Run: "+(oks+errors+failures));
		if (errors > 0){
			summary.add("Errors: "+errors);
		}
		if (failures > 0){
			summary.add("Failures: "+failures);
		}
		
		return summary;
		
	}

	
	public void showTestResultData(){
		writeLine(name);
		writeLine(separator);
		printTestsList();
		writeLine("");
		printTestsResults();
	}
	
	
	private void printTestsList() {
		if (tests.isEmpty()) {
			writeLine("\t-");
		}
		else {
			Iterator<TestAssertResult> it = tests.iterator();
			while (it.hasNext()) {
				TestAssertResult t = (TestAssertResult)it.next();
				writeLine("\t" + "[" + t.getTest().getElapsedTime() + "]\t" + "[" + t.getResult()+"] " + t.getTest().getName() );
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
	
	
	private void writeLine(String line) {
		try {
			FileWriter outFile = new FileWriter(reportPath,true);
			PrintWriter out = new PrintWriter(outFile);
			out.write(line);
			out.write("\n");
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	public String getResult(String testName){
		if (! tests.isEmpty()) {		
			Iterator<TestAssertResult> it = tests.iterator();
			while (it.hasNext()) {
				TestAssertResult t = (TestAssertResult)it.next();
				if (t.getTest().getName().equals(testName)){
					return (t.getResult());
				}
			}
		}
		
		if (!testsResults.isEmpty()) {
			Iterator<TestResult> it = testsResults.iterator();
			while (it.hasNext()) {
				TestResult t = (TestResult)it.next();
				String result = t.getResult(testName);
				if (!result.equals("\t-")){
					return result;
				}
			}
		}		
				
		return ("\t-");
	}
	
	private String repeatString(String string, Integer n) {
		String returnString = "";
	    for (Integer x = 0; x < n; x++){
	        returnString = returnString+string;
	    }
	    return returnString;	    
	}

}

