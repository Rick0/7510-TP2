package Grupo8;

class FailureException extends Throwable{
	public FailureException(String message){ 
		super(message); 
	}
	public FailureException(){
		super();
	}

}
