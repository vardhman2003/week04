import java.util.*;

public class NthFromEnd {
    // Find Nth element from end using two-pointer approach
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) return null; // If N is greater than list size
            fast.next();
        }

        // Move both pointers one step at a time
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next(); // Nth from the end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        String result = findNthFromEnd(list, n);
        System.out.println("Nth element from end: " + result);
    }
}

