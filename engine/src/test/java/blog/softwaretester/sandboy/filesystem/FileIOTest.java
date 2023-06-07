package blog.softwaretester.sandboy.filesystem;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    private FileIO fileIO;

    @BeforeEach
    void setup() {
        SandboyLogger logger = new SandboyLogger();
        fileIO = new FileIO(logger);
    }

    @Test
    void readNonExistingFile() {
        SandboyException exception = assertThrows(
                SandboyException.class,
                () -> fileIO.readContentFromFile("nonExistentFile")
        );
        assertEquals("File nonExistentFile does not exist!", exception.getMessage());
    }

    @Test
    void readExistingFile() throws SandboyException {
        String contents = fileIO.readContentFromFile("src/test/resources/example_report.xml");
        assertTrue(contents.startsWith("<?xml"));
    }
}