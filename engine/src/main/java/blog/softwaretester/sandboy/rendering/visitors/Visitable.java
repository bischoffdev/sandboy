package blog.softwaretester.sandboy.rendering.visitors;


import blog.softwaretester.sandboy.exceptions.SandboyException;

public interface Visitable {
    void accept(final Visitor visitor) throws SandboyException;
}
