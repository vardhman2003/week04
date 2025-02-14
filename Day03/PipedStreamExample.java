import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamExample {
    
    // Writer Thread: Writes data into PipedOutputStream
    static class WriterThread extends Thread {
        private PipedOutputStream pipedOutputStream;

        public WriterThread(PipedOutputStream pipedOutputStream) {
            this.pipedOutputStream = pipedOutputStream;
        }

        @Override
        public void run() {
            try {
                String data = "Hello from WriterThread!";
                pipedOutputStream.write(data.getBytes());
                pipedOutputStream.close(); // Close the output stream after writing
                System.out.println("WriterThread: Data written.");
            } catch (IOException e) {
                System.err.println("WriterThread: IOException - " + e.getMessage());
            }
        }
    }

    // Reader Thread: Reads data from PipedInputStream
    static class ReaderThread extends Thread {
        private PipedInputStream pipedInputStream;

        public ReaderThread(PipedInputStream pipedInputStream) {
            this.pipedInputStream = pipedInputStream;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                int length = pipedInputStream.read(buffer);
                String data = new String(buffer, 0, length);
                System.out.println("ReaderThread: Data read - " + data);
                pipedInputStream.close(); // Close the input stream after reading
            } catch (IOException e) {
                System.err.println("ReaderThread: IOException - " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        try {
            // Connect the output stream to the input stream
            pipedOutputStream.connect(pipedInputStream);
        } catch (IOException e) {
            System.err.println("Main: IOException - " + e.getMessage());
            return;
        }

        // Create and start the WriterThread
        Thread writerThread = new WriterThread(pipedOutputStream);
        writerThread.start();

        // Create and start the ReaderThread
        Thread readerThread = new ReaderThread(pipedInputStream);
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join(); // Wait for threads to finish execution
        } catch (InterruptedException e) {
            System.err.println("Main: InterruptedException - " + e.getMessage());
        }
    }
}
