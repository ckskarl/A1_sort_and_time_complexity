package application;



/**
 * Application driver, which starts the RunSort class.
 * 
 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
 * @version 01/10/2021
 */
public class AppDriver {
	static String filename;
	static String sortType;
	static String compareType;
	
	/**
	 * Entry point to Java application.
	 * It parse the arguments in command line to check if they are valid.
	 * If valid, start the sorting process by initializing RunSort object.
	 * @param args user inputs in the command line
	 * @throws InvalidArgFormatException If the arguments in command line are invalid
	 */
	public static void main(String[] args) throws Exception {
		try {
			new AppDriver().parseArgs(args);
			RunSort running = new RunSort();
			running.runSort(filename, compareType, sortType);
		} catch (Exception e) {
    		System.out.println("Example of a Valid input: -fpolyfor1.txt -Tv -Sb");
    		System.out.println("-f for file path, -t for compare type, -t for sorting method");
    		System.out.println("For compare type (only 3 possibilities):v is volume, h is height, a is base area");
    		System.out.println("For sort type (only 6 possibilities):b is bubble, s is selection, i is insertion, m is merge, q is quick, and z is custom sort (shell sort).");
		} 
	}
	
	
	/**
	 * Entry point to Java application.
	 * It read and count the input arguments.
	 * @param args the input read from command line
	 * @throws Exception throwing exception when the number of arg is not 3 OR if it is missing required arguments type. 
	 */
	private void parseArgs(String[] args) throws Exception {
		int fileArgCount =0;
		int compareArgCount =0;
		int sortArgCount =0;
    	if( args.length != 3 ) {
    		throw new InvalidNumOfArgException(args.length) ;
    	}else {

    		for (int i=0;i<args.length;i++) {
    			if(args[i].toLowerCase().substring(0,2).equals("-f")){
    				filename = args[i].substring(2).toLowerCase();
    				fileArgCount++;
    			}else if(args[i].toLowerCase().substring(0,2).equals("-t") && args[i].length()==3){
    				compareType = args[i].substring(2).toLowerCase();
    				compareArgCount++;
    			}else if(args[i].toLowerCase().substring(0,2).equals("-s") && args[i].length()==3){
    				sortType = args[i].substring(2).toLowerCase();
    				sortArgCount++;
    			}
    		}
    		if (fileArgCount!=1 || compareArgCount!=1 || sortArgCount!=1) {
    			throw new InvalidArgFormatException(fileArgCount,compareArgCount,sortArgCount);
    		}
    	}
    }
	
}
