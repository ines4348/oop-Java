public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder  = InputOutputString.getHtmlString();
        HtmlEncodeDecode.htmlDecode(stringBuilder);
        System.out.println(stringBuilder.toString());
    }
}