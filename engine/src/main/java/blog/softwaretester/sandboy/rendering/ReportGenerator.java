package blog.softwaretester.sandboy.rendering;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.rendering.pages.pojos.collections.PageData;
import blog.softwaretester.sandboy.rendering.visitors.Visitor;
import blog.softwaretester.sandboy.rendering.visitors.VisitorDirectory;

import javax.inject.Inject;
import javax.inject.Singleton;

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
            System.out.println("Visitor " + visitor);
            pageData.accept(visitor);
        }
    }

    private void createAssets() throws SandboyException {
        String rootPath = propertyManager.getReportPath();
        fileIO.createDirectory(rootPath);
        fileIO.createDirectory(rootPath + "/css");
        cp("/template/css/pico.classless.min.css", rootPath + "/css/pico.classless.min.css");
    }

    private void cp(final String resource, final String destination) throws SandboyException {
        fileIO.copyResourceFromJar(resource, destination);
    }
}
