import java.util.*;

public class RotateList {
    // Reverse a portion of the list
    private static <T> void reverse(List<T> list, int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    // Rotate the list by k positions
    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        if (n == 0 || k % n == 0) return; // No rotation needed
        k = k % n; // Normalize k

        reverse(list, 0, k - 1);
        reverse(list, k, n - 1);
        reverse(list, 0, n - 1);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;

        rotateList(numbers, k);
        System.out.println("Rotated List: " + numbers);
    }
}
