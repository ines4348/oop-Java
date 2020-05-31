import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class HtmlEncodeDecodeTest {
    private ByteArrayOutputStream output;
    private String string;

    @BeforeMethod
    public void PrepareData(){

        output = new ByteArrayOutputStream();
        string = "";
        PrintStream streamOut = new PrintStream(output);
        System.setOut(streamOut);
    }

    @Test(testName = "AddEmptyInput")
    public void AddEmptyInput(){
        InputStream input = new ByteArrayInputStream("".getBytes());
        System.setIn(input);
        InputOutputString inputOutputString = new InputOutputString();
        String string = inputOutputString.GetHtmlString();
        inputOutputString.PrintDecodeHtmlString(string);
        String result = output.toString();
        Assert.assertEquals(result, "");
    }

    @Test(testName = "OneLineString")
    public void OneLineString(){
        InputStream input = new ByteArrayInputStream("5.4 0 -1 2 3.5 dd".getBytes());
        System.setIn(input);
        InputOutputString inputOutputString = new InputOutputString();
        String string = inputOutputString.GetHtmlString();
        inputOutputString.PrintDecodeHtmlString(string);
        String result = output.toString();
        Assert.assertEquals(result, "5.4 0 -1 2 3.5 dd");
    }

    @Test(testName = "SampleString")
    public void SampleString(){
        String string = "Cat &lt;says&gt; &quot;Meow&quot;. M&amp;M&apos;s";
        HtmlEncodeDecode htmlEncodeDecode = new HtmlEncodeDecode();
        String result = htmlEncodeDecode.HtmlDecode(string);
        Assert.assertEquals(result, "Cat <says> \"Meow\". M&M's");
    }

    @Test(testName = "DecodeEmptyString")
    public void DecodeEmptyString(){
        String string = "";
        HtmlEncodeDecode htmlEncodeDecode = new HtmlEncodeDecode();
        String result = htmlEncodeDecode.HtmlDecode(string);
        Assert.assertEquals(result, "");
    }

    @Test(testName = "DecodeStringWithoutReplaceChar")
    public void DecodeStringWithoutReplaceChar(){
        String string = "Следующий пример читает первую строку из файла.";
        HtmlEncodeDecode htmlEncodeDecode = new HtmlEncodeDecode();
        String result = htmlEncodeDecode.HtmlDecode(string);
        Assert.assertEquals(result, "Следующий пример читает первую строку из файла.");
    }
}
