import java.util.*;

// Base interface for meal plans
interface MealPlan {
    String getDescription();
}

// Specific meal plan types
class VegetarianMeal implements MealPlan {
    public String getDescription() { return "Vegetarian Meal"; }
}

class VeganMeal implements MealPlan {
    public String getDescription() { return "Vegan Meal"; }
}

class KetoMeal implements MealPlan {
    public String getDescription() { return "Keto Meal"; }
}

class HighProteinMeal implements MealPlan {
    public String getDescription() { return "High-Protein Meal"; }
}

// Generic class for meal management
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }

    public String toString() {
        return meal.getDescription();
    }
}

// Utility class for dynamic meal generation
class MealPlanUtil {
    public static <T extends MealPlan> Meal<T> generateMeal(T meal) {
        // Validation logic can be added here
        return new Meal<>(meal);
    }

    public static void displayMeals(List<? extends MealPlan> meals) {
        meals.forEach(meal -> System.out.println(meal.getDescription()));
    }
}

// Main class
public class mealPlanGenerator {
    public static void main(String[] args) {
        // Generate personalized meal plans
        Meal<VegetarianMeal> vegetarian = MealPlanUtil.generateMeal(new VegetarianMeal());
        Meal<VeganMeal> vegan = MealPlanUtil.generateMeal(new VeganMeal());
        Meal<KetoMeal> keto = MealPlanUtil.generateMeal(new KetoMeal());
        Meal<HighProteinMeal> highProtein = MealPlanUtil.generateMeal(new HighProteinMeal());

        // Create a catalog of meal plans
        List<MealPlan> catalog = Arrays.asList(
            vegetarian.getMeal(),
            vegan.getMeal(),
            keto.getMeal(),
            highProtein.getMeal()
        );

        // Display available meal plans
        MealPlanUtil.displayMeals(catalog);
    }
}
