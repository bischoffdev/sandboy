package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.rendering.ReportGenerator;
import blog.softwaretester.sandboy.xml.XmlParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SandboyEngineTest {

    private SandboyEngine engine;

    @BeforeEach
    public void setup() {
        SandboyLogger logger = new SandboyLogger();
        PropertyManager properties = new PropertyManager(logger);
        FileIO fileIO = new FileIO();
        XmlParser parser = new XmlParser();
        ReportGenerator reportGenerator = new ReportGenerator(properties, fileIO);
        engine = new SandboyEngine(logger, properties, fileIO, parser, reportGenerator);
    }

    @Test
    void invocation() throws SandboyException {
        SandboyException exception = assertThrows(
                SandboyException.class,
                () -> engine.build("", "")
        );
        assertEquals("File  does not exist!", exception.getMessage());
    }

    @Test
    void invocationWithRealData() throws SandboyException {
        engine.build("src/test/resources/example_report.xml", "target/sandboy");
    }
}