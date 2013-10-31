package Grupo8;

public class TestCase extends Test {
	
	private String nombre;	
	private Object valorATestear1;
	private Object valorATestear2;
	private boolean valoresSeteados;
	
	
	TestCase (String testCaseNombre) {
		nombre = testCaseNombre;
		valoresSeteados = false;
	}
		
	public void setUp(Object unValorATestear1, Object unValorATestear2) {
		valorATestear1 = unValorATestear1;
		valorATestear2 = unValorATestear2;
		valoresSeteados = true;
	}
	
	public void runTest(TestResult result) {
		if (valoresSeteados) {
			try {
				evaluador.testear(valorATestear1, valorATestear2);
			}		
			catch(OkException e) {
				result.addPassed(this);
			}
			catch(FailureException e) {
				result.addFailure(this);
			}		
			catch(Throwable e) {
				result.addError(this);
			}
		}
		else {
			result.addError(this);
		}		
	}	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String unNombre) {
		nombre = unNombre;
	}
	
}
