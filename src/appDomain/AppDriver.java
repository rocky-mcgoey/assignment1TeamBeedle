package appDomain;

import manager.SortManager;
import shape.*;
/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * F2025 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)
		Shape t = new TriangularPrism(4, 3);
		System.out.println(t.toString());
		Shape s = new SquarePrism(4, 3);
		System.out.println(s.toString());
		Shape p = new PentagonalPrism(4, 3);
		System.out.println(p.toString());
		Shape o = new OctagonalPrism(4, 3);
		System.out.println(o.toString());
		Shape c = new Cone(4, 3);
		System.out.println(c.toString());
		Shape b = new Cylinder(4, 3);
		System.out.println(b.toString());
		Shape py = new Pyramid(4, 3);
		System.out.println(py.toString());
		//new SortManager(args); // UNCOMMENT WHEN IM DONE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

}
