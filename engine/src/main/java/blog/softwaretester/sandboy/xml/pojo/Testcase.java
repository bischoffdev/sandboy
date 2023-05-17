package blog.softwaretester.sandboy.xml.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Testcase {
    @JsonProperty("system-out")
    private String systemout;
    @JsonProperty("system-err")
    private String systemerr;
    private String name;
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

    public String getSystemout() {
        return systemout;
    }

    public String getSystemerr() {
        return systemerr;
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

    @Override
    public String toString() {
        return "Testcase{" +
                "systemout='" + systemout + '\'' +
                ", systemerr='" + systemerr + '\'' +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", time=" + time +
                ", text='" + text + '\'' +
                ", failure='" + failure + '\'' +
                ", rerunFailure='" + rerunFailure + '\'' +
                ", flakyFailure='" + flakyFailure + '\'' +
                ", rerunError='" + rerunError + '\'' +
                ", flakyError='" + flakyError + '\'' +
                ", skipped='" + skipped + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
