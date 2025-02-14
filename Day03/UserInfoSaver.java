//3. Read User Input from Console
import java.io.*;

public class UserInfoSaver {
    public static void main(String[] args) {
        String filename = "user_info.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filename, true)) { // Append mode

            // Get user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Write to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            writer.write("-----------------------------\n");

            System.out.println("User information saved successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for age. Please enter a number.");
        }
    }
}
