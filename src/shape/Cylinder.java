package shape;

public class Cylinder extends Shape
{
	//attribute
	private double radius;
	
	//constructor
	public Cylinder(double height, double radius)
	{
		super(height);
		this.radius = radius;
		
	}
	
	//getter
	public double getRadius()
	{
		return radius;
	}

	/**
	 * Calculates the volume of the shape. Uses the formula: base area * height
	 * @return The volume of the shape.
	 */
	@Override
	public double calcVolume()
	{
		return calcBaseArea() * getHeight();
	}

	/**
	 * Calculates the base area of the shape. uses the formula: π * radius^2
	 * @return The base area of the shape.
	 */
	@Override
	public double calcBaseArea()
	{
		return Math.PI * radius * radius;
	}
	
	@Override
	public String toString() {
		return String.format("This is a Cylinder with\n"
			+ "height: %f\n"
			+ "radius: %f\n"
			+ "base area: %f\n"
			+ "Volume: %f\n", 
			this.getHeight(), this.getRadius(), this.calcBaseArea(), this.calcVolume());
	}


}
