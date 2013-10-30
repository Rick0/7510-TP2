package Grupo8;

public class Assertions {
	public boolean assertTrue(){return true;}
	//tiene que arrojar una Excepcion
	public void assertEquals(int a, int b){
		NullPointerException e = new NullPointerException();
		ExceptionInInitializerError f = new ExceptionInInitializerError();
// Cree un par de excepciones. Fijate si van. Si es asi, dejalas.		
//		OkException e = new OkException();
//		FailureException f = new FailureException();
//		ErrorException er = new ErrorException();
		if (a!=b) throw e;
		else throw f;
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
