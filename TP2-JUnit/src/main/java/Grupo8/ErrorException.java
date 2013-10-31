package Grupo8;

class ErrorException extends Throwable {

	private static final long serialVersionUID = 5261298112313992685L;
	
	
	public ErrorException(String message) { 
		super(message); 
	}
	
	public ErrorException() {
	}
	
}
