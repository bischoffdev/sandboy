package blog.softwaretester.sandboy.rendering.visitors;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class VisitorDirectory {

    private final List<Visitor> visitors;

    @Inject
    public VisitorDirectory(final HomepageVisitor homepageVisitor) {
        visitors = new ArrayList<>();
        visitors.add(homepageVisitor);
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }
}
