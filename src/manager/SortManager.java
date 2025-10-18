package manager;

import shape.*;
import utility.CommandLineParser;
import utility.ConsoleDisplay;
import utility.ShapeFileReader;
import utility.Sort;

import java.util.*;

public class SortManager
{
	private String fileName;
	private char compareType;
	private char sortType;

	public SortManager(String[] args)
	{
		// old
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		
		
		// new
		CommandLineParser parser = new CommandLineParser(args);
        
        if (parser.hasErrors())
        {
            System.err.println(parser.getErrorMessage());
            return;
        }
        
        fileName = parser.getFileName();
        compareType = parser.getCompareType();
        sortType = parser.getSortType();
		
//		for (String arg : args)
//		{
//			if (arg.startsWith("-f") || arg.startsWith("-F"))
//			{
//				fileName = arg.substring(2);
//				
//			}
//			else if(arg.startsWith("-t") || arg.startsWith("-T"))
//			{
//				compareType = arg.substring(2).charAt(0);
//			}
//			else if(arg.startsWith("-s") || arg.startsWith("-S"))
//			{
//				sortType = arg.substring(3).charAt(0);
//			}
//		}
		System.out.println("File Name is" + fileName);
		System.out.println("Compare Type is" + compareType);
		System.out.println("Sort Type is" + sortType);
		// TODO Auto-generated constructor stub
		
		// Read shapes from file
        ShapeFileReader reader = new ShapeFileReader();
        Shape[] shapes = reader.readShapes(fileName);
        
        if (shapes == null)
        {
            System.err.println(reader.getErrorMessage());
            return;
        }
        
        System.out.println("Successfully loaded " + shapes.length + " shapes from file.");
        
        // Perform the sort
        runSort(shapes, sortType, compareType);
	}
	
	/**
	 * Runs one complete sorting operation on an array of shape objects
	 * 1. Chooses which attribute to sort by based on users input
	 * 
	 * 2. creates the correct Comparator to compare shape objects in the descending order.
	 * 
	 * 3. calls the chosen sorting algorithm to sort the array
	 * 
	 * 4. measures how long the sorting takes, not including file I/O
	 *
	 * 
	 * @param shapes the array of shape objects to be sorted
	 * @param sortType the letter that indicates which sorting algorithm to use
	 * @param sortBy the letter that indicates what property to sort by
	 */
	public static void runSort(Shape[] shapes, char sortType, char sortBy)
	{
		Comparator<Shape> cmp = null;
		switch(Character.toLowerCase(sortBy))
		{
		case 'h':
			cmp = (s1, s2) -> Double.compare(s2.getHeight(), s1.getHeight());
			break;
		case 'v':
			cmp = (s1, s2) -> Double.compare(s2.calcVolume(), s1.calcVolume());
			break;
		case 'a':
			cmp = (s1, s2) -> Double.compare(s2.calcBaseArea(), s1.calcBaseArea());
			break;
		default:
			System.out.println("Not a valid option for comparison. Use h, v, or a.");
			return;
		}
		
		long start = System.nanoTime();
		
		switch (Character.toLowerCase(sortType))
		{
		case 'b':
			Sort.bubbleSort(shapes, cmp);
			break;
		case 'i':
			Sort.insertionSort(shapes, cmp);
			break;
		case 's':
			Sort.selectionSort(shapes, cmp);
			break;
		case 'm':
			Sort.mergeSort(shapes, cmp);
			break;
		case 'q':
			Sort.quickSort(shapes, cmp);
			break;
		case 'z':
			Sort.heapSort(shapes, cmp);
			break;
		default:
			System.out.println("Not a valid option for sort type. Use b,i, s, m , q, or z.");
			return;
		}
		
		long end = System.nanoTime();
		long time = (end - start) / 1000000;
		
		// Display results
        String sortName = ConsoleDisplay.getSortName(sortType);
        ConsoleDisplay.displayResults(shapes, sortBy, sortName, time);
	}
	
	

}
