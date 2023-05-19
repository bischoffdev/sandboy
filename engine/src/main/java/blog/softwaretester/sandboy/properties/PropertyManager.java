package blog.softwaretester.sandboy.properties;

import blog.softwaretester.sandboy.logger.SandboyLogger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PropertyManager {
    private final SandboyLogger logger;

    private String reportPath;
    private String sourcePath;

    @Inject
    public PropertyManager(final SandboyLogger logger) {
        this.logger = logger;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void log() {
        logger.info("- source path: " + sourcePath);
        logger.info("- report path: " + reportPath);
    }
}
