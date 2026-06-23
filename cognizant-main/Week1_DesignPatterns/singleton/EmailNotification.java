// Step 2a: Concrete Product - Email
public class EmailNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[EMAIL] Sending email notification: " + message);
    }
}
 
