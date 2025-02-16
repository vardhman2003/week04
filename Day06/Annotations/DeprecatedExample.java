package com.capgeminitraining.day6.Annotations;

// Step 1: Define a Class with an Old and a New Method
class LegacyAPI {

    // Marking oldFeature() as deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: oldFeature() is deprecated. Use newFeature() instead.");
    }

    // New recommended method
    public void newFeature() {
        System.out.println("Using the newFeature() method.");
    }
}

// Step 2: Test the Deprecated Method
public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // Calling the deprecated method (should show a warning)
        api.oldFeature();

        // Calling the new method
        api.newFeature();
    }
}

