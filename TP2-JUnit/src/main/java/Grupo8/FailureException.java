package Grupo8;

/*
 * Excepcion que se arroja cuando el assert no es satisfactorio.
 */
class FailureException extends Throwable {

	private static final long serialVersionUID = -9133763983524959093L;


	public FailureException(String message) { 
		super(message); 
	}

	public FailureException() {
		super();
	}

}
