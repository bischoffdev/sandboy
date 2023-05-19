package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.exceptions.SandboyException;
import blog.softwaretester.sandboy.filesystem.FileIO;
import blog.softwaretester.sandboy.logger.SandboyLogger;

import javax.inject.Inject;

public class SandboyEngine {

    private final FileIO fileIO;
    private final SandboyLogger logger;

    @Inject
    public SandboyEngine(
            final FileIO fileIO,
            final SandboyLogger logger
    ) {
        this.fileIO = fileIO;
        this.logger = logger;
    }

    public void build(
            final String surefireSourcePath,
            final String generatedReportPath
    ) throws SandboyException {
        fileIO.readContentFromFile(surefireSourcePath);
        logger.info("GENERATE REPORT");
    }
}
