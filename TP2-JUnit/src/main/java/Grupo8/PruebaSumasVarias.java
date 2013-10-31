package Grupo8;

import java.util.List;
import java.util.Iterator;

public class PruebaSumasVarias {	
	TestSuite conjunto = new TestSuite();
	
	public void crearPruebas(){
		TestCase test1 = new TestCase("UnoYUno");
		test1.setUp(1,1);		
		TestCase test2 = new TestCase("DosYUno");
		test2.setUp(2,1);
		TestCase test3 = new TestCase("AbYAb");
		test3.setUp("Ab", "Ab");
		TestCase test4 = new TestCase("AbYAB");
		test4.setUp("Ab", "AB");
		TestCase test5 = new TestCase("ABCD");
		conjunto.addTest(test1);
		conjunto.addTest(test2);
		conjunto.addTest(test3);
		conjunto.addTest(test4);
		conjunto.addTest(test5);
		TestResult resultados = new TestResult();
		conjunto.run(resultados);
		resultados.mostrarResultados();
				
	}
	
	private void imprimirLista(List<Test> lista){
		Iterator it = lista.iterator();
		while (it.hasNext()){
			TestCase t = (TestCase)it.next();
			System.out.println(t.getNombre());
		}
			
	}
}

