package blog.softwaretester.sandboy.rendering;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.templates.TemplateEngine;

import javax.inject.Inject;
import java.io.File;

public class PageGenerator {
    private final FileIO fileIO;
    private final TemplateEngine templateEngine;
    private final PropertyManager propertyManager;

    @Inject
    public PageGenerator(
            final FileIO fileIO,
            final TemplateEngine templateEngine,
            final PropertyManager propertyManager
    ) {
        this.fileIO = fileIO;
        this.templateEngine = templateEngine;
        this.propertyManager = propertyManager;
    }

    public void create(final String pagePath, final String pageContent) throws SandboyException {
        fileIO.writeToFile(
                propertyManager.getReportPath().replace("/", File.separator) + pagePath, pageContent);
    }
}
