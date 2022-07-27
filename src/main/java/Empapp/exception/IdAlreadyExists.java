package Empapp.exception;

public class IdAlreadyExists extends RuntimeException {
	
	private String message;

	public IdAlreadyExists(String messages) {
		super(messages);
		this.message=messages;
		getMessage();
		
	}

	public IdAlreadyExists() {
		super("Employee exists in the database");
	}


}
