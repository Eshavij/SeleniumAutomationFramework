package exceptionhandling;

public class FileNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FileNotFound(String str){
		super(str);
	}
}