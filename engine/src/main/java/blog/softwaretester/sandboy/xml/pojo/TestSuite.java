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
    private List<Testcase> failedTestcases;
    private List<Testcase> passedTestcases;
    private List<Testcase> skippedTestcases;

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
        if (passedTestcases == null) {
            passedTestcases = testcases.stream()
                    .filter(testcase -> testcase.getStatus() == Status.PASSED)
                    .collect(Collectors.toList());
        }
        return passedTestcases;
    }

    public List<Testcase> getFailedTestcases() {
        if (failedTestcases == null) {
            failedTestcases = testcases.stream()
                    .filter(testcase -> testcase.getStatus() == Status.FAILED)
                    .collect(Collectors.toList());
        }
        return failedTestcases;
    }

    public List<Testcase> getSkippedTestcases() {
        if (skippedTestcases == null) {
            skippedTestcases = testcases.stream()
                    .filter(testcase -> testcase.getStatus() == Status.SKIPPED)
                    .collect(Collectors.toList());
        }
        return skippedTestcases;
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

    public int getNumberOfTestcases() {
        return testcases.size();
    }

    public int getNumberOfPassedTestcases() {
        return getPassedTestcases().size();
    }

    public int getNumberOfFailedTestcases() {
        return getFailedTestcases().size();
    }

    public int getNumberOfSkippedTestcases() {
        return getSkippedTestcases().size();
    }
}
