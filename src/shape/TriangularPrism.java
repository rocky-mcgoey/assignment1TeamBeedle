package shape;

public class TriangularPrism extends Prism
{
	//constructor
	public TriangularPrism(double height, double side)
	{
		super(height, side);
		
	}

	/**
	 * Calculates the base area of the shape. uses the formula: (side^2 * sqrt(3)) / 4
	 * @return The base area of the shape.
	 */
	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return ((side * side) * Math.sqrt(3)) / 4.0;
	}

	@Override
	public String toString() {
		return String.format("This is a Triangular Prism with\n"
				+ "height: %f\n"
				+ "side length: %f\n"
				+ "base area: %f\n"
				+ "Volume: %f\n", 
				this.getHeight(), this.getSide(), this.calcBaseArea(), this.calcVolume());
	}
}
