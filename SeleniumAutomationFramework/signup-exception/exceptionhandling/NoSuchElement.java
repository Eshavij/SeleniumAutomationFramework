package exceptionhandling;
/**
 * No such element exception
 * @author esha
 *
 */

public class NoSuchElement  extends Exception{
	
private static final long serialVersionUID = 1L;
	
	public NoSuchElement(String str){
		super(str);
	}



}
