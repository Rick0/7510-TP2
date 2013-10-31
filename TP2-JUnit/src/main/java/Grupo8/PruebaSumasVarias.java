package Grupo8;

import java.util.List;
import java.util.Iterator;

public class PruebaSumasVarias {	
	TestSuite conjunto = new TestSuite();
	
	public void crearPruebas(){
		TestCase test1 = new TestCase("UnoYUno");
		test1.setUp(2,2);		
		TestCase test2 = new TestCase("DosYDos");
		test2.setUp(2,1);		
		conjunto.addTest(test1);
		conjunto.addTest(test2);
		TestResult resultados = new TestResult();
		conjunto.run(resultados);
		System.out.println("Ok");
		imprimirLista(resultados.getListPassed());
		System.out.println("Fallados");
		imprimirLista(resultados.getListFailure());
				
	}
	
	private void imprimirLista(List<Test> lista){
		Iterator it = lista.iterator();
		while (it.hasNext()){
			TestCase t = (TestCase)it.next();
			System.out.println(t.getNombre());
		}
			
	}
}

