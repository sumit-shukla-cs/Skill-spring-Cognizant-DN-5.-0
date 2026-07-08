public class Exercise01_SingletonLoggerDemo {
    public static void main(String[] args) {
        AppLoggerSingleton firstLogger = AppLoggerSingleton.getInstance();
        AppLoggerSingleton secondLogger = AppLoggerSingleton.getInstance();

        System.out.println("Same instance: " + (firstLogger == secondLogger));
        System.out.println("First logger hash: " + System.identityHashCode(firstLogger));
        System.out.println("Second logger hash: " + System.identityHashCode(secondLogger));

        firstLogger.log("Application started");
        secondLogger.log("Logging from the same singleton instance");
    }
}

final class AppLoggerSingleton {
    private static volatile AppLoggerSingleton instance;

    private AppLoggerSingleton() {
    }

    public static AppLoggerSingleton getInstance() {
        if (instance == null) {
            synchronized (AppLoggerSingleton.class) {
                if (instance == null) {
                    instance = new AppLoggerSingleton();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOGGER] " + message);
    }
}