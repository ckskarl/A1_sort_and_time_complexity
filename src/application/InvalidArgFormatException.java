package application;


/**
 * Exception Handler whenever the input argument format is invalid
 * @author Kin Shing Chong
 * @version 01/10/2021
 */
public class InvalidArgFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Exception Handler whenever the input argument is missing one of the required fields (filepath, compare type or sort type)
	 * @param fileArgCount counting the valid file argument input
	 * @param compareArgCount counting the valid compare argument input
	 * @param sortArgCount counting the valid sort argument input
	 */
	public InvalidArgFormatException(int fileArgCount,int compareArgCount,int sortArgCount) {
        System.out.println("Number of correct file argument provided (expected 1): "+ fileArgCount);
        System.out.println("Number of correct compare method argument provided (expected 1): "+ compareArgCount);
        System.out.println("Number of correct sort method argument provided (expected 1): "+ sortArgCount);
		System.out.println("Expected: 3 argumensts in any order, case insensitive, 1 for filepath, 1 for compare method, 1 for sort method.");
    }
	
	
	/**
	 * Exception Handler whenever the input argument is not in the pool of accepted type
	 * @param compareType the compare type input
	 * @param sortType the sort type input
	 */
	public InvalidArgFormatException(String compareType,String sortType) {
        System.out.println("Incorrect type input!");
        System.out.println("Compare Type input: "+ compareType);
        System.out.println("Sort Type input: "+ sortType);
    }
}