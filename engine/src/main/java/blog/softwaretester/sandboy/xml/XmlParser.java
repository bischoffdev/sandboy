package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.xml.pojo.TestSuite;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

public class XmlParser {

    private final XmlMapper xmlMapper;

    public XmlParser() {
        xmlMapper = new XmlMapper();
        xmlMapper.setVisibility(PropertyAccessor.ALL, NONE);
        xmlMapper.setVisibility(PropertyAccessor.FIELD, ANY);
        xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    public TestSuite xmlStringToTestSuite(final String xmlString) throws JsonProcessingException {
        return xmlMapper.readValue(xmlString, TestSuite.class);
    }
}
