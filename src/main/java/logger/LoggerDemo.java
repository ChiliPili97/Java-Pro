package logger;

public class LoggerDemo {
    public static void main(String[] args) {
        FileLogger fileLogger = new FileLogger(FileLoggerConfigurationLoader.load());

        for (int i = 0; i < 10; i++) {
            fileLogger.debug("some message " + i);
        }
    }
}
