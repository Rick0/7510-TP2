package Grupo8;

public class Assertions {
	public boolean assertTrue(){return true;}
	//tiene que arrojar una Excepcion
	//public void assertEquals(int a, int b){
		//NullPointerException e = new NullPointerException();
		//ExceptionInInitializerError f = new ExceptionInInitializerError();
// Cree un par de excepciones. Fijate si van. Si es asi, dejalas.		
//		OkException e = new OkException();
//		FailureException f = new 	();
//		ErrorException er = new ErrorException();
		//if (a!=b) throw e;
		//else throw f;
	//}
	
	public void testear (Object valorATestear1, Object valorATestear2) throws Throwable {
		if (valorATestear1 != valorATestear2) {
			throw new FailureException();			
		}
		else {
			throw new OkException();
		}
	}
	
/*
	public void assertEquals(String a, String b){
		NullPointerException e = new NullPointerException();
		ExceptionInInitializerError f = new ExceptionInInitializerError();
		if (!a.equals(b)) throw e;
		else throw f;}
	
	public void assertEquals(double a, double b){
		NullPointerException e = new NullPointerException();
		ExceptionInInitializerError f = new ExceptionInInitializerError();
		if (a!=b) throw e;
		else throw f;}
	
	public void assertEquals(boolean a, boolean b){
		NullPointerException e = new NullPointerException();
		ExceptionInInitializerError f = new ExceptionInInitializerError();
		if (a!=b) throw e;
		else throw f;}
*/	
}
