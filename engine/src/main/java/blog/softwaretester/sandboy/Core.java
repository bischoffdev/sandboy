package blog.softwaretester.sandboy;

import blog.softwaretester.sandboy.xml.XmlParser;

import javax.inject.Inject;

public class Core {

    @Inject
    public Core() {
        System.out.println("INJECT");
    }



    public void generateReport() {
        System.out.println("GENERATE REPORT");
    }
}
