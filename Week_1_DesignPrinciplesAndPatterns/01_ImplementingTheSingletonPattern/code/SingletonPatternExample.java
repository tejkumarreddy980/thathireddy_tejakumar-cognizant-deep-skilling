public class SingletonPatternExample {

    static class Logger {
        private static Logger instance;

        private Logger() {
            System.out.println("Logger Initialized");
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting application...");

        Logger logger2 = Logger.getInstance();
        logger2.log("Application is running.");

        if (logger1 == logger2) {
            System.out.println("Both loggers are the same instance.");
        } else {
            System.out.println("Different instances were created.");
        }
    }
}
