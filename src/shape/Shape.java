package shape;

public abstract class Shape implements Comparable<Shape>
{
	//attributes
	private double height;
	
	// constructor
	public Shape(double height)
	{
		this.height = height;
	}
	
	//getter (accessor)
	public double getHeight()
	{
		return height;
	}
	
	/**
     * Compares the height of two shapes.
     * @param shape1 The first shape.
     * @param shape2 The second shape.
     * @return 1 if this height is greater, -1 if that height is greater, 0 if they are equal.
     */
	@Override
	public int compareTo(Shape that)
	{
		if (this.height < that.height) return -1;
		if (this.height > that.height) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("This is a Shape with height: %d", this.getHeight());
	}

	/**
	 * Calculates the volume of the shape.
	 * @return The volume of the shape.
	 */
	public abstract double calcVolume();
	
	/**
	 * Calculates the base area of the shape.
	 * @return The base area of the shape.
	 */
	public abstract double calcBaseArea();
	
}
