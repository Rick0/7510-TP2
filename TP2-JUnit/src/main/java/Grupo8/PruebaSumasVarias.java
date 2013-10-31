package Grupo8;

public class PruebaSumasVarias {	
	TestSuite conjunto = new TestSuite();
	
	public void crearPruebas(){
		TestCase test1 = new TestCase("UnoYUno");
		test1.setUp(2,2);		
		TestCase test2 = new TestCase("DosYDos");
		test2.setUp(2,2);		
		conjunto.addTest(test1);
		conjunto.addTest(test2);
		TestResult resultados = new TestResult();
		conjunto.run(resultados);		
	}
}

