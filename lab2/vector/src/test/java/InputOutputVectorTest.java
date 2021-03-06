import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Vector;

public class InputOutputVectorTest {
    private ByteArrayOutputStream output;
    private Vector vector;

    @BeforeMethod
    public void prepareData() {
        output = new ByteArrayOutputStream();
        vector = new Vector();
        PrintStream streamOut = new PrintStream(output);
        System.setOut(streamOut);
    }

    @Test(testName = "AddEmptyInput")
    public void addEmptyInput() {
        InputStream input = new ByteArrayInputStream("".getBytes());
        System.setIn(input);

        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.addDoubleFromInputToVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "");
    }

    @Test(testName = "AddCharInput")
    public void addCharInput() {
        InputStream input = new ByteArrayInputStream("5.4 0 -1 2 3.5 dd".getBytes());
        System.setIn(input);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.addDoubleFromInputToVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "Inputdata contains not only Number!");
    }

    @Test(testName = "AddIntInput")
    public void addIntInput() {
        InputStream input = new ByteArrayInputStream("9 1 2 3 5 ".getBytes());
        System.setIn(input);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.addDoubleFromInputToVector(vector);
        Collections.sort(vector);
        inputOutputVector.printVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "1 2 3 5 9");
    }

    @Test(testName = "AddDoubleInput")
    public void addDoubleInput() {
        InputStream input = new ByteArrayInputStream("5.89874 -4 0 1 2 3 5 ".getBytes());
        System.setIn(input);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.addDoubleFromInputToVector(vector);
        Collections.sort(vector);
        inputOutputVector.printVector(vector);

        String result = output.toString();
        Assert.assertEquals(result, "-4 0 1 2 3 5 5.899");
    }
}
