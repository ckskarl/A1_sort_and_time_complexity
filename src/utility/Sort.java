package utility;

import java.util.*;

/**
 * This class contains all the sort methods that can be called by the RunSort
 * class which are determined by user input from the AppDriver class.
 * 
 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
 * @version 01/10/2021
 */
public class Sort {
	/**
	 * Bubble Sort method that uses the Comparable method to determine which array
	 * number is larger then calls the swap method to arrange the correct order of
	 * elements in the array.
	 * 
	 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array of shape objects that are then compared based on
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				// compares the two numbers side to side, if the number is larger it is moved to
				// the left
				if (array[j].compareTo(array[j - 1]) > 0) {
					swap(array, j, j - 1);
				}
			}
		}
	}

	/**
	 * Bubble sort method that implements the Comparator method to determine which
	 * array number is larger, then calls the swap method to arrange the correct
	 * order of elements in the array.
	 * 
	 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array of generic objects that allows the comparison between shape
	 *              objects
	 * @param comp  comparator object
	 */
	public static <T> void bubbleSort(T[] array, Comparator<? super T> comp) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {

				// compares the two numbers side to side, if the number is larger it is moved to
				// the left
				if (comp.compare(array[j], array[j - 1]) > 0) {
					swap(array, j, j - 1);
				}
			}
		}
	}

	/**
	 * Swap method which is called by the bubbleSort method that rearranges the
	 * generic array elements from right element to left, and left element to right.
	 * 
	 * @param <T>        generic objects that allows the comparison between shape
	 *                   objects
	 * @param array      of generic objects from the bubbleSort method
	 * @param leftIndex  left element in the array
	 * @param rightIndex right element in the array
	 */
	private static <T> void swap(T[] array, int leftIndex, int rightIndex) {
		T temp;
		temp = array[leftIndex];
		array[leftIndex] = array[rightIndex];
		array[rightIndex] = temp;

	}

	/**
	 * Selection sort method that implements the Comparable class to directly
	 * compare two shapes from the shapeList array.
	 * 
	 * @author Alex Fleury
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array of shapes from the RunSort method
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
		int max;
		for (int i = 0; i < array.length; i++) {
			max = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[max]) > 0) {
					max = j;
				}
			}
			if (max != i) {
				final T temp = array[i];
				array[i] = array[max];
				array[max] = temp;
			}
		}
	}

	/**
	 * Selection sort method that implements the Comparator interface to directly
	 * compare two shapes from the shapeList array.
	 * 
	 * @author Alex Fleury
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 * @param comp  comparator object
	 */
	public static <T> void selectionSort(T[] array, Comparator<? super T> comp) {
		int max;
		for (int i = 0; i < array.length; i++) {
			max = i;
			for (int j = i + 1; j < array.length; j++) {
				if (comp.compare(array[j], array[max]) > 0) {
					max = j;
				}
			}
			if (max != i) {
				final T temp = array[i];
				array[i] = array[max];
				array[max] = temp;
			}
		}
	}

	/**
	 * Insertion sort method that implements the Comparable interface to directly
	 * compare two shapes from the shapeList array.
	 * 
	 * @author Brandon Donkersloot
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
		T index;
		for (int i = 1; i < array.length; i++) {
			index = array[i];
			int count = i;
			boolean sorted = false;
			while (!sorted) {
				if (count == 0) {
					array[count] = index;
					sorted = true;
				} else {
					if (index.compareTo(array[count - 1]) > 0) {
						array[count] = array[count - 1];
						count--;
					} else {
						array[count] = index;
						sorted = true;
					}
				}
			}
		}
	}

	/**
	 * Insertion sort method that implements the Comparator interface to directly
	 * compare two shapes from the shapeList array.
	 * 
	 * @author Brandon Donkersloot
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 * @param comp  Comparator object
	 */
	public static <T> void insertionSort(T[] array, Comparator<? super T> comp) {
		T index;
		for (int i = 1; i < array.length; i++) {
			index = array[i];
			int count = i;
			boolean sorted = false;
			while (!sorted) {
				if (count == 0) {
					array[count] = index;
					sorted = true;
				} else {
					if (comp.compare(index, array[count - 1]) > 0) {
						array[count] = array[count - 1];
						count--;
					} else {
						array[count] = index;
						sorted = true;
					}
				}
			}
		}
	}

	/**
	 * Merge sort method that implements the Comparable interface to directly
	 * compare two shapes from the shapeList array.
	 * 
	 * @author Kin Shing Chong
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 * @param low   lowest element in the array
	 * @param high  highest element in the array
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] array, int low, int high) {
		if (high <= low) {
			return;
		}

		int mid = (low + high) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);
		merge(array, low, mid, high);
	}

	/**
	 * Merge method that implements the Comparable interface to directly compare two
	 * shapes from the shapeList array called by the mergeSort method.
	 * 
	 * @author Kin Shing Chong
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 * @param low   lowest element in the array
	 * @param mid   middle element determined by the mergeSort method
	 * @param high  highest element in the array
	 */
	private static <T extends Comparable<? super T>> void merge(T[] array, int low, int mid, int high) {
		@SuppressWarnings("unchecked")
		T[] tempLeftArray = (T[]) new Comparable[mid - low + 1];
		@SuppressWarnings("unchecked")
		T[] tempRightArray = (T[]) new Comparable[high - mid];

		for (int i = 0; i < tempLeftArray.length; i++) {
			tempLeftArray[i] = array[low + i];
		}
		for (int i = 0; i < tempRightArray.length; i++) {
			tempRightArray[i] = array[mid + i + 1];
		}

		int leftIndex = 0;
		int rightIndex = 0;

		for (int i = low; i < high + 1; i++) {
			if (leftIndex < tempLeftArray.length && rightIndex < tempRightArray.length) {
				if (tempLeftArray[leftIndex].compareTo(tempRightArray[rightIndex]) > 0) {
					array[i] = tempLeftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = tempRightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < tempLeftArray.length) {
				array[i] = tempLeftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < tempRightArray.length) {
				array[i] = tempRightArray[rightIndex];
				rightIndex++;
			}
		}
	}

	/**
	 * Merge sort method that implements the Comparator interface to directly
	 * compare two shapes from the shapeList array.
	 * 
	 * @author Kin Shing Chong
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 * @param low   lowest element in the array
	 * @param high  highest element in the array
	 * @param comp  Comparator obkje
	 */
	public static <T> void mergeSort(T[] array, int low, int high, Comparator<? super T> comp) {
		if (high <= low) {
			return;
		}

		int mid = (low + high) / 2;
		mergeSort(array, low, mid, comp);
		mergeSort(array, mid + 1, high, comp);
		merge(array, low, mid, high, comp);

	}

	/**
	 * Merge method that implements the Comparator interface to directly compare two
	 * shapes from the shapeList array called by the mergeSort method.
	 * 
	 * @author Kin Shing Chong
	 * @param <T>generic objects that allows the comparison between shape objects
	 * @param array      generic objects that allows the comparison between shape
	 *                   objects
	 * @param low        lowest element in the array
	 * @param mid        middle element determined by the mergeSort method
	 * @param high       highest element in the array
	 * @param comp       Comparator object
	 */
	private static <T> void merge(T[] array, int low, int mid, int high, Comparator<? super T> comp) {
		@SuppressWarnings("unchecked")
		T[] tempLeftArray = (T[]) new Comparable[mid - low + 1];
		@SuppressWarnings("unchecked")
		T[] tempRightArray = (T[]) new Comparable[high - mid];

		for (int i = 0; i < tempLeftArray.length; i++) {
			tempLeftArray[i] = array[low + i];
		}
		for (int i = 0; i < tempRightArray.length; i++) {
			tempRightArray[i] = array[mid + i + 1];
		}

		int leftIndex = 0;
		int rightIndex = 0;

		for (int i = low; i < high + 1; i++) {
			if (leftIndex < tempLeftArray.length && rightIndex < tempRightArray.length) {
				if (comp.compare(tempLeftArray[leftIndex], tempRightArray[rightIndex]) > 0) {
					array[i] = tempLeftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = tempRightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < tempLeftArray.length) {
				array[i] = tempLeftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < tempRightArray.length) {
				array[i] = tempRightArray[rightIndex];
				rightIndex++;
			}
		}

	}

	/**
	 * Quick Sort method called by the RunSort class that implements the Comparable
	 * class and determines the length of the array which is then passed into the
	 * quicksort method to sort the array.
	 * 
	 * @author Christian Lay
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 */
	public static <T extends Comparable<? super T>> void quicksort(T[] array) {
		quicksort(array, 0, array.length - 1);
	}

	/**
	 * Quick sort method that uses the array length to determine the pivot point
	 * that allows the array to be sorted. Implements the Comparable class.
	 * 
	 * @author Christian Lay
	 * @param <T>        generic objects that allows the comparison between shape
	 *                   objects
	 * @param array      generic objects that allows the comparison between shape
	 *                   objects
	 * @param leftIndex  first array position
	 * @param rightIndex last array position
	 */
	public static <T extends Comparable<? super T>> void quicksort(T[] array, int leftIndex, int rightIndex) {
		// stops the recursion when left is greater then or equal to right index
		if (leftIndex >= rightIndex) {
			return;
		}
		// choose the middle of the array to be pivot
		T pivot = array[(leftIndex + rightIndex) / 2];

		// gets index of partition (dividing array into smaller array)
		int index = partition(array, leftIndex, rightIndex, pivot);

		// divides array into smaller sub arrays
		quicksort(array, leftIndex, index - 1);
		quicksort(array, index, rightIndex);

	}

	/**
	 * Quick sort method that uses the pivot point to compare values, then swap
	 * positions into correct locations. Implements the Comparable class. Calls the
	 * swap method to arrange elements.
	 * 
	 * @author Christian Lay
	 * @param <T>        generic objects that allows the comparison between shape
	 *                   objects
	 * @param array      generic objects that allows the comparison between shape
	 *                   objects
	 * @param leftIndex  start of array segment
	 * @param rightIndex end of array segment
	 * @param pivot      middle position of the array
	 * @return index
	 */
	public static <T extends Comparable<? super T>> int partition(T[] array, int leftIndex, int rightIndex, T pivot) {
		while (leftIndex <= rightIndex) {
			// gets index of element smaller then pivot
			while (array[leftIndex].compareTo(pivot) > 0) {
				leftIndex++;
			}
			// gets index of element larger then pivot
			while (array[rightIndex].compareTo(pivot) < 0) {
				rightIndex--;
			}

			// swaps the two index
			if (leftIndex <= rightIndex) {
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}
		return leftIndex;
	}

	/**
	 * Quick sort method that finds the length of array. Implements the Comparator
	 * class.
	 * 
	 * @author Christian Lay
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 * @param comp  comparator object
	 */
	public static <T> void quicksort(T[] array, Comparator<? super T> comp) {
		quicksort(array, 0, array.length - 1, comp);
	}

	/**
	 * Quick sort method that uses a pivot point in order to sort a array of values.
	 * Implements the Comparator method.
	 * 
	 * @author Christian Lay
	 * @param <T>        generic objects that allows the comparison between shape
	 *                   objects
	 * @param array      generic objects that allows the comparison between shape
	 *                   objects
	 * @param leftIndex  start of array
	 * @param rightIndex end of array
	 * @param comp       Comparator object
	 */
	public static <T> void quicksort(T[] array, int leftIndex, int rightIndex, Comparator<? super T> comp) {
		// stops the recursion when left is greater then or equal to right index
		if (leftIndex >= rightIndex) {
			return;
		}
		// choose the middle of the array to be pivot
		T pivot = array[(leftIndex + rightIndex) / 2];

		// gets index of partition (dividing array into smaller array)
		int index = partition(array, leftIndex, rightIndex, pivot, comp);

		// divides array into smaller sub arrays
		quicksort(array, leftIndex, index - 1, comp);
		quicksort(array, index, rightIndex, comp);

	}

	/**
	 * method to sort the partitioned sub array from the initial quicksort method.
	 * Implements the comparator class. Calls the swap method to arrange elements.
	 * 
	 * @author Christian Lay
	 * @param <T>        generic objects that allows the comparison between shape
	 *                   objects
	 * @param array      generic objects that allows the comparison between shape
	 *                   objects
	 * @param leftIndex  start of partitioned array
	 * @param rightIndex end of partitioned array
	 * @param pivot      middle index in the partitioned array
	 * @param comp       comparator object
	 * @return left index 
	 */
	public static <T> int partition(T[] array, int leftIndex, int rightIndex, T pivot, Comparator<? super T> comp) {
		while (leftIndex <= rightIndex) {
			// gets index of element smaller then pivot
			while (comp.compare(array[leftIndex], pivot) > 0) {
				leftIndex++;
			}
			// gets index of element larger then pivot
			while (comp.compare(array[rightIndex], pivot) < 0) {
				rightIndex--;
			}

			// swaps the two index
			if (leftIndex <= rightIndex) {
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}
		return leftIndex;
	}
	
	/**
	 * shellsort method that divides the array into smaller and smaller sections
	 * while comparing the elements and swap them to the correct position.
	 * Implements the Comparable class. Calls the swap method to arrange elements.
	 * 
	 * @author Brandon Donkersloot
	 * @param <T>   generic objects that allows the comparison between shape objects
	 * @param array generic objects that allows the comparison between shape objects
	 */
	public static <T extends Comparable<? super T>> void shellsort(T[] array) {

		int gap = array.length / 2;
		while (gap > 0) {
			int gap2 = gap;
			int i = 0;
			while (gap2 != array.length) {
				if (array[gap2].compareTo(array[i]) > 0) {
					swap(array, gap2, i);
					int counter1 = i;
					int counter2 = i - gap;
					while (counter2 >= 0) {
						if (array[counter1].compareTo(array[counter2]) > 0) {
							swap(array, counter1, counter2);
						}
						counter2 -= gap;
						counter1 -= gap;
					}
				}
				i++;
				gap2++;
			}
			gap /= 2;
		}
	}

	/**
	 * shellsort method that divides the array into smaller and smaller sections
	 * while comparing the elements and swap them to the correct position.
	 * Implements the Comparator class. Calls the swap method to arrange elements.
	 * 
	 * @author Brandon Donkersloot
	 * @param <T> the generic type parameter
	 * @param array generic array type that allows the comparison between shape objects
	 * @param comp Comparator to implement the compare algorithm
	 */
	public static <T> void shellsort(T[] array, Comparator<? super T> comp) {

		int gap = array.length / 2;
		while (gap > 0) {
			int gap2 = gap;
			int i = 0;
			while (gap2 != array.length) {
				if (comp.compare(array[gap2], array[i]) > 0) {
					swap(array, gap2, i);
					int counter1 = i;
					int counter2 = i - gap;
					while (counter2 >= 0) {
						if (comp.compare(array[counter1], array[counter2]) > 0) {
							swap(array, counter1, counter2);
						}
						counter2 -= gap;
						counter1 -= gap;
					}
				}
				i++;
				gap2++;
			}
			gap /= 2;
		}
	}

}
