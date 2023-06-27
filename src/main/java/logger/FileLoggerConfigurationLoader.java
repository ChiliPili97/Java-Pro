package logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load() {

        String fileName;
        String fileFormat;
        LoggingLevel loggingLevel;
        int fileMaxSize;

        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("D:\\MyProjects\\Java Pro\\homework\\src\\main\\resources\\config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fileName = prop.getProperty("FILE");
        fileFormat = prop.getProperty("FORMAT");
        loggingLevel = LoggingLevel.valueOf(prop.getProperty("LEVEL"));
        fileMaxSize = Integer.parseInt(prop.getProperty("MAX-SIZE"));

        return new FileLoggerConfiguration(fileName, fileFormat, loggingLevel, fileMaxSize);
    }
}
