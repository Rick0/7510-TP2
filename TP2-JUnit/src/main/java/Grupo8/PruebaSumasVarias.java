package Grupo8;

public class PruebaSumasVarias {	
	TestSuite conjunto = new TestSuite("Prueba General");
	
	public void crearPruebas(){
		TestCase test1 = new TestCase("UnoYUno");
		test1.evaluador.assertEquals(1,1);
		TestCase test2 = new TestCase("DosYDos");
		test2.evaluador.assertEquals(2,2);
		conjunto.addTest(test1);
		conjunto.addTest(test2);
		TestResult resultados = new TestResult();
		conjunto.run(resultados);
	}
}

