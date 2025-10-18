package shape;

public class PentagonalPrism extends Prism
{
	//constructor
	public PentagonalPrism(double height, double side)
	{
		super(height, side);
		
	}

	/**
	 * Calculates the base area of the shape. uses the formula: (5 * (side^2) * tan(54degrees)) /4
	 * @return The base area of the shape.
	 */
	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return  (5 * (side * side) * Math.tan(Math.toRadians(54))) /4;
	}

	@Override
		public String toString() {
			return String.format("This is a Pentagonal Prism with\n"
				+ "height: %f\n"
				+ "side length: %f\n"
				+ "base area: %f\n"
				+ "Volume: %f\n", 
				this.getHeight(), this.getSide(), this.calcBaseArea(), this.calcVolume());
	}

}
