import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Product Price Storage
    private Map<String, Integer> cart = new LinkedHashMap<>(); // Maintains order of addition
    private TreeMap<Double, List<String>> priceSortedItems = new TreeMap<>(); // Sorts by price

    // Add a product with its price
    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    // Add product to cart
    public void addToCart(String name, int quantity) {
        if (!productPrices.containsKey(name)) {
            System.out.println("Product not found: " + name);
            return;
        }
        
        cart.put(name, cart.getOrDefault(name, 0) + quantity);
        
        // Store in TreeMap for price-based sorting
        double price = productPrices.get(name);
        priceSortedItems.computeIfAbsent(price, k -> new ArrayList<>()).add(name);
    }

    // Get cart items in order added
    public Map<String, Integer> getCartInOrder() {
        return cart;
    }

    // Get cart items sorted by price
    public Map<Double, List<String>> getItemsSortedByPrice() {
        return priceSortedItems;
    }

    // Calculate total price of items in cart
    public double getTotalPrice() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.8);
        cart.addProduct("Orange", 1.2);

        // Adding to cart
        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 3);
        cart.addToCart("Orange", 1);

        // Display results
        System.out.println("Cart in Order: " + cart.getCartInOrder());
        System.out.println("Items Sorted by Price: " + cart.getItemsSortedByPrice());
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}
