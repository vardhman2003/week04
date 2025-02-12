// Abstract base class for all warehouse items
import java.util.*;
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item: " + name;
    }
}

// Electronics class extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

// Groceries class extending WarehouseItem
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

// Furniture class extending WarehouseItem
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

// Generic class for storage with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    // Add an item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Retrieve an item from storage by index
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    // Get the list of all items
    public List<T> getAllItems() {
        return items;
    }
}

// Utility class for displaying items
class StorageUtil {
    // Method with wildcard to display all items in any storage
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class
public class SmartHouseManagement {
    public static void main(String[] args) {
        // Create storage for different types of items
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to storage
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Rice"));

        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Display items using wildcard method
        System.out.println("Electronics Storage:");
        StorageUtil.displayItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries Storage:");
        StorageUtil.displayItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture Storage:");
        StorageUtil.displayItems(furnitureStorage.getAllItems());
    }
}
