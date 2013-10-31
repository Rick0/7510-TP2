package Grupo8;

public class TestCase extends Test {
	private String nombre;	
	private Object valorATestear1;
	private Object valorATestear2;
	//private TestResult unTestResult;
	
	TestCase (String nombre){
		this.setNombre(nombre);
		//this.unTestResult = new TestResult();
	}
	
	//Puede ser o no implementado por el cliente.
	public void setUp(Object valorATestear1, Object valorATestear2){
		this.valorATestear1 = valorATestear1;
		this.valorATestear2 = valorATestear2;
	}
	
	//Debe ser implementado por el cliente. Aquí está el assertTrue.
	public void runTest(TestResult result)  {
		try{
			this.evaluador.testear(this.valorATestear1,this.valorATestear2);
		}		
		catch(OkException e){
			result.addPassed(this);
		}
		catch(FailureException e){
			result.addFailure(this);
		}		
		catch(Throwable e){
			result.addError(this);
		}
	}	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
