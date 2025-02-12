import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    // Constructor to initialize buffer of given size
    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Insert element (overwrite oldest if full)
    public void insert(int value) {
        rear = (rear + 1) % size; // Move rear forward (circular)
        buffer[rear] = value;

        if (count < size) {
            count++; // Increase count if buffer not full
        } else {
            front = (front + 1) % size; // Overwrite oldest element
        }
    }

    // Get buffer contents
    public int[] getBuffer() {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = buffer[(front + i) % size];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [1, 2, 3]

        cb.insert(4); // Overwrites 1
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [2, 3, 4]

        cb.insert(5); // Overwrites 2
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [3, 4, 5]
    }
}
