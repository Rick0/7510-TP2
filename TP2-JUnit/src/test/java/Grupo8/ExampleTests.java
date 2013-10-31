package Grupo8;

public class ExampleTests {

    public static void main (String[] args) {
    	
		TestSuite conjunto = new TestSuite();
    
		TestCase test1 = new TestCase("UnoYUno");
		test1.setUp(1,1);		
		TestCase test2 = new TestCase("DosYUno");
		test2.setUp(2,1);
		TestCase test3 = new TestCase("AbYAb");
		test3.setUp("Ab", "Ab");
		TestCase test4 = new TestCase("AbYAB");
		test4.setUp("Ab", "AB");
		TestCase test5 = new TestCase("eeYaa");
		
		conjunto.addTest(test1);
		conjunto.addTest(test2);
		conjunto.addTest(test3);
		conjunto.addTest(test4);
		conjunto.addTest(test5);
		
		TestResult results = new TestResult();
		conjunto.runTest(results);
		results.showResults();
	}
	
}
