package blog.softwaretester.sandboy.xml;

import blog.softwaretester.sandboy.xml.pojo.Report;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.xml.XMLConstants;
import java.util.List;

public class XmlParser {

    private SAXBuilder sax;

    public XmlParser() {
        sax = new SAXBuilder();
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
    }

    public Report parseXmlReport(final Document document) {
        try {
            Element rootElement = document.getRootElement();

            int testsRun = Integer.parseInt(rootElement.getAttributeValue("tests"));
            int testsPassed = Integer.parseInt(rootElement.getAttributeValue("passed"));
            int testsFailed = Integer.parseInt(rootElement.getAttributeValue("failures"));

            System.out.println("Tests run: " + testsRun);
            System.out.println("Tests passed: " + testsPassed);
            System.out.println("Tests failed: " + testsFailed);

            // Get the test cases
            List<Element> testCases = rootElement.getChildren("testcase");
            for (Element testCase : testCases) {
                String className = testCase.getAttributeValue("classname");
                String testName = testCase.getAttributeValue("name");
                double timeTaken = Double.parseDouble(testCase.getAttributeValue("time"));
                String status = "passed";

                // Check if the test failed
                Element failure = testCase.getChild("failure");
                if (failure != null) {
                    status = "failed";
                }

                System.out.println(className + "." + testName + " (" + timeTaken + "s): " + status);
            }
        } catch (Exception e) {
            System.out.println("FAILURE: " + e.getMessage());
        }
        return new Report();
    }
}
