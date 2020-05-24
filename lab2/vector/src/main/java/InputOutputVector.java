import java.text.DecimalFormat;
import java.util.*;

public class InputOutputVector {

    public Boolean AddDoubleFromInputToVector(Vector vector){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            try{
                if(scanner.hasNextDouble()){
                    vector.add(scanner.nextDouble());
                }
                else {
                    System.out.print("Inputdata contains not only Number!");
                    return false;
                }
            } catch(InputMismatchException error){
                System.out.print("Inputdata contains not only Number!");
                return false;
            }
        }
        return true;
    }

    public void PrintSortVector(Vector vector){
        DecimalFormat myFormat = new DecimalFormat("#.###");
        Collections.sort(vector);
        int vectorSize = vector.size();
        for(int i=0; i < vectorSize; i++){
            System.out.print(myFormat.format(vector.get(i)));
            if(i < vectorSize - 1){
                System.out.print(" ");
            }
        }
    }
}
