package problemdomain;

/**
 * This class defines the object type Shape and various properties such as the
 * height and radius and name of shape from the file reader of the RunSort.java
 * class.
 * 
 * @author Kin Shing Chong, Chirstian Lay, Alex Fleury, Brandon Donkersloot
 * @version 01/10/2021
 */
public class Shape implements Comparable<Shape> {

	private String name;
	private double height;
	private double radius;
	private double side;
	private double baseArea;
	private double volume;

	/**
	 * This method instantiates a Shape object and assigns it's properties as read
	 * from the file reader in the RunSort.java class. Depending on the name of the
	 * shape methods will be called to determine the radius, side, area, and volume
	 * of the shape.
	 * 
	 * @param name      The name of the shape
	 * @param firstNum  The height value of each shape object
	 * @param secondNum Based off the shape name, the second number will either be a
	 *                  assigned as a radius or side value
	 */
	public Shape(String name, double firstNum, double secondNum) {
		this.name = name;
		this.height = firstNum;
		this.radius = assignRadius(name, secondNum);
		this.side = assignSide(name, secondNum);
		this.baseArea = calcBaseArea(name);
		this.volume = calcVolume(name);
	}

	/**
	 * This method is called by Shape depending on the name and then assigns a radius value to the shape object.
	 * @param name is the type of shape
	 * @param secondNum is the numerical value that will be assigned as a radius
	 * @return value Depending on the shape the return value will be the set radius or invalid
	 */
	private double assignRadius(String name, double secondNum) {
		switch (this.name) {
		case "Cone":
			return secondNum;
		case "Cylinder":
			return secondNum;
		case "Pyramid":
			return -1;
		case "SquarePrism":
			return -1;
		case "TriangularPrism":
			return -1;
		case "PentagonalPrism":
			return -1;
		case "OctagonalPrism":
			return -1;
		}
		return 0;
	}
	
	/**
	 * This method is called by Shape depending on the name and then assigns a side value to the shape object.
	 * @param name is the type of shape
	 * @param secondNum is the numerical value that will be assigned as a side
	 * @return depending on the shape, the return value will be the set side or invalid.
	 */
	private double assignSide(String name, double secondNum) {
		switch (name) {
		case "Cone":
			return -1;
		case "Cylinder":
			return -1;
		case "Pyramid":
			return secondNum;
		case "SquarePrism":
			return secondNum;
		case "TriangularPrism":
			return secondNum;
		case "PentagonalPrism":
			return secondNum;
		case "OctagonalPrism":
			return secondNum;
		}
		return 0;
	}

	/**
	 * This method is called by Shape depending on the name and then calculates a base area value that is then assigned to the shape object.
	 * @param name is the type of shape
	 * @return the calculated base area value
	 */
	private double calcBaseArea(String name) {
		double baseArea;
		switch (name) {
		case "Cone":
			baseArea = Math.PI * this.radius * this.radius;
			return baseArea;
		case "Cylinder":
			baseArea = Math.PI * this.radius * this.radius;
			return baseArea;
		case "Pyramid":
			baseArea = this.side * this.side;
			return baseArea;
		case "SquarePrism":
			baseArea = this.side * this.side;
			return baseArea;
		case "TriangularPrism":
			baseArea = ((this.side * this.side) * Math.sqrt(3)) / 4;
			return baseArea;
		case "PentagonalPrism":
			baseArea = (5 * (this.side * this.side) * Math.tan(Math.toRadians(54))) / 4;
			return baseArea;
		case "OctagonalPrism":
			baseArea = 2 * (1 + Math.sqrt(2)) * (this.side * this.side);
			return baseArea;
		}
		return 0;
	}	

	/**
	 * This method is called by Shape depending on the name and then calculates a volume value that is then assigned to the shape object.
	 * @param name is the type of shape
	 * @return the calculated volume value
	 */
	private double calcVolume(String name) {
		double volume;
		switch (name) {
		case "Cone":
			volume = (1.0 / 3) * this.baseArea * this.height;
			return volume;
		case "Cylinder":
			volume = this.baseArea * this.height;
			return volume;
		case "Pyramid":
			volume = (1.0 / 3) * (this.baseArea * this.height);
			return volume;
		case "SquarePrism":
			volume = this.baseArea * this.height;
			return volume;
		case "TriangularPrism":
			volume = this.baseArea * this.height;
			return volume;
		case "PentagonalPrism":
			volume = this.baseArea * this.height;
			return volume;
		case "OctagonalPrism":
			volume = this.baseArea * this.height;
			return volume;
		}
		return 0;
	}

	@Override
	public int compareTo(Shape that) {
		if (this.height > that.height) {
			return 1;
		} else if (this.height < that.height) {
			return -1;
		} else // Height == Height
		{
			return 0;
		}
	}

	@Override
	public String toString() {
		return ("Type:" + this.name + " Height:" + this.height + " Radius:" + this.radius + " Side:" + this.side
				+ " Base Area:" + this.baseArea + " Volume" + this.volume);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getBaseArea() {
		return baseArea;
	}

	public void setBaseArea(double baseArea) {
		this.baseArea = baseArea;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

}
