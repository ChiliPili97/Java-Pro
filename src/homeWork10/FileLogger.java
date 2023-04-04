package homeWork10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String msg) {
        if (config.isDebugEnable()) {
            log(msg, LoggingLevel.DEBUG);
        } else {
            System.out.println("This method is not available for your logger configuration");
        }
    }

    public void info(String msg) {
        log(msg, LoggingLevel.INFO);
    }

    private void log(String msg, LoggingLevel loggingLevel) {
        File file = new File(config.getFileName() + config.getFileFormat());

        if (file.length() >= config.getFileMaxSize()) {
            file = new File(config.getFileName() + getTimestamp() + config.getFileFormat());
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //throw new FileMaxSizeReachedException("Max file size: %d of file: %s, size of your file: %d"
             //       .formatted(config.getFileMaxSize(), file.getName(), file.length()));
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("[%s] [%s] Message:[%s]\n".formatted(getTimestamp(), loggingLevel.toString(), msg));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTimestamp() {
        LocalDateTime localTime = LocalDateTime.now();
        return localTime.format(DateTimeFormatter.ofPattern("HH-mm-ss"));
    }
}
