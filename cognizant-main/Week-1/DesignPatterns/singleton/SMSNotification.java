// Step 2b: Concrete Product - SMS
public class SMSNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[SMS] Sending SMS notification: " + message);
    }
}
 
