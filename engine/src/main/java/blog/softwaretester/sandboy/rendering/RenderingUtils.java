package blog.softwaretester.sandboy.rendering;

public class RenderingUtils {
    public static String getVersion() {
        return RenderingUtils.class.getPackage().getImplementationVersion();
    }
}
