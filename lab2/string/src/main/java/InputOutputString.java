import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputOutputString {

    public void PrintDecodeHtmlString(String string){
        System.out.print(string);
    }

    public String GetHtmlString() {
        Scanner scanner = new Scanner(System.in);
        String tempString = "";
        while (scanner.hasNextLine()) {
            try {
                tempString += scanner.nextLine();
            } catch (NoSuchElementException error) {
                System.out.print("No line was found!");
            }
        }
        return tempString;
    }
}
