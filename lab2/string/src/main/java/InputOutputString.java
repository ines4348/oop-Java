import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputOutputString {

    public static void printDecodeHtmlString(String string){
        System.out.print(string);
    }

    public static StringBuilder getHtmlString() {
        StringBuilder stringBuilder = new StringBuilder();
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                try {
                    stringBuilder.append(scanner.nextLine());
                } catch (NoSuchElementException error) {
                    System.out.print("No line was found!");
                }
            }
        }
        return stringBuilder;
    }
}
