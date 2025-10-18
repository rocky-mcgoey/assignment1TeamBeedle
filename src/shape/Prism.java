package shape;

public abstract class Prism extends Shape
{
	//attribute
	private double side;
	
	//constructor
	public Prism(double height, double side)
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
	 * Calculates the volume of the shape. Uses the formula: base area * height
	 * @return The volume of the shape.
	 */
	@Override
	public double calcVolume ()
	{
		return calcBaseArea() * getHeight();
	}
}
