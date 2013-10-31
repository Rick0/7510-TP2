package Grupo8;

/*
 * Excepcion que se arroja cuando se presenta un error.
 * Generalmente ocurre cuando no estan seteados los valores para el assert.
 */
class ErrorException extends Throwable {

	private static final long serialVersionUID = 5261298112313992685L;
	
	
	public ErrorException(String message) { 
		super(message); 
	}
	
	public ErrorException() {
	}
	
}
