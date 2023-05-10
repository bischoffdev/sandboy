package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.filesystem.FileIO;

import javax.inject.Inject;

public class Engine {

    @Inject
    public Engine(final FileIO fileIO) {
        System.out.println("INJECT");
    }

    public void generateReport() {
        System.out.println("GENERATE REPORT");
    }
}
