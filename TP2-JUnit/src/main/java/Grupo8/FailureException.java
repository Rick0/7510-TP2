package Grupo8;

class FailureException extends Throwable{

	private static final long serialVersionUID = -9133763983524959093L;
	
	
	public FailureException(String message){ 
		super(message); 
	}
	public FailureException(){
		super();
	}

}
