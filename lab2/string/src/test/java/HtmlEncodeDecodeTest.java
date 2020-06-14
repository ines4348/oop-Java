import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class HtmlEncodeDecodeTest {
    private ByteArrayOutputStream output;
    private StringBuilder stringBuilder;

    @BeforeMethod
    public void PrepareData() {
        output = new ByteArrayOutputStream();
        PrintStream streamOut = new PrintStream(output);
        System.setOut(streamOut);
    }

    @Test(testName = "AddEmptyInput")
    public void addEmptyInput() {
        InputStream input = new ByteArrayInputStream("".getBytes());
        System.setIn(input);
        StringBuilder stringBuilder = InputOutputString.getHtmlString();
        InputOutputString.printDecodeHtmlString(stringBuilder.toString());
        String result = output.toString();
        Assert.assertEquals(result, "");
    }

    @Test(testName = "OneLineString")
    public void oneLineString() {
        InputStream input = new ByteArrayInputStream("5.4 0 -1 2 3.5 dd".getBytes());
        System.setIn(input);
        StringBuilder stringBuilder = InputOutputString.getHtmlString();
        InputOutputString.printDecodeHtmlString(stringBuilder.toString());
        String result = output.toString();
        Assert.assertEquals(result, "5.4 0 -1 2 3.5 dd");
    }

    @Test(testName = "SampleString")
    public void sampleString() {
        stringBuilder = new StringBuilder("Cat &lt;says&gt; &quot;Meow&quot;. M&amp;M&apos;s");
        StringBuilder result = HtmlEncodeDecode.htmlDecode(stringBuilder);
        Assert.assertEquals(result.toString(), "Cat <says> \"Meow\". M&M's");
    }

    @Test(testName = "DecodeEmptyString")
    public void decodeEmptyString() {
        stringBuilder = new StringBuilder();
        StringBuilder result = HtmlEncodeDecode.htmlDecode(stringBuilder);
        Assert.assertEquals(result.toString(), "");
    }

    @Test(testName = "DecodeStringWithoutReplaceChar")
    public void decodeStringWithoutReplaceChar() {
        stringBuilder = new StringBuilder("Следующий пример читает первую строку из файла.");
        StringBuilder result = HtmlEncodeDecode.htmlDecode(stringBuilder);
        Assert.assertEquals(result.toString(), "Следующий пример читает первую строку из файла.");
    }
}
