import java.io.*;

public class UpperToLowerFileConverter {
    public static void main(String[] args) {
        String sourceFile = "input.txt";  // Change to your source file
        String destinationFile = "output.txt";  // Output file

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());  // Convert to lowercase
                writer.newLine();  // Preserve line breaks
            }

            System.out.println("File converted successfully. Check " + destinationFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
