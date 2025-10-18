package shape;

public class OctagonalPrism extends Prism
{
	//constructor
	public OctagonalPrism(double height, double side)
	{
		super(height, side);
		
	}

	/**
	 * Calculates the base area of the shape. uses the formula: 2 * (1 + sqrt(2)) * (side^2)
	 * @return The base area of the shape.
	 */
	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return 2 * (1 + Math.sqrt(2)) * (side * side); 
	}

	@Override
		public String toString() {
			return String.format("This is a Octagonal Prism with\n"
				+ "height: %f\n"
				+ "side length: %f\n"
				+ "base area: %f\n"
				+ "Volume: %f\n", 
				this.getHeight(), this.getSide(), this.calcBaseArea(), this.calcVolume());
	}


}
