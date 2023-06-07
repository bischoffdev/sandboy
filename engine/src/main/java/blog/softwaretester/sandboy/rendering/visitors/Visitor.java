package blog.softwaretester.sandboy.rendering.visitors;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.rendering.pages.pojos.collections.PageData;

public interface Visitor {
    void visit(final PageData pageCollection) throws SandboyException;
}
