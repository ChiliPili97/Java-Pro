package logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileLoggerConfigurationLoaderTest {

    @Test
    void whenLoadConfigurationThenReturnValidConfiguration() {
        FileLoggerConfiguration configuration = FileLoggerConfigurationLoader.load();

        assertNotNull(configuration);
        assertEquals("log", configuration.getFileName());
        assertEquals(LoggingLevel.DEBUG, configuration.getLoggingLevels());
        assertEquals(150, configuration.getFileMaxSize());
        assertEquals(".txt", configuration.getFileFormat());
    }
}
