package main;

public class IncorrectInput extends IllegalArgumentException{
	
	

	public IncorrectInput() {
		super();
	}
	
	public IncorrectInput(String message) {
		super(message);
	}

}
