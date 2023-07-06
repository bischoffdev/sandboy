package blog.softwaretester.sandboy.xml.pojo;

import blog.softwaretester.sandboy.xml.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@JsonIgnoreProperties(value = {
        "noNamespaceSchemaLocation",
        "version", "properties"
})
public class TestSuite {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("testcase")
    private List<Testcase> testcases;

    private String name;
    private double time;
    private int tests;
    private int errors;
    private int skipped;
    private int failures;
    private String text;

    public List<Testcase> getTestcases() {
        return testcases;
    }

    public List<Testcase> getPassedTestcases() {
        return testcases.stream()
                .filter(testcase -> testcase.getStatus() == Status.PASSED)
                .collect(Collectors.toList());
    }

    public List<Testcase> getFailedTestcases() {
        try {
            List<Testcase> cases = testcases.stream()
                    .filter(testcase -> testcase.getStatus() == Status.FAILED)
                    .collect(Collectors.toList());
            System.out.println(cases);
            return cases;
        } catch (Exception e) {
            System.out.println("WHAT? " + e);
        }
        return null;
    }

    public List<Testcase> getSkippedTestcases() {
        return testcases.stream()
                .filter(testcase -> testcase.getStatus() == Status.SKIPPED)
                .collect(Collectors.toList());
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

    public int getErrorCount() {
        return failures + errors;
    }

    public int getPassCount() {
        return tests - getErrorCount();
    }
}
