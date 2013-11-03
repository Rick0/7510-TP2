package Grupo8;

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
