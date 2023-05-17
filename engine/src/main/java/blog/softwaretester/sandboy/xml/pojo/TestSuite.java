package blog.softwaretester.sandboy.xml.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

@SuppressWarnings("unused")
@JsonIgnoreProperties(value = { "noNamespaceSchemaLocation", "version" })
public class TestSuite {
    public List<Property> properties;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Testcase> testcase;
    private String name;
    private double time;
    private int tests;
    private int errors;
    private int skipped;
    private int failures;
    private String text;

    public List<Property> getProperties() {
        return properties;
    }

    public List<Testcase> getTestcase() {
        return testcase;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public int getTests() {
        return tests;
    }

    public int getErrors() {
        return errors;
    }

    public int getSkipped() {
        return skipped;
    }

    public int getFailures() {
        return failures;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TestSuite{" +
                "properties=" + properties +
                ", testcase=" + testcase +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", tests=" + tests +
                ", errors=" + errors +
                ", skipped=" + skipped +
                ", failures=" + failures +
                ", text='" + text + '\'' +
                '}';
    }
}
