package blog.softwaretester.sandboy.xml.pojo;

import blog.softwaretester.sandboy.rendering.HtmlHelper;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Testcase {
    private String name = "";
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

    public String getSystemOut() {
        return HtmlHelper.processForDisplay(systemOut);
    }

    public String getSystemError() {
        return HtmlHelper.processForDisplay(systemError);
    }

    public String getName() {
        return name;
    }

    public String getClassname() {
        return classname;
    }

    public double getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    public String getFailure() {
        return failure;
    }

    public String getRerunFailure() {
        return rerunFailure;
    }

    public String getFlakyFailure() {
        return flakyFailure;
    }

    public String getRerunError() {
        return rerunError;
    }

    public String getFlakyError() {
        return flakyError;
    }

    public String getSkipped() {
        return skipped;
    }

    public String getError() {
        return error;
    }
}
