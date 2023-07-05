package blog.softwaretester.sandboy.rendering;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.rendering.pages.pojos.collections.PageData;
import blog.softwaretester.sandboy.rendering.visitors.Visitor;
import blog.softwaretester.sandboy.rendering.visitors.VisitorDirectory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;

@Singleton
public class ReportGenerator {
    private final PropertyManager propertyManager;
    private final FileIO fileIO;
    private final VisitorDirectory visitorDirectory;

    @Inject
    public ReportGenerator(
            final PropertyManager propertyManager,
            final FileIO fileIO,
            final VisitorDirectory visitorDirectory
    ) {
        this.propertyManager = propertyManager;
        this.fileIO = fileIO;
        this.visitorDirectory = visitorDirectory;
    }

    public void generate(final PageData pageData) throws SandboyException {
        createAssets();
        for (Visitor visitor : visitorDirectory.getVisitors()) {
            pageData.accept(visitor);
        }
    }

    private void createAssets() throws SandboyException {
        String rootPath = propertyManager.getReportPath();
        fileIO.createDirectory(rootPath);
        fileIO.createDirectory(rootPath + File.separator + "css");
        copyTemplateResource("css/pico.classless.min.css");
        copyTemplateResource("css/override.css");
    }

    private void copyTemplateResource(final String resource) throws SandboyException {
        String source = "/template" + File.separator + resource;
        String destination = propertyManager.getReportPath() + File.separator + resource;
        fileIO.copyResourceFromJar(source, destination);
    }
}
