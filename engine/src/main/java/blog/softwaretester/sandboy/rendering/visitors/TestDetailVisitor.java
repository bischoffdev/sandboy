package blog.softwaretester.sandboy.rendering.visitors;

import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.rendering.pages.pojos.collections.PageData;
import blog.softwaretester.sandboy.templates.TemplateEngine;

import javax.inject.Inject;

public class TestDetailVisitor implements Visitor {
    private final FileIO fileIO;
    private final TemplateEngine templateEngine;
    private final PropertyManager propertyManager;

    @Inject
    public TestDetailVisitor(
            final FileIO fileIO,
            final TemplateEngine templateEngine,
            final PropertyManager propertyManager
    ) {
        this.fileIO = fileIO;
        this.templateEngine = templateEngine;
        this.propertyManager = propertyManager;
    }

    @Override
    public void visit(final PageData pageCollection) {
        System.out.println(this + " visiting");
    }
}
