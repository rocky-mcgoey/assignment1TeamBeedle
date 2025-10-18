package shape;

public class Pyramid extends Shape
{
	//attribute
	private double side;
	
	//constructor
	public Pyramid(double height, double side)
	{
		super(height);
		this.side = side;
		
	}

	//getter
	public double getSide()
	{
		return side;
	}
	
	/**
	 * Calculates the volume of the shape. Uses the formula: (base area * height) / 3
	 * @return The volume of the shape.
	 */
	@Override
	public double calcVolume ()
	{
		return calcBaseArea() * getHeight() / 3;
	}
	
	/**
	 * Calculates the base area of the shape. uses the formula: side^2
	 * @return The base area of the shape.
	 */
	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return  side * side;
	}

	@Override
	public String toString() {
		return String.format("This is a Pyramid with\n"
			+ "height: %f\n"
			+ "side length: %f\n"
			+ "base area: %f\n"
			+ "Volume: %f\n", 
			this.getHeight(), this.getSide(), this.calcBaseArea(), this.calcVolume());
	}
}
