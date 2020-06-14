import java.util.Collections;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector();
        InputOutputVector inputOutputVector = new InputOutputVector();
        inputOutputVector.addDoubleFromInputToVector(vector);
        VectorProcessor.multiplyEachNegativeElementByCompositionMaxAndMin(vector);
        Collections.sort(vector);
        inputOutputVector.printVector(vector);
    }
}
