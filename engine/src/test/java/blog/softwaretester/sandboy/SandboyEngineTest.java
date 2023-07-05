package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.rendering.PageGenerator;
import blog.softwaretester.sandboy.rendering.ReportGenerator;
import blog.softwaretester.sandboy.rendering.visitors.HomepageVisitor;
import blog.softwaretester.sandboy.rendering.visitors.VisitorDirectory;
import blog.softwaretester.sandboy.templates.TemplateFactory;
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
        TemplateFactory templateFactory = new TemplateFactory();
        PageGenerator pageGenerator = new PageGenerator(fileIO, templateFactory, properties);
        HomepageVisitor homepageVisitor = new HomepageVisitor(pageGenerator);
        VisitorDirectory visitorDirectory = new VisitorDirectory(homepageVisitor);
        ReportGenerator reportGenerator = new ReportGenerator(properties, fileIO, visitorDirectory);
        engine = new SandboyEngine(logger, properties, fileIO, parser, reportGenerator);
    }

    @Test
    void invocation() {
        SandboyException exception = assertThrows(
                SandboyException.class,
                () -> engine.build("nonExistingPath", "")
        );
        assertEquals("Unable to find XML files in nonExistingPath!", exception.getMessage());
    }

    @Test
    void invocationWithRealDataSingleFile() throws SandboyException {
        engine.build("src/test/resources/real.xml", "target/sandboy");
    }

    @Test
    void invocationWithRealDataFolder() throws SandboyException {
        engine.build("src/test/resources", "target/sandboy");
    }

    @Test
    void invocationWithEmptyFolders() throws SandboyException {
        SandboyException exception = assertThrows(
                SandboyException.class,
                () -> engine.build("", "")
        );
        assertEquals("Could not create directory ''.", exception.getMessage());
    }
}