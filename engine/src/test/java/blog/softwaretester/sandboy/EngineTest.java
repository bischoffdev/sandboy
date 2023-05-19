package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EngineTest {

    private SandboyEngine engine;

    @BeforeEach
    public void setup() {
        FileIO fileIO = Mockito.mock(FileIO.class);
        SandboyLogger logger = new SandboyLogger();
        engine = new SandboyEngine(fileIO, logger);
    }

    @Test
    void invocation() throws SandboyException {
        engine.build("", "");
    }
}