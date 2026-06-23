 Exercise 1: Implementing the Singleton Pattern
// Scenario: A DatabaseConnection class that must have exactly ONE instance
// shared across the entire application (common real-world use case for Singleton).

public class DatabaseConnection {

    // The single instance, marked volatile so changes are visible across threads
    private static volatile DatabaseConnection instance;

    private String connectionId;
    private static int connectionCount = 0;

    // Private constructor prevents instantiation from outside the class
    private DatabaseConnection() {
        connectionCount++;
        this.connectionId = "DB-CONN-" + connectionCount;
        System.out.println("Creating new DatabaseConnection instance: " + connectionId);
    }

    // Thread-safe lazy initialization using double-checked locking
    public static DatabaseConnection getInstance() {
        if (instance == null) {                      // first check (no locking)
            synchronized (DatabaseConnection.class) {
                if (instance == null) {               // second check (with locking)
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println(connectionId + " => Connected to database.");
    }

    public void query(String sql) {
        System.out.println(connectionId + " => Executing query: " + sql);
    }

    public String getConnectionId() {
        return connectionId;
    }
}
