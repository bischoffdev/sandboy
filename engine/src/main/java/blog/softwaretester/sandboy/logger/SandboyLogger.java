package blog.softwaretester.sandboy.logger;

import org.tinylog.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SandboyLogger {
    @Inject
    public SandboyLogger() {
    }

    public void info(final CharSequence logString) {
        Logger.info(logString);
    }

    public void warn(final CharSequence logString) {
        Logger.warn(logString);
    }
}
