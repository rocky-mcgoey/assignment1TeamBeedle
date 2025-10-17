package shape;

public class PentagonalPrism extends Prism
{
	//constructor
	public PentagonalPrism(double height, double side)
	{
		super(height, side);
		
	}

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
