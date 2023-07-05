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

    public PageData(List<TestSuite> testSuites) {
        this.testSuites = testSuites;
        version = RenderingUtils.getVersion();
    }

    public List<TestSuite> getTestSuites() {
        return testSuites;
    }

    public String getVersion() {
        return "v" + version;
    }

    @Override
    public void accept(Visitor visitor) throws SandboyException {
        visitor.visit(this);
    }
}
