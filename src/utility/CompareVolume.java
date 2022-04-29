package utility;

import java.util.Comparator;

import problemdomain.Shape;
/**
 * This class contains the compare method override that the Sort class methods call in order to compare volume values.
 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
 * @version 01/10/2021
 */
public class CompareVolume  implements Comparator<Shape> {
	/**
	 * This method has two object parameters that then get compared
	 * @param s1 first shape
	 * @param s2 second shape
	 * @return value is based off of the comparison between shapes (1 if s1 is greater than s2; -1 if s1 is smaller than s2; 0 if s1 equals s2)
	 */
	@Override
	public int compare(Shape s1, Shape s2) {
		if( s1.getVolume() > s2.getVolume() )
		{
			return 1;
		}
		else if( s1.getVolume() < s2.getVolume() )
		{
			return -1;
		}
		else //Volume == Volume
		{
			return 0;
		}
		
	}

}
