import java.util.Collections;
import java.util.Vector;

public class VectorProcessor {

    public void MultiplyEachNegativeElementByCompositionMaxAndMin(Vector vector){
        Double result;
        Double maxElement = (Double) Collections.max(vector);
        Double minElement = (Double) Collections.min(vector);

        int vectorSize = vector.size();
        for(int i=0; i < vectorSize; i++){
            if((Double) vector.get(i) < 0){
                result = (Double) vector.get(i) * maxElement * minElement;
                vector.set(i, result);
            }
        }
    }



}
