package Grupo8;

public class TestCase extends Test {
	private String nombre;	
	private Object valorATestear1;
	private Object valorATestear2;
	private boolean valoresSeteados;
	
	TestCase (String nombre){
		this.setNombre(nombre);
		this.valoresSeteados = false;
	}
		
	public void setUp(Object valorATestear1, Object valorATestear2){
		this.valorATestear1 = valorATestear1;
		this.valorATestear2 = valorATestear2;
		this.valoresSeteados = true;
	}
	
	public void runTest(TestResult result)  {
		if (this.valoresSeteados){
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
		else {
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
