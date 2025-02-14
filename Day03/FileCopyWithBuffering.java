import java.io.*;

public class FileCopyWithBuffering {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";
        String destinationFileBuffered = "destination_buffered.dat";
        String destinationFileUnbuffered = "destination_unbuffered.dat";
        int bufferSize = 4096;

        // Measure time for Buffered Streams
        long startTimeBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile), bufferSize);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered), bufferSize)) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered file copy completed.");
        } catch (IOException e) {
            System.out.println("Error copying file with buffering: " + e.getMessage());
        }
        long endTimeBuffered = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (endTimeBuffered - startTimeBuffered) + " ns");

        // Measure time for Unbuffered Streams
        long startTimeUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Unbuffered file copy completed.");
        } catch (IOException e) {
            System.out.println("Error copying file without buffering: " + e.getMessage());
        }
        long endTimeUnbuffered = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (endTimeUnbuffered - startTimeUnbuffered) + " ns");
    }
}
