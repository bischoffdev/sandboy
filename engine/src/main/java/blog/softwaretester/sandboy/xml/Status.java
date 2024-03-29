package blog.softwaretester.sandboy.xml;

public enum Status {
    PASSED("passed"),
    FAILED("failed"),
    SKIPPED("skipped");
    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
