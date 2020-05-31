import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputOutputString {

    public void PrintDecodeHtmlString(String string){
        System.out.print(string);
    }

    public String GetHtmlString() {
        String tempString = "";
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                try {
                    tempString += scanner.nextLine();
                } catch (NoSuchElementException error) {
                    System.out.print("No line was found!");
                }
            }
        }
        return tempString;
    }
}
