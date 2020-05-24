import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Vector;

public class InputOutputVectorTest {
    private ByteArrayOutputStream output;
    private Vector vector;

    @BeforeMethod
    public void PrepareData(){

        output = new ByteArrayOutputStream();
        vector = new Vector();
        PrintStream streamOut = new PrintStream(output);
        System.setOut(streamOut);
    }

    @Test(testName = "AddEmptyInput")
    public void AddEmptyInput(){
        InputStream input = new ByteArrayInputStream("".getBytes());
        System.setIn(input);

        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.AddDoubleFromInputToVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "");
    }

    @Test(testName = "AddCharInput")
    public void AddCharInput(){
        InputStream input = new ByteArrayInputStream("5.4 0 -1 2 3.5 dd".getBytes());
        System.setIn(input);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.AddDoubleFromInputToVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "Inputdata contains not only Number!");
    }

    @Test(testName = "AddIntInput")
    public void AddIntInput(){
        InputStream input = new ByteArrayInputStream("9 1 2 3 5 ".getBytes());
        System.setIn(input);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.AddDoubleFromInputToVector(vector);
        inputOutputVector.PrintSortVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "1 2 3 5 9");
    }

    @Test(testName = "AddDoubleInput")
    public void AddDoubleInput(){
        InputStream input = new ByteArrayInputStream("5.89874 -4 0 1 2 3 5 ".getBytes());
        System.setIn(input);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.AddDoubleFromInputToVector(vector);
        inputOutputVector.PrintSortVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "-4 0 1 2 3 5 5.898");
    }
}
