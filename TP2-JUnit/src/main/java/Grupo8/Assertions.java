package Grupo8;

public class Assertions {
	public boolean assertTrue(){return true;}
	//tiene que arrojar una Excepcion
	public void assertEquals(int a, int b){
		NullPointerException e = new NullPointerException();
		ExceptionInInitializerError f = new ExceptionInInitializerError();
		if (a!=b) throw e;
		else throw f;}
}
