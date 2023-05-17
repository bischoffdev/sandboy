package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.xml.pojo.TestSuite;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlParser {

    private final XmlMapper xmlMapper;

    public XmlParser() {
        xmlMapper = new XmlMapper();
    }

    public TestSuite xmlStringToTestSuite(final String xmlString) throws JsonProcessingException {
        TestSuite testSuite = xmlMapper.readValue(xmlString, TestSuite.class);
        System.out.println(testSuite);
        return testSuite;
    }
}
