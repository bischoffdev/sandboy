package blog.softwaretester.sandboy.rendering;

public class HtmlHelper {
    public static String processForDisplay(final String text) {
        if (text == null) {
            return "";
        }
        return text
                .replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll(" ", "&nbsp;")
                .replaceAll("\n", "<br>");
    }
}
