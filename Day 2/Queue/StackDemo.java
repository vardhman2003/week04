import java.util.*;

class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Remove and return the top element
    public int pop() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");

        // Move elements except last from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int poppedElement = q1.remove(); // Last element in q1 is the top

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }

    // Return the top element without removing it
    public int top() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int topElement = q1.peek(); // Last element
        q2.add(q1.remove()); // Move it to q2

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class StackDemo {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top()); // Output: 3
        System.out.println("Popped Element: " + stack.pop()); // Output: 3
        System.out.println("Popped Element: " + stack.pop()); // Output: 2
    }
}
