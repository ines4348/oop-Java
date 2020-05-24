import java.util.Vector;

public class Main {

    public static void main(){
        Vector vector = new Vector();
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.AddDoubleFromInputToVector(vector);
        VectorProcessor vectorProcessor = new VectorProcessor();
        vectorProcessor.MultiplyEachNegativeElementByCompositionMaxAndMin(vector);
        inputOutputVector.PrintSortVector(vector);
    }
}
