public class HtmlEncodeDecode {
    private static final String[][] HTML_CODE = {
        {"\"", "&quot;"},
        {"'", "&apos;"},
        {"<", "&lt;"},
        {">", "&gt;"},
        {"&", "&amp;"}
    };

    public String HtmlEncode(String string) {
        for(int i = 0; i < HTML_CODE.length; i++) {
            String tempString = string.replaceAll(HTML_CODE[i][0], HTML_CODE[i][1]);
            string = tempString;
        }
        return string;
    }

    public String HtmlDecode(String string) {
        for(int i = 0; i < HTML_CODE.length; i++) {
            String tempString = string.replaceAll(HTML_CODE[i][1], HTML_CODE[i][0]);
            string = tempString;
        }
        return string;
    }
    
}
