package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;
import blog.softwaretester.sandboy.xml.pojo.Testcase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class XmlParserTest {
    private XmlParser parser;

    @BeforeEach
    void setup() throws ParserConfigurationException {
        SandboyLogger logger = new SandboyLogger();
        parser = new XmlParser(logger);
    }

    @Test
    void parseValidPartialXML() throws SandboyException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><testsuite name=\"example.someTest\"><properties></properties></testsuite>";
        parser.xmlStringToTestSuite(xml);
    }

    @Test
    void parseValidFullXML() throws SandboyException {
        String xml = new FileIO().readContentFromFile("src/test/resources/example_report.xml");
        TestSuite testSuite = parser.xmlStringToTestSuite(xml);
        assertEquals(testSuite.getName(), "example.someTest");
        List<Testcase> testcases = testSuite.getTestcases();
        assertEquals(testcases.get(0).getName(), "Testcase number 1");
        assertEquals(testcases.get(1).getName(), "Testcase number 2");
        assertEquals(testcases.get(2).getName(), "Testcase number 3");
    }

    @Test
    void parseWrongXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        SandboyException exception = assertThrows(
                SandboyException.class,
                () -> parser.xmlStringToTestSuite(xml)
        );
        assertEquals("Could not map XML: Unexpected EOF in prolog\n" +
                " at [row,col {unknown-source}]: [1,38]", exception.getMessage());
    }
}