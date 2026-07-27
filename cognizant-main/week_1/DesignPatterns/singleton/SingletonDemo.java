// Demo / test class for the Singleton pattern.
// Proves that getInstance() always returns the SAME object reference.
 
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("---- Singleton Pattern Demo ----");
 
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        conn1.connect();
        conn1.query("SELECT * FROM students");
 
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        conn2.query("SELECT * FROM courses");
 
        System.out.println();
        System.out.println("conn1 id: " + conn1.getConnectionId());
        System.out.println("conn2 id: " + conn2.getConnectionId());
        System.out.println("conn1 == conn2 ? " + (conn1 == conn2));
 
        if (conn1 == conn2) {
            System.out.println("SUCCESS: Both references point to the same Singleton instance.");
        } else {
            System.out.println("FAILURE: Singleton was broken — two instances exist.");
        }
    }
}
 
