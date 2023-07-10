package blog.softwaretester.sandboy.rendering.pages.pojos.collections;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.rendering.RenderingUtils;
import blog.softwaretester.sandboy.rendering.visitors.Visitable;
import blog.softwaretester.sandboy.rendering.visitors.Visitor;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;

import java.util.List;

public class PageData implements Visitable {
    private final List<TestSuite> testSuites;
    private final String version;

    private int numberOfPassedTestcases;
    private int numberOfFailedTestcases;
    private int numberOfSkippedTestcases;
    private int numberOfTestcases;

    public PageData(List<TestSuite> testSuites) {
        this.testSuites = testSuites;
        initializeTotals();
        version = RenderingUtils.getVersion();
    }

    private void initializeTotals() {
        for (TestSuite testSuite : testSuites) {
            numberOfPassedTestcases += testSuite.getNumberOfPassedTestcases();
            numberOfFailedTestcases += testSuite.getNumberOfFailedTestcases();
            numberOfSkippedTestcases += testSuite.getNumberOfSkippedTestcases();
            numberOfTestcases += testSuite.getTestcases().size();
        }
    }

    public List<TestSuite> getTestSuites() {
        return testSuites;
    }

    public int getNumberOfFailedTestcases() {
        return numberOfFailedTestcases;
    }

    public int getNumberOfPassedTestcases() {
        return numberOfPassedTestcases;
    }

    public int getNumberOfSkippedTestcases() {
        return numberOfSkippedTestcases;
    }

    public int getNumberOfTestcases() {
        return numberOfTestcases;
    }

    public String getVersion() {
        return "v" + version;
    }

    @Override
    public void accept(Visitor visitor) throws SandboyException {
        visitor.visit(this);
    }
}
