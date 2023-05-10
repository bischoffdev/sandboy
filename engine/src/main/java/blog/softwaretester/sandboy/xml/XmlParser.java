package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.xml.pojo.Report;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.xml.XMLConstants;

public class XmlParser {

    private SAXBuilder sax;

    public XmlParser() {
        sax = new SAXBuilder();
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
    }

    public Report parseXmlReport(final Element root) {
        return new Report();
    }
}
