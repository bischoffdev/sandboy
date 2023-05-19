package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;
import blog.softwaretester.sandboy.xml.pojo.Testcase;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlParserTest {
    private XmlParser parser;

    @BeforeEach
    void setup() throws ParserConfigurationException {
        SandboyLogger logger = new SandboyLogger();
        parser = new XmlParser(logger);
    }

    @Test
    void parseValidPartialXML() throws JsonProcessingException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><testsuite name=\"example.someTest\"><properties></properties></testsuite>";
        parser.xmlStringToTestSuite(xml);
    }

    @Test
    void parseValidFullXML() throws Exception, SandboyException {
        String xml = new FileIO().readContentFromFile("src/test/resources/example_report.xml");
        TestSuite testSuite = parser.xmlStringToTestSuite(xml);
        assertEquals(testSuite.getName(), "example.someTest");
        List<Testcase> testcases = testSuite.getTestcases();
        assertEquals(testcases.get(0).getName(), "Testcase number 1");
        assertEquals(testcases.get(1).getName(), "Testcase number 2");
        assertEquals(testcases.get(2).getName(), "Testcase number 3");
    }

    @Test
    void parseWrongXML() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        parser.xmlStringToTestSuite(xml);
    }
}