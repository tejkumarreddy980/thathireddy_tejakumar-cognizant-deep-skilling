Notification · JAVA
// Exercise 2: Implementing the Factory Method Pattern
// Scenario: A Course Notification system. Different notification types
// (Email, SMS, Push) are created via a Factory Method, so the client code
// never needs to know the concrete class being instantiated.
 
// Step 1: The Product interface
public interface Notification {
    void notifyUser(String message);
}
 
