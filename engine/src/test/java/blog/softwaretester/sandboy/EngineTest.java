package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.filesystem.FileIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EngineTest {

    private Engine engine;

    @BeforeEach
    public void setup() {
        FileIO fileIO = Mockito.mock(FileIO.class);
        engine = new Engine(fileIO);
    }

    @Test
    void generateReport() {
        engine.generateReport();
    }
}