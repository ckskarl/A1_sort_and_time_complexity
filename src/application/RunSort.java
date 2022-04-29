package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import problemdomain.Shape;
import utility.*;


/**
 * Class contains the method runSort which is called by the appDriver main method. This starts various sorting methods depending on the user input on the command line interface.
 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
 * @version 01/10/2021
 */
public class RunSort {
	long start, stop;
	String sortBy;
	String sortName;

	/**
	 * Creates a file scanner that reads each record of the specified file (etc.
	 * polyfor1 text file) and generates a java array of Shape type populated by those records.
	 * Finally, based off the user inputs from the main class the method calls the
	 * user specified compare type and sort types and compares them while displaying a partial
	 * sorted list of shapes and the time it took for the application to sort and
	 * compare them.
	 * 
	 * @param filename    Sting input from user passing from argument from command line
	 * @param compareType String input from user passing from argument from command line
	 * @param sortType    String input from user passing from argument from command line
	 * @throws InvalidArgFormatException If the input type is not in the predefined pool, throws InvalidArgFormatException.
	 * @throws FileNotFoundException if the file is not found, throw FileNotFoundException.
	 */
	public void runSort(String filename, String compareType, String sortType) throws InvalidArgFormatException,FileNotFoundException  {
		File file = new File(filename);
		Scanner sc;
		try {
			sc = new Scanner(file);
			int numberOfShapes = sc.nextInt();
			Shape[] shapeList = new Shape[numberOfShapes];
			while (sc.hasNext()) {
				for (int i = 0; i < numberOfShapes; i++) {
					String name = sc.next();
					Double firstNum = sc.nextDouble();
					Double secondNum = sc.nextDouble();
					Shape Shape = new Shape(name, firstNum, secondNum);
					shapeList[i] = Shape;
				}
			}
			sc.close();

			if (compareType.equals("v")) {
				sortBy = "volume";
				CompareVolume byVolume = new CompareVolume();
				switch (sortType) {
				case "b":
					sortName = "Bubble Sort";
					start = System.nanoTime();
					Sort.bubbleSort(shapeList, byVolume);
					stop = System.nanoTime();
					break;
				case "s":
					sortName = "Selection Sort";
					start = System.nanoTime();
					Sort.selectionSort(shapeList, byVolume);
					stop = System.nanoTime();
					break;
				case "i":
					sortName = "Insertion Sort";
					start = System.nanoTime();
					Sort.insertionSort(shapeList, byVolume);
					stop = System.nanoTime();
					break;
				case "m":
					sortName = "Merge Sort";
					start = System.nanoTime();
					Sort.mergeSort(shapeList, 0, shapeList.length - 1, byVolume);
					stop = System.nanoTime();
					break;
				case "q":
					sortName = "Quicksort";
					start = System.nanoTime();
					Sort.quicksort(shapeList, byVolume);
					stop = System.nanoTime();
					break;
				case "z":
					sortName = "Shell Sort(Custom Sort)";
					start = System.nanoTime();
					Sort.shellsort(shapeList, byVolume);
					stop = System.nanoTime();
					break;
				default:
					throw new InvalidArgFormatException(compareType,sortType);	
				}				
				System.out.printf("Rank:  %5d   Type: %-20s                  Volume: %25.2f \n", 1,
						shapeList[0].getName(), shapeList[0].getVolume());
				for (int i = 999; i < shapeList.length; i += 1000) {
					System.out.printf("Rank:  %5d   Type: %-20s                  Volume: %25.2f \n", i + 1,
							shapeList[i].getName(), shapeList[i].getVolume());
				}
				System.out.printf("Rank:  %5d   Type: %-20s                  Volume: %25.2f \n", shapeList.length,
						shapeList[shapeList.length - 1].getName(), shapeList[shapeList.length - 1].getVolume());
				System.out.println(
						"The time(nanosecond) for the " + sortName + " by " + sortBy + " is: " + (stop - start));

			} else if (compareType.equals("a")) {
				sortBy = "base area";
				CompareBaseArea byBaseArea = new CompareBaseArea();
				switch (sortType) {
				case "b":
					sortName = "Bubble Sort";
					start = System.nanoTime();
					Sort.bubbleSort(shapeList, byBaseArea);
					stop = System.nanoTime();
					break;
				case "s":
					sortName = "Selection Sort";
					start = System.nanoTime();
					Sort.selectionSort(shapeList, byBaseArea);
					stop = System.nanoTime();
					break;
				case "i":
					sortName = "Insertion Sort";
					start = System.nanoTime();
					Sort.insertionSort(shapeList, byBaseArea);
					stop = System.nanoTime();
					break;
				case "m":
					sortName = "Merge Sort";
					start = System.nanoTime();
					Sort.mergeSort(shapeList, 0, shapeList.length - 1, byBaseArea);
					stop = System.nanoTime();
					break;
				case "q":
					sortName = "Quicksort";
					start = System.nanoTime();
					Sort.quicksort(shapeList, byBaseArea);
					stop = System.nanoTime();
					break;
				case "z":
					sortName = "Shell Sort(Custom Sort)";
					start = System.nanoTime();
					Sort.shellsort(shapeList, byBaseArea);
					stop = System.nanoTime();
					break;
				default:
					throw new InvalidArgFormatException(compareType,sortType);
				}

				
				System.out.printf("Rank:  %5d   Type: %-20s                  Base Area: %25.2f \n", 1,
						shapeList[0].getName(), shapeList[0].getBaseArea());
				for (int i = 999; i < shapeList.length; i += 1000) {
					System.out.printf("Rank:  %5d   Type: %-20s                  Base Area: %25.2f \n", i + 1,
							shapeList[i].getName(), shapeList[i].getBaseArea());
				}
				System.out.printf("Rank:  %5d   Type: %-20s                  Base Area: %25.2f \n", shapeList.length,
						shapeList[shapeList.length - 1].getName(), shapeList[shapeList.length - 1].getBaseArea());
				System.out.println(
						"The time(nanosecond) for the " + sortName + " by " + sortBy + " is: " + (stop - start));

			} else if (compareType.equals("h")) {
				sortBy = "height";
				switch (sortType) {
				case "b":
					sortName = "Bubble Sort";
					start = System.nanoTime();
					Sort.bubbleSort(shapeList);
					stop = System.nanoTime();
					break;
				case "s":
					sortName = "Selection Sort";
					start = System.nanoTime();
					Sort.selectionSort(shapeList);
					stop = System.nanoTime();
					break;
				case "i":
					sortName = "Insertion Sort";
					start = System.nanoTime();
					Sort.insertionSort(shapeList);
					stop = System.nanoTime();
					break;
				case "m":
					sortName = "Merge Sort";
					start = System.nanoTime();
					Sort.mergeSort(shapeList, 0, shapeList.length - 1);
					stop = System.nanoTime();
					break;
				case "q":
					sortName = "Quicksort";
					start = System.nanoTime();
					Sort.quicksort(shapeList);
					stop = System.nanoTime();
					break;
				case "z":
					sortName = "Shell Sort(Custom Sort)";
					start = System.nanoTime();
					Sort.shellsort(shapeList);
					stop = System.nanoTime();
					break;
				default:
					throw new InvalidArgFormatException(compareType,sortType);
				}

				
				System.out.printf("Rank:  %5d   Type: %-20s                  Height: %25.2f \n", 1,
						shapeList[0].getName(), shapeList[0].getHeight());
				for (int i = 999; i < shapeList.length; i += 1000) {
					System.out.printf("Rank:  %5d   Type: %-20s                  Height: %25.2f \n", i + 1,
							shapeList[i].getName(), shapeList[i].getHeight());
				}
				System.out.printf("Rank:  %5d   Type: %-20s                  Height: %25.2f \n", shapeList.length,
						shapeList[shapeList.length - 1].getName(), shapeList[shapeList.length - 1].getHeight());
				System.out.println(
						"The time(nanosecond) for the " + sortName + " by " + sortBy + " is: " + (stop - start));

			}else {
				throw new InvalidArgFormatException(compareType,sortType);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found :"+filename);
			System.out.println("Please enter a correct filepath.");
		}

	}

}
