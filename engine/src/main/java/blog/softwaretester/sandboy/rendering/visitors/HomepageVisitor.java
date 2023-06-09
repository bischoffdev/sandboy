package blog.softwaretester.sandboy.rendering.visitors;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.rendering.PageGenerator;
import blog.softwaretester.sandboy.rendering.pages.pojos.collections.PageData;

import javax.inject.Inject;

public class HomepageVisitor implements Visitor {
    private final PageGenerator pageGenerator;

    @Inject
    public HomepageVisitor(final PageGenerator pageGenerator) {
        this.pageGenerator = pageGenerator;
    }

    @Override
    public void visit(final PageData pageCollection) throws SandboyException {

        pageGenerator.create("index.html", "index", pageCollection);
    }
}
