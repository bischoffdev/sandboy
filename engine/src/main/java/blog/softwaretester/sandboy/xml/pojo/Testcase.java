package blog.softwaretester.sandboy.xml.pojo;

import blog.softwaretester.sandboy.rendering.HtmlHelper;
import blog.softwaretester.sandboy.xml.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Testcase {
    private String name;
    @JsonProperty("system-out")
    private String systemOut;
    @JsonProperty("system-err")
    private String systemError;
    private String classname;
    private double time;
    private String text;
    private String failure;
    private String rerunFailure;
    private String flakyFailure;
    private String rerunError;
    private String flakyError;
    private String skipped;
    private String error;

    public String getName() {
        return name;
    }

    public String getClassname() {
        return classname;
    }

    public double getTime() {
        return time;
    }

    public String getSkippedText() {
        return skipped;
    }

    public String getErrorText() {
        StringBuilder textBuilder = new StringBuilder();
        appendIfExists(textBuilder, systemError);
        appendIfExists(textBuilder, error);
        appendIfExists(textBuilder, failure);
        appendIfExists(textBuilder, flakyError);
        appendIfExists(textBuilder, flakyFailure);
        appendIfExists(textBuilder, rerunError);
        appendIfExists(textBuilder, rerunFailure);
        return HtmlHelper.processForDisplay(textBuilder.toString());
    }

    /**
     * Combines systemOut and text properties into one.
     *
     * @return The combined text
     */
    public String getOutputText() {
        StringBuilder textBuilder = new StringBuilder();
        appendIfExists(textBuilder, systemOut);
        appendIfExists(textBuilder, text);
        return HtmlHelper.processForDisplay(textBuilder.toString());
    }

    private void appendIfExists(final StringBuilder textBuilder, final String testToAppend) {
        if (testToAppend != null && !testToAppend.isBlank()) {
            textBuilder.append(testToAppend);
        }
    }

    public Status getStatus() {
        if (!skipped.isBlank()) {
            return Status.SKIPPED;
        }
        return Status.UNKNOWN;
    }
}
