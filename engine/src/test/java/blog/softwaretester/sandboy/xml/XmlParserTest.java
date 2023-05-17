package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.xml.pojo.TestSuite;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlParserTest {
    private XmlParser parser;

    @BeforeEach
    void setup() throws ParserConfigurationException {
        parser = new XmlParser();
    }

    @Test
    void parseValidXML() throws JsonProcessingException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><testsuite name=\"example.someTest\"><properties></properties></testsuite>";
        TestSuite testSuite = parser.xmlStringToTestSuite(xml);
        assertEquals(testSuite.name, "example.someTest");
    }
}