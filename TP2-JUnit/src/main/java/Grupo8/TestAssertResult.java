package Grupo8;

/*
 * Clase que se utiliza para guardar el resultado de correr un test.
 * Los posibles valores que va a recibir son "Ok", "Fail" o "Error"
 */
public class TestAssertResult {
	private Test test;
	private String result;
	
	
	public TestAssertResult(Test aTest,String resultName){
		test = aTest;
		result = resultName;
	}
	
	public Test getTest(){
		return test;
	}
	
	public String getResult(){
		return result;
	}

}
