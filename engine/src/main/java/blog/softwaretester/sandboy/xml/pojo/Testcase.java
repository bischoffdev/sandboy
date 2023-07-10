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

    private String combinedErrorText;
    private String combinedOutputText;

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
        if (combinedErrorText == null) {
            StringBuilder textBuilder = new StringBuilder();
            appendIfExists(textBuilder, error);
            appendIfExists(textBuilder, failure);
            appendIfExists(textBuilder, flakyError);
            appendIfExists(textBuilder, flakyFailure);
            appendIfExists(textBuilder, rerunError);
            appendIfExists(textBuilder, rerunFailure);
            combinedErrorText = HtmlHelper.processForDisplay(textBuilder.toString());
        }
        return combinedErrorText;
    }

    /**
     * Combines systemOut, systemError and text properties into one.
     *
     * @return The combined text
     */
    public String getOutputText() {
        if (combinedOutputText == null) {
            StringBuilder textBuilder = new StringBuilder();
            appendIfExists(textBuilder, systemOut);
            appendIfExists(textBuilder, systemError);
            appendIfExists(textBuilder, text);
            combinedOutputText = HtmlHelper.processForDisplay(textBuilder.toString());
        }
        return combinedOutputText;
    }

    private void appendIfExists(final StringBuilder textBuilder, final String testToAppend) {
        if (testToAppend != null && !testToAppend.isBlank()) {
            textBuilder.append(testToAppend);
        }
    }

    public Status getStatus() {
        String errorText = getErrorText();
        Status status = Status.PASSED;
        if (errorText != null && !errorText.isBlank()) {
            status = Status.FAILED;
        } else if (skipped != null && !skipped.isBlank()) {
            status = Status.SKIPPED;
        }

        System.out.println("--- ERROR --- " + name);
        System.out.println(combinedErrorText + " " + status);
        return status;
    }
}
