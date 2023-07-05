package blog.softwaretester.sandboy.rendering;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.rendering.pages.pojos.collections.PageData;
import blog.softwaretester.sandboy.templates.TemplateFactory;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import static blog.softwaretester.sandboy.settings.Constants.TEMPLATE_FILE_EXTENSION;

public class PageGenerator {
    private final FileIO fileIO;
    private final TemplateFactory templateFactory;
    private final PropertyManager propertyManager;

    @Inject
    public PageGenerator(
            final FileIO fileIO,
            final TemplateFactory templateFactory,
            final PropertyManager propertyManager
    ) {
        this.fileIO = fileIO;
        this.templateFactory = templateFactory;
        this.propertyManager = propertyManager;
    }

    public void create(final String pagePath, final String templateName, final PageData pageData) throws SandboyException {
        Template template = templateFactory.getTemplate(templateName + TEMPLATE_FILE_EXTENSION);
        try (StringWriter writer = new StringWriter()) {
            template.process(pageData, writer);
            fileIO.writeToFile(
                    propertyManager.getReportPath().replace("/", File.separator) + File.separator +
                            pagePath, writer.toString()
            );
        } catch (TemplateException | IOException e) {
            throw new SandboyException(
                    "Could not render content with template " +
                            templateName + " for page " + pagePath + ": " +
                            e.getMessage()
            );
        }
    }
}
