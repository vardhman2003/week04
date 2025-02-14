import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ErrorLogReader {

    public static void main(String[] args) {
        // Specify the path to the large text file
        String filePath = "path_to_large_log_file.txt"; // Replace with your file path
        
        // Open the file and read it line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the word "error" (case-insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line); // Print the line if it contains "error"
                }
            }
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        }
    }
}
