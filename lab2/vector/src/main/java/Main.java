import java.util.Collections;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector();
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.AddDoubleFromInputToVector(vector);
        VectorProcessor vectorProcessor = new VectorProcessor();
        vectorProcessor.MultiplyEachNegativeElementByCompositionMaxAndMin(vector);
        Collections.sort(vector);
        inputOutputVector.PrintVector(vector);
    }
}
