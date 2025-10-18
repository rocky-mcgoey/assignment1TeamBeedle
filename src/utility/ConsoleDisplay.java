package utility;

import shape.*;

/**
 * Utility class to display sorted shape results in the required format.
 * Displays the first element, every 1000th element, and the last element
 * along with their comparison values (height, volume, or area).
 */
public class ConsoleDisplay {
    
    /**
     * Displays the sorted shapes according to the comparison type.
     * Shows first element, every 1000th element, and last element.
     * 
     * @param shapes The sorted array of shapes
     * @param compareType The type of comparison used ('h', 'v', or 'a')
     * @param sortName The name of the sorting algorithm used
     * @param timeInMillis The time taken to sort in milliseconds
     */
    public static void displayResults(Shape[] shapes, char compareType, String sortName, long timeInMillis) {
        if (shapes == null || shapes.length == 0) {
            System.out.println("No shapes to display.");
            return;
        }
        
        String comparisonLabel = getComparisonLabel(compareType);
        
        
        System.out.printf("First element is:%40s%20s: %.10g%n", 
            shapes[0].getClass().getName(), 
            comparisonLabel, 
            getComparisonValue(shapes[0], compareType));
        
       
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.printf("%d-th element:%40s%20s: %.10g%n", 
                i, 
                shapes[i].getClass().getName(), 
                comparisonLabel, 
                getComparisonValue(shapes[i], compareType));
        }
        
       
        System.out.printf("Last element is:%40s%20s: %.10g%n", 
            shapes[shapes.length - 1].getClass().getName(), 
            comparisonLabel, 
            getComparisonValue(shapes[shapes.length - 1], compareType));
        
        // Display timing
        System.out.printf("%s run time was: %d milliseconds%n", sortName, timeInMillis);
    }
    
    /**
     * Gets the appropriate label for the comparison type.
     * @param compareType The comparison type character
     * @return The label string
     */
    private static String getComparisonLabel(char compareType) {
        switch (Character.toLowerCase(compareType)) {
            case 'h':
                return "Height";
            case 'v':
                return "Volume";
            case 'a':
                return "Area";
            default:
                return "Value";
        }
    }
    
    /**
     * Gets the comparison value from a shape based on the comparison type.
     * @param shape The shape to get the value from
     * @param compareType The comparison type character
     * @return The comparison value
     */
    private static double getComparisonValue(Shape shape, char compareType) {
        switch (Character.toLowerCase(compareType)) {
            case 'h':
                return shape.getHeight();
            case 'v':
                return shape.calcVolume();
            case 'a':
                return shape.calcBaseArea();
            default:
                return 0.0;
        }
    }
    
    /**
     * Gets a human-readable name for the sort algorithm.
     * @param sortType The sort type character
     * @return The sort algorithm name
     */
    public static String getSortName(char sortType) {
        switch (Character.toLowerCase(sortType)) {
            case 'b':
                return "Bubble Sort";
            case 'i':
                return "Insertion Sort";
            case 's':
                return "Selection Sort";
            case 'm':
                return "Merge Sort";
            case 'q':
                return "Quick Sort";
            case 'z':
                return "Heap Sort"; 
            default:
                return "Unknown Sort";
        }
    }
}