public class HtmlEncodeDecode {
    private static final String[][] HTML_CODE = {
        {"\"", "&quot;"},
        {"'", "&apos;"},
        {"<", "&lt;"},
        {">", "&gt;"},
        {"&", "&amp;"}
    };

    public static StringBuilder htmlEncode(StringBuilder string) {
        for (String[] strings : HTML_CODE) {
            String resultString = string.toString().replaceAll(strings[0], strings[1]);
            string.delete(0, string.length());
            string.append(resultString);
        }
        return string;
    }

    public static StringBuilder htmlDecode(StringBuilder string) {
        for (String[] strings : HTML_CODE) {
            String resultString = string.toString().replaceAll(strings[1], strings[0]);
            string.delete(0, string.length());
            string.append(resultString);
        }
        return string;
    }
}
