package blog.softwaretester.sandboy.filesystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    private FileIO fileIO;

    @BeforeEach
    void setup() {
        fileIO = new FileIO();
    }

    @Test
    void readNonExistingFile() {
        Exception exception = assertThrows(
                Exception.class,
                () -> fileIO.readContentFromFile("nonExistentFile")
        );
        assertEquals("File nonExistentFile does not exist!", exception.getMessage());
    }

    @Test
    void readExistingFile() throws Exception {
        String contents = fileIO.readContentFromFile("src/test/resources/example_report.xml");
        assertTrue(contents.startsWith("<?xml"));
    }
}