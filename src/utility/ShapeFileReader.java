package utility;

import shape.*;
import java.io.*;

/**
 * Utility class to read shape data from a text file and create an array of Shape objects.
 */
public class ShapeFileReader {
    
    private String errorMessage;
    
    public ShapeFileReader() {
        errorMessage = "";
    }
    
    /**
     * Reads shapes from a file and returns an array of Shape objects.
     * @param fileName The path to the file containing shape data
     * @return An array of Shape objects, or null if an error occurs
     */
    public Shape[] readShapes(String fileName) {
        BufferedReader reader = null;
        Shape[] shapes = null;
        
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                errorMessage = "Error: File '" + fileName + "' not found.\n" +
                              "Please check the file path and try again.";
                return null;
            }
            
            reader = new BufferedReader(new FileReader(file));
            
            // Read the first line to get the number of shapes
            String firstLine = reader.readLine();
            if (firstLine == null || firstLine.trim().isEmpty()) {
                errorMessage = "Error: File is empty or invalid format.\n" +
                              "The first line should contain the number of shapes.";
                return null;
            }
            
            int numShapes;
            try {
                numShapes = Integer.parseInt(firstLine.trim());
            } catch (NumberFormatException e) {
                errorMessage = "Error: Invalid number format in first line: '" + firstLine + "'\n" +
                              "The first line should contain an integer representing the number of shapes.";
                return null;
            }
            
            if (numShapes <= 0) {
                errorMessage = "Error: Number of shapes must be greater than 0. Found: " + numShapes;
                return null;
            }
            
            shapes = new Shape[numShapes];
            
            // Read each shape
            for (int i = 0; i < numShapes; i++) {
                String line = reader.readLine();
                if (line == null) {
                    errorMessage = "Error: File ended prematurely.\n" +
                                  "Expected " + numShapes + " shapes but only found " + i + ".";
                    return null;
                }
                
                Shape shape = parseShape(line, i + 2); // Line number for error reporting (first line is 1, shapes start at 2)
                if (shape == null) {
                    return null; // Error message already set in parseShape
                }
                
                shapes[i] = shape;
            }
            
        } catch (IOException e) {
            errorMessage = "Error: Unable to read file '" + fileName + "'.\n" +
                          "Reason: " + e.getMessage();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Ignore close errors
                }
            }
        }
        
        return shapes;
    }
    
    /**
     * Parses a single line from the file and creates the appropriate Shape object.
     * @param line The line to parse
     * @param lineNumber The line number (for error reporting)
     * @return A Shape object, or null if parsing fails
     */
    private Shape parseShape(String line, int lineNumber) {
        if (line == null || line.trim().isEmpty()) {
            errorMessage = "Error: Empty line found at line " + lineNumber + ".";
            return null;
        }
        
        String[] parts = line.trim().split("\\s+");
        
        if (parts.length < 3) {
            errorMessage = "Error: Invalid format at line " + lineNumber + ".\n" +
                          "Expected format: ShapeType height value\n" +
                          "Found: " + line;
            return null;
        }
        
        String shapeType = parts[0];
        double height;
        double secondValue;
        
        try {
            height = Double.parseDouble(parts[1]);
            secondValue = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            errorMessage = "Error: Invalid number format at line " + lineNumber + ".\n" +
                          "Line: " + line;
            return null;
        }
        
        // Create the appropriate shape based on type
        try {
            switch (shapeType.toLowerCase()) {
                case "cylinder":
                    return new Cylinder(height, secondValue);
                    
                case "cone":
                    return new Cone(height, secondValue);
                    
                case "pyramid":
                    return new Pyramid(height, secondValue);
                    
                case "squareprism":
                    return new SquarePrism(height, secondValue);
                    
                case "triangularprism":
                    return new TriangularPrism(height, secondValue);
                    
                case "pentagonalprism":
                    return new PentagonalPrism(height, secondValue);
                    
                case "octagonalprism":
                    return new OctagonalPrism(height, secondValue);
                    
                default:
                    errorMessage = "Error: Unknown shape type '" + shapeType + "' at line " + lineNumber + ".\n" +
                                  "Valid types: Cylinder, Cone, Pyramid, SquarePrism, TriangularPrism, PentagonalPrism, OctagonalPrism";
                    return null;
            }
        } catch (Exception e) {
            errorMessage = "Error: Failed to create shape at line " + lineNumber + ".\n" +
                          "Reason: " + e.getMessage();
            return null;
        }
    }
    
    /**
     * Gets the error message if reading failed.
     * @return The error message, or empty string if no error
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}