import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageConverter {
    public static void main(String[] args) {
        String sourceFile = "source.jpg";  // Change to your image file
        String destinationFile = "copy.jpg";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(sourceFile);

            // Write byte array back to an image file
            writeByteArrayToImage(imageBytes, destinationFile);

            // Verify files are identical
            if (verifyFiles(sourceFile, destinationFile)) {
                System.out.println("Success: The copied image is identical to the original.");
            } else {
                System.out.println("Error: The copied image is not identical.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Convert image file to byte array
    private static byte[] convertImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Write byte array to a new image file
    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Verify if the original and copied files are identical
    private static boolean verifyFiles(String file1, String file2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(new File(file1).toPath());
        byte[] file2Bytes = Files.readAllBytes(new File(file2).toPath());
        return Arrays.equals(file1Bytes, file2Bytes);
    }
}
