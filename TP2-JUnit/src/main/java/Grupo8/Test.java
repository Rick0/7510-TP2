package Grupo8;

public abstract class Test {
	Test () {
		this.evaluador = new Assertions();
	}
	
	protected Assertions evaluador;
	
	public void run(){};
}
