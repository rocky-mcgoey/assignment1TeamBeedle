package shape;

import java.util.Comparator;

public class VolumeCompare implements Comparator<Shape> {
    /**
     * Compares the volumes of two shapes.
     * @param shape1 The first shape.
     * @param shape2 The second shape.
     * @return 100 if shape1's volume is greater, -100 if shape2's volume is greater, 0 if they are equal.
     */
	@Override
	public int compare( Shape shape1, Shape shape2 )
	{
		if( shape1.calcVolume() > shape2.calcVolume() )
		{
			return 100;
		}
		else if( shape1.calcVolume() < shape2.calcVolume() )
		{
			return -100;
		}
		else
		{
			return 0;
		}
	}

}
