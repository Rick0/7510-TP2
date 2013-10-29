package Grupo8;

public class TestCase extends Test {
	private String nombre;	
	TestResult unTestResult;
	
	TestCase (String nombre){
		this.setNombre(nombre);
		this.unTestResult = new TestResult();
	}
	
	//Puede ser o no implementado por el cliente.
	protected void setUp(){}
	
	//Puede ser o no implementado por el cliente.
	protected void tearDown(){}
	
	//Debe ser implementado por el cliente. Aquí está el assertTrue.
	protected void runTest(){}
	
	private void runTestResult(TestResult unTestResult){
		this.setUp();
		this.runTest();
		this.tearDown();
	}
	
	//Debe ser llamado por el usuario para correr el test.
	public void run() {		
		this.runTestResult(this.unTestResult);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
