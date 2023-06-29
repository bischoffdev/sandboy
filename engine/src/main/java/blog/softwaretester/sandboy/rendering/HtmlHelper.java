package blog.softwaretester.sandboy.rendering;

public class HtmlHelper {
    public static String processForDisplay(final String text) {
        if (text == null) {
            return "";
        }
        return text
                .replaceAll("\n", "<br>")
                .replaceAll(" ", "&nbsp;");
    }
}
