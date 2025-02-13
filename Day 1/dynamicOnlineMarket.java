import java.util.*;

// Base product class with generic type for category
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String toString() { return name + " (" + category + "): $" + price; }
}

// Generic method to apply a discount
class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}

// Main class
public class dynamicOnlineMarket {
    public static void main(String[] args) {
        // Define categories
        String bookCategory = "Book";
        String clothingCategory = "Clothing";
        String gadgetCategory = "Gadget";

        // Create product catalog
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(new Product<>("Book A", 20.0, bookCategory));
        catalog.add(new Product<>("Shirt", 15.0, clothingCategory));
        catalog.add(new Product<>("Smartphone", 200.0, gadgetCategory));

        // Apply discounts
        DiscountUtil.applyDiscount(catalog.get(0), 10); // 10% discount on Book A
        DiscountUtil.applyDiscount(catalog.get(2), 15); // 15% discount on Smartphone

        // Display catalog
        catalog.forEach(System.out::println);
    }
}
