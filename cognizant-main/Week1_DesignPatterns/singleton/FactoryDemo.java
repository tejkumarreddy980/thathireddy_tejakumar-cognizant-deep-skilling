torydemo · JAVA
// Demo / test class for the Factory Method pattern.
 
public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("---- Factory Method Pattern Demo ----");
 
        Notification email = NotificationFactory.createNotification("EMAIL");
        email.notifyUser("Your enrollment in Java FSE Deep Skilling is confirmed.");
 
        Notification sms = NotificationFactory.createNotification("SMS");
        sms.notifyUser("Reminder: SME connect session at 5 PM today.");
 
        Notification push = NotificationFactory.createNotification("PUSH");
        push.notifyUser("New hands-on exercise has been posted.");
 
        System.out.println();
        System.out.println("Class of email object: " + email.getClass().getSimpleName());
        System.out.println("Class of sms object:   " + sms.getClass().getSimpleName());
        System.out.println("Class of push object:  " + push.getClass().getSimpleName());
 
        // Demonstrate invalid input handling
        try {
            NotificationFactory.createNotification("FAX");
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("Expected error caught: " + e.getMessage());
        }
    }
}
