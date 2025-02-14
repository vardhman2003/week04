//7. Data Streams - Store and Retrieve Primitive Data

import java.io.*;
import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDataHandler {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            for (int i = 0; i < numStudents; i++) {
                System.out.println("Enter details for Student " + (i + 1));
                System.out.print("Roll Number: ");
                int rollNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("GPA: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                // Write student details to file
                dos.writeInt(rollNumber);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }
            System.out.println("Student details saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read student details from file
        System.out.println("\nRetrieving Student Details from File:");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}
