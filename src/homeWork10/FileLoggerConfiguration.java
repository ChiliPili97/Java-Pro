package homeWork10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfiguration {

    private String fileName;
    private String fileFormat;
    private LoggingLevel loggingLevels;
    private int fileMaxSize;

    public FileLoggerConfiguration(String fileName, String fileFormat, LoggingLevel loggingLevels, int fileMaxSize) {
        this.fileName = fileName;
        this.fileFormat = fileFormat;
        this.loggingLevels = loggingLevels;
        this.fileMaxSize = fileMaxSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public LoggingLevel getLoggingLevels() {
        return loggingLevels;
    }

    public void setLoggingLevels(LoggingLevel loggingLevels) {
        this.loggingLevels = loggingLevels;
    }

    public int getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(int fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }

    public boolean isDebugEnable() {
        if (this.loggingLevels == LoggingLevel.DEBUG) {
            return true;
        }
        return false;
    }
}
