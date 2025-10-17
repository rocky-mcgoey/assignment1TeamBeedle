package shape;

public class Cone extends Shape
{
	//attribute
	private double radius;
	
	//constructor
	public Cone(double height, double radius)
	{
		super(height);
		this.radius = radius;
		
	}
	
	//getter
	public double getRadius()
	{
		return radius;
	}

	@Override
	public double calcVolume()
	{
		// TODO Auto-generated method stub
		return calcBaseArea() * getHeight() / 3;
	}

	@Override
	public double calcBaseArea()
	{
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}
	
	@Override
	public String toString() {
		return String.format("This is a Cone with\n"
			+ "height: %f\n"
			+ "radius: %f\n"
			+ "base area: %f\n"
			+ "Volume: %f\n", 
			this.getHeight(), this.getRadius(), this.calcBaseArea(), this.calcVolume());
	}

}
