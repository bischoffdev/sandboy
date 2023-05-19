package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@Singleton
public class XmlParser {

    private final XmlMapper xmlMapper;
    private final SandboyLogger logger;

    @Inject
    public XmlParser(final SandboyLogger logger) {
        this.logger = logger;
        xmlMapper = new XmlMapper();
        xmlMapper.setVisibility(PropertyAccessor.ALL, NONE);
        xmlMapper.setVisibility(PropertyAccessor.FIELD, ANY);
        xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    public TestSuite xmlStringToTestSuite(final String xmlString) throws SandboyException {
        try {
            return xmlMapper.readValue(xmlString, TestSuite.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SandboyException("Could not map XML: " + e.getMessage());
        }
    }
}
