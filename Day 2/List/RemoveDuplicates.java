import java.util.*;

public class RemoveDuplicates {
    // Method to remove duplicates while preserving order
    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> result = removeDuplicates(numbers);
        System.out.println("List after removing duplicates: " + result);
    }
}
