Notification · JAVA
// Step 2c: Concrete Product - Push Notification
public class PushNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("[PUSH] Sending push notification: " + message);
    }
}
 
