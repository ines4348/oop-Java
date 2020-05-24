import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

public class VectorProcessTest {
    private ByteArrayOutputStream output;
    private Vector vector;

    @BeforeMethod
    public void PrepareData(){

        output = new ByteArrayOutputStream();
        vector = new Vector();
        PrintStream streamOut = new PrintStream(output);
        System.setOut(streamOut);
    }

    @Test(testName = "RegularSample")
    public void RegularSample(){
        vector.add(Double.valueOf(-2.457));
        vector.add(Double.valueOf(-0.521));
        vector.add(Double.valueOf(0));
        vector.add(Double.valueOf(-10));
        vector.add(Double.valueOf(50));
        vector.add(Double.valueOf(1));

        VectorProcessor vectorProcessor = new VectorProcessor();
        vectorProcessor.MultiplyEachNegativeElementByCompositionMaxAndMin(vector);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.PrintSortVector(vector);
        String result = output.toString();
        Assert.assertEquals(result, "0 1 50 260.5 1228.5 5000");
    }

    @Test(testName = "SameMaxElements")
    public void SameMaxElements(){
        vector.add(Double.valueOf(-2.4578));
        vector.add(Double.valueOf(50));
        vector.add(Double.valueOf(0));
        vector.add(Double.valueOf(-10));
        vector.add(Double.valueOf(50));
        vector.add(Double.valueOf(1));

        VectorProcessor vectorProcessor = new VectorProcessor();
        vectorProcessor.MultiplyEachNegativeElementByCompositionMaxAndMin(vector);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.PrintSortVector(vector);
        String result = output.toString();
        Assert.assertEquals(result, "0 1 50 50 1228.9 5000");
    }

    @Test(testName = "SameMinElements")
    public void SameMinElements(){
        vector.add(Double.valueOf(-2.4578));
        vector.add(Double.valueOf(-10));
        vector.add(Double.valueOf(0));
        vector.add(Double.valueOf(-10));
        vector.add(Double.valueOf(5));
        vector.add(Double.valueOf(1));

        VectorProcessor vectorProcessor = new VectorProcessor();
        vectorProcessor.MultiplyEachNegativeElementByCompositionMaxAndMin(vector);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.PrintSortVector(vector);
        String result = output.toString();
        Assert.assertEquals(result, "0 1 5 122.89 500 500");
    }

    @Test(testName = "NotNegativeElements")
    public void NotNegativeElements(){
        vector.add(Double.valueOf(2.4578));
        vector.add(Double.valueOf(10));
        vector.add(Double.valueOf(0));
        vector.add(Double.valueOf(10));
        vector.add(Double.valueOf(5));
        vector.add(Double.valueOf(1));

        VectorProcessor vectorProcessor = new VectorProcessor();
        vectorProcessor.MultiplyEachNegativeElementByCompositionMaxAndMin(vector);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.PrintSortVector(vector);
        String result = output.toString();
        Assert.assertEquals(result, "0 1 2.458 5 10 10");
    }

    @Test(testName = "AllSameElements")
    public void AllSameElements(){
        vector.add(Double.valueOf(-1));
        vector.add(Double.valueOf(-1));
        vector.add(Double.valueOf(-1));
        vector.add(Double.valueOf(-1));
        vector.add(Double.valueOf(-1));
        vector.add(Double.valueOf(-1));

        VectorProcessor vectorProcessor = new VectorProcessor();
        vectorProcessor.MultiplyEachNegativeElementByCompositionMaxAndMin(vector);
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.PrintSortVector(vector);
        String result = output.toString();
        Assert.assertEquals(result, "-1 -1 -1 -1 -1 -1");
    }
}
