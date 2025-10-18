package shape;

public class SquarePrism extends Prism
{
	//constructor
	public SquarePrism(double height, double side)
	{
		super(height, side);
		
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
			return String.format("This is a Square Prism with\n"
				+ "height: %f\n"
				+ "side length: %f\n"
				+ "base area: %f\n"
				+ "Volume: %f\n", 
				this.getHeight(), this.getSide(), this.calcBaseArea(), this.calcVolume());
	}
}
