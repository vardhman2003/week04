package org.example.Annotations;

// Step 1: Define the Parent Class (Animal)
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound...");
    }
}

// Step 2: Create the Dog Class that Overrides makeSound()
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

// Step 3: Test Method Overriding
public class MethodOverridingExample {
    public static void main(String[] args) {
        Animal myAnimal = new Animal(); // Parent class object
        myAnimal.makeSound(); // Calls Animal's method

        Dog myDog = new Dog(); // Child class object
        myDog.makeSound(); // Calls overridden method in Dog class
    }
}
