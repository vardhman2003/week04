package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@interface RoleAllowed {
    String value(); // Allowed role
}

// Step 2: Create a User Class to Simulate User Roles
class Users {
    private String role;

    public Users(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Define a Service with Role-Based Access Control
class SecureService {

    @RoleAllowed("ADMIN") // Restrict access to ADMIN role
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER") // Allow only USER role
    public void userTask() {
        System.out.println("User task executed successfully!");
    }

    public void publicTask() {
        System.out.println("Public task executed by anyone!");
    }
}

// Step 4: Access Control Logic Using Reflection
class AccessController {
    public static void invokeMethod(Object obj, String methodName, Users user) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                if (!annotation.value().equals(user.getRole())) {
                    System.out.println("Access Denied! " + user.getRole() + " cannot execute " + methodName);
                    return;
                }
            }

            // Invoke method if access is allowed
            method.invoke(obj);

        } catch (NoSuchMethodException e) {
            System.out.println("Method " + methodName + " not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Step 5: Test the Role-Based Access Control
public class RoleBasedAccessExample {
    public static void main(String[] args) {
        SecureService service = new SecureService();

        Users adminUser = new Users("ADMIN");
        Users normalUser = new Users("USER");
        Users guestUser = new Users("GUEST");

        // Testing access control
        System.out.println("Testing ADMIN user:");
        AccessController.invokeMethod(service, "adminTask", adminUser); // Allowed

        System.out.println("\nTesting USER user:");
        AccessController.invokeMethod(service, "adminTask", normalUser); // Denied
        AccessController.invokeMethod(service, "userTask", normalUser); // Allowed

        System.out.println("\nTesting GUEST user:");
        AccessController.invokeMethod(service, "adminTask", guestUser); // Denied
        AccessController.invokeMethod(service, "userTask", guestUser); // Denied
        AccessController.invokeMethod(service, "publicTask", guestUser); // Allowed
    }
}
