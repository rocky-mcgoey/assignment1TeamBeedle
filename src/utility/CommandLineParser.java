package utility;

/**
 * Utility class to parse command-line arguments for the sorting application.
 * Handles -f (file), -t (compare type), and -s (sort type) arguments in a
 * case-insensitive and order-insensitive manner.
 */
public class CommandLineParser {
    
    private String fileName;
    private char compareType;
    private char sortType;
    private boolean hasErrors;
    private String errorMessage;
    
    /**
     * Parses the command-line command.
     * @param args The command-line arguments from main method
     */
    public CommandLineParser(String[] args) {
        hasErrors = false;
        errorMessage = "";
        
        if (args == null || args.length == 0) {
            hasErrors = true;
            errorMessage = "Error: No command-line arguments provided.\n" +
                          "Usage: java -jar Sort.jar -f<filename> -t<type> -s<sort>\n" +
                          "  -f: file name and path (required)\n" +
                          "  -t: compare type - h (height), v (volume), a (area) (required)\n" +
                          "  -s: sort type - b (bubble), i (insertion), s (selection), m (merge), q (quick), z (choice) (required)";
            return;
        }
        
        parseArguments(args);
        validateArguments();
    }
    
    /**
     * Parses aruments from command line, order insensitive
     * @param args The command-line arguments
     */
    private void parseArguments(String[] args) {
        for (String arg : args) {
            if (arg == null || arg.length() < 3) {
                continue; // Skip invalid arguments, will be caught in validation
            }
            
            String argLower = arg.toLowerCase();
            
            if (argLower.startsWith("-f")) {
                fileName = arg.substring(2).trim();
                // Remove quotes if present
                if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
                    fileName = fileName.substring(1, fileName.length() - 1);
                }
            } else if (argLower.startsWith("-t")) {
                String typeStr = arg.substring(2).trim();
                if (typeStr.length() > 0) {
                    compareType = Character.toLowerCase(typeStr.charAt(0));
                }
            } else if (argLower.startsWith("-s")) {
                String sortStr = arg.substring(2).trim();
                if (sortStr.length() > 0) {
                    sortType = Character.toLowerCase(sortStr.charAt(0));
                }
            } else {
                hasErrors = true;
                errorMessage = "Error: Invalid argument '" + arg + "'.\n" +
                              "Valid arguments are -f, -t, and -s (case insensitive).";
                return;
            }
        }
    }
    
    /**
     * Validates that all required arguments are present and valid.
     */
    private void validateArguments() {
        if (hasErrors) return; 
        
        // Check if fileName argument is present
        if (fileName == null || fileName.isEmpty()) {
            hasErrors = true;
            errorMessage = "Error: File name is required.\n" +
                          "Use -f followed by the file name (e.g., -fshapes1.txt or -f\"C:\\temp\\shapes1.txt\")";
            return;
        }
        
        // Check if compareType is valid
        if (compareType == '\0') {
            hasErrors = true;
            errorMessage = "Error: Compare type is required.\n" +
                          "Use -t followed by: h (height), v (volume), or a (area)\n" +
                          "Example: -th or -tv or -ta";
            return;
        }
        
        if (compareType != 'h' && compareType != 'v' && compareType != 'a') {
            hasErrors = true;
            errorMessage = "Error: Invalid compare type '" + compareType + "'.\n" +
                          "Valid options are: h (height), v (volume), a (area)";
            return;
        }
        
        // Check if sortType is valid
        if (sortType == '\0') {
            hasErrors = true;
            errorMessage = "Error: Sort type is required.\n" +
                          "Use -s followed by: b (bubble), i (insertion), s (selection), m (merge), q (quick), z (your choice)\n" +
                          "Example: -sb or -si or -sm";
            return;
        }
        
        if (sortType != 'b' && sortType != 'i' && sortType != 's' && 
            sortType != 'm' && sortType != 'q' && sortType != 'z') {
            hasErrors = true;
            errorMessage = "Error: Invalid sort type '" + sortType + "'.\n" +
                          "Valid options are: b (bubble), i (insertion), s (selection), m (merge), q (quick), z (your choice)";
            return;
        }
    }
    
    /**
     * Gets the parsed file name.
     * @return The file name
     */
    public String getFileName() {
        return fileName;
    }
    
    /**
     * Gets the parsed compare type.
     * @return The compare type character
     */
    public char getCompareType() {
        return compareType;
    }
    
    /**
     * Gets the parsed sort type.
     * @return The sort type character
     */
    public char getSortType() {
        return sortType;
    }
    
    /**
     * Checks if there were any parsing errors.
     * @return true if errors exist, false otherwise
     */
    public boolean hasErrors() {
        return hasErrors;
    }
    
    /**
     * Gets the error message if any errors occurred.
     * @return The error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}