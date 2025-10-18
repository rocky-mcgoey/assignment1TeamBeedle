package shape;

import java.util.Comparator;

public class AreaCompare implements Comparator<Shape> {
    /**
     * Compares the areas of the base of two shapes.
     * @param shape1 The first shape.
     * @param shape2 The second shape.
     * @return 100 if shape1's area is greater, -100 if shape2's area is greater, 0 if they are equal.
     */
	@Override
	public int compare( Shape shape1, Shape shape2 )
	{
		if( shape1.calcBaseArea() > shape2.calcBaseArea() )
		{
			return 100;
		}
		else if( shape1.calcBaseArea() < shape2.calcBaseArea() )
		{
			return -100;
		}
		else
		{
			return 0;
		}
	}

}
