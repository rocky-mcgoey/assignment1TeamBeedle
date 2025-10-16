package shape;

public class SquarePrism extends Prism
{
	//constructor
	public SquarePrism(double height, double side)
	{
		super(height, side);
		
	}

	@Override
	public double calcBaseArea()
	{
		double side = getSide();
		return  side * side;
	}

}
