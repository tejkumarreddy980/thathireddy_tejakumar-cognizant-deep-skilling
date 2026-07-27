// Step 3: The Factory class containing the Factory Method.
// Client code calls createNotification() and never uses "new EmailNotification()" etc. directly.
 
public class NotificationFactory {
 
    // The Factory Method
    public static Notification createNotification(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }
 
        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
 
