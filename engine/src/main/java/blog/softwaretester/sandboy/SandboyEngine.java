package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.logger.SandboyLogger;
import blog.softwaretester.sandboy.properties.PropertyManager;
import blog.softwaretester.sandboy.rendering.RenderingUtils;
import blog.softwaretester.sandboy.rendering.ReportGenerator;
import blog.softwaretester.sandboy.settings.Constants;
import blog.softwaretester.sandboy.xml.XmlParser;
import blog.softwaretester.sandboy.xml.pojo.TestSuite;

import javax.inject.Inject;

public class SandboyEngine {

    private final FileIO fileIO;
    private final XmlParser parser;
    private final SandboyLogger logger;
    private final PropertyManager properties;
    private final ReportGenerator reportGenerator;

    @Inject
    public SandboyEngine(
            final SandboyLogger logger,
            final PropertyManager properties,
            final FileIO fileIO,
            final XmlParser parser,
            final ReportGenerator reportGenerator
    ) {
        this.logger = logger;
        this.fileIO = fileIO;
        this.parser = parser;
        this.properties = properties;
        this.reportGenerator = reportGenerator;
    }

    public void build(
            final String surefireSourcePath,
            final String generatedReportPath
    ) throws SandboyException {
        properties.setSourcePath(surefireSourcePath);
        properties.setReportPath(generatedReportPath);

        logger.logSeparator();
        logger.info(String.format(" [ Sandboy v%s ]", RenderingUtils.getVersion()));
        logger.logSeparator();
        properties.log();

        String xmlContent = fileIO.readContentFromFile(surefireSourcePath);
        logger.info(xmlContent);

        TestSuite testSuite = parser.xmlStringToTestSuite(xmlContent);
        reportGenerator.generate(testSuite);
        logger.info(
                "=> Sandboy Report: " + properties.getReportPath() + "/" +
                Constants.START_PAGE + Constants.HTML_FILE_EXTENSION);
    }
}
