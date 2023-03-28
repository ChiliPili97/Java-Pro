package homeWork10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load() {

        String fileName;
        String fileFormat;
        LoggingLevel loggingLevels;
        int fileMaxSize;

        try (InputStream is = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(is);

            fileName = prop.getProperty("FILE");
            fileFormat = prop.getProperty("FORMAT");
            loggingLevels = LoggingLevel.valueOf(prop.getProperty("LEVEL").toUpperCase());
            fileMaxSize = Integer.parseInt(prop.getProperty("MAX-SIZE"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new FileLoggerConfiguration(fileName, fileFormat, loggingLevels, fileMaxSize);
    }
}
