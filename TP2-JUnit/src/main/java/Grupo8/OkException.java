package Grupo8;

/*
 * Excepcion que se arroja cuando el assert es correcto.
 */
class OkException extends Throwable {

	private static final long serialVersionUID = -6175146720064696149L;
	
	
	public OkException(String message) { 
		super(message); 
	}
	
	public OkException() {
		super();
	}	

}
