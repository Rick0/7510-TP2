package Grupo8;

public class TestingInConsole {

	public static void main(String[] args) {
		testForTestElapsedTime();
		testForProgressiveReport();
	}
	
	public static void testForTestElapsedTime(){		
		TestSuite suite1 = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");		
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
				
		test1.setAssertValue(0, 0); 
		test2.setAssertValue(0, 0);	
		
		suite1.addTest(test1);
		suite1.addTest(test2);
		suite1.addTest(test3);		
				
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*T*.").buildTestConditions();
		suite1.setTestConditions(oneTestCondition);		
					
		suite1.runTest();
		
		System.out.print("Test 1 elapsed time: "); System.out.println(test1.getElapsedTime());
		System.out.print("Test 2 elapsed time: "); System.out.println(test2.getElapsedTime());
		System.out.print("Test 3 elapsed time: "); System.out.println(test3.getElapsedTime());
		
	}
	
	public static void testForProgressiveReport (){		
		TestSuite suite1 = new TestSuite("TS1");
		TestCase test1 = new TestCase("T1");		
		TestCase test2 = new TestCase("T2");
		TestCase test3 = new TestCase("T3");		
		
		test1.setAssertValue(0, 0); 
		test3.setAssertValue(0, 0); 
				
		suite1.addTest(test1);
		suite1.addTest(test2);
		suite1.addTest(test3);		
						
		TestConditions oneTestCondition = new TestConditionsBuilder().testCaseRegEx(".*T*.").buildTestConditions();
		suite1.setTestConditions(oneTestCondition);		
					
		suite1.runTest();
	}

}
