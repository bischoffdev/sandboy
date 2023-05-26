package blog.softwaretester.sandboy.rendering;

import blog.softwaretester.sandboy.SandboyEngine;

public class RenderingUtils {
    public static String getVersion() {
        return SandboyEngine.class.getPackage().getImplementationVersion();
    }
}
