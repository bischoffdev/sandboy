package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;

class XmlParserTest {
    private XmlParser parser;

    @BeforeEach
    void setup() throws ParserConfigurationException {
        parser = new XmlParser();
    }

    @Test
    void parseValidPartialXML() throws JsonProcessingException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><testsuite name=\"example.someTest\"><properties></properties></testsuite>";
        TestSuite testSuite = parser.xmlStringToTestSuite(xml);
        //assertEquals(testSuite.getName(), "example.someTest");
    }

    @Test
    void parseValidFullXML() throws Exception {
        String xml = new FileIO().readContentFromFile("src/test/resources/example_report.xml");
        TestSuite testSuite = parser.xmlStringToTestSuite(xml);
        System.out.println(testSuite);
        //assertEquals(testSuite.getName(), "example.someTest");
    }

}