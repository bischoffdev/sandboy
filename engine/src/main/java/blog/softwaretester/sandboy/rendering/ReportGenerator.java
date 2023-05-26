package blog.softwaretester.sandboy.rendering;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ReportGenerator {
    private final PropertyManager propertyManager;
    private final FileIO fileIO;

    @Inject
    public ReportGenerator(final PropertyManager propertyManager, final FileIO fileIO) {
        this.propertyManager = propertyManager;
        this.fileIO = fileIO;
    }

    public void generate(final TestSuite testSuite) throws SandboyException {
        createAssets();
        
    }

    private void createAssets() throws SandboyException {
        String rootPath = propertyManager.getReportPath();
        fileIO.createDirectory(rootPath);
        fileIO.createDirectory(rootPath + "/css");
        copyResource("/template/css/pico.classless.min.css", rootPath + "/css/pico.classless.min.css");
    }

    private void copyResource(final String resource, final String destination) throws SandboyException {
        fileIO.copyResourceFromJar(resource, destination);
    }
}
