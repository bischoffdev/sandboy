package blog.softwaretester.sandboy;

import javax.inject.Inject;

public class Engine {
    @Inject
    public Engine() {
        System.out.println("INJECT");
    }

    public void generateReport() {
        System.out.println("GENERATE REPORT");
    }
}
