package blog.softwaretester.sandboy.rendering.pages.pojos.collections;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.rendering.visitors.Visitable;
import blog.softwaretester.sandboy.rendering.visitors.Visitor;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;

import java.util.List;

public class PageData implements Visitable {
    private final List<TestSuite> testSuites;

    public PageData(List<TestSuite> testSuites) {
        this.testSuites = testSuites;
    }

    public List<TestSuite> getTestSuites() {
        return testSuites;
    }

    @Override
    public void accept(Visitor visitor) throws SandboyException {
        visitor.visit(this);
    }
}
