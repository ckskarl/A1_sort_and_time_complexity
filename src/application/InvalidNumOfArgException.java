package application;

/**
 * Exception Handler whenever the number of input arguments is invalid
 * @author Kin Shing Chong
 * @version 01/10/2021
 */
public class InvalidNumOfArgException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Exception Handler whenever the number of input arguments is invalid
	 * @param argsNum the number of input arguments
	 */
	public InvalidNumOfArgException(int argsNum) {
        System.out.println("Number of arguments in input: "+ argsNum);
		System.out.println("Invalid number of arguments.");
		System.out.println("Expected: three argumensts in any order, case insensitive");
    }
}