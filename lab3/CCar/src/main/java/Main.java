import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Main {
    private static void executeCommand(String commandName, Car car) {
        switch (commandName.toLowerCase()) {
            case "info": {
                car.getCarCurrentState();
                break;
            }
            case "engineon": {
                System.out.println(car.turnOnEngine());
                break;
            }
            case "engineoff": {
                System.out.println(car.turnOffEngine());
                break;
            }
            default: {
                executeCompositeCommand(commandName, car);
            }
        }
    }

    private static void executeCompositeCommand(String commandName, Car car) {
        try {
            String[] commands = commandName.split(" ", 2);
            String parameter = commands[1];
            switch(commands[0].toLowerCase()) {
                case "setgear": {
                    if(parameter != null) {
                        System.out.println(car.setGear(parameter));
                    }
                    break;
                }
                case "setspeed": {
                    if(parameter != null) {
                        System.out.println(car.setSpeed(parameter));
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid command.");
                }
            }
        }
        catch(PatternSyntaxException exception)
        {
            System.out.println("Input valid parameter. Gear -1..5 or speed 0 - 150.");
        }
        catch(ArrayIndexOutOfBoundsException exception)
        {
            System.out.println("Input valid parameter. Gear -1..5 or speed 0 - 150.");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Input command.");
        try(Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNextLine()) {
                try {
                    executeCommand(stringBuilder.append(scanner.nextLine()).toString(), car);
                    stringBuilder.setLength(0);
                } catch (NoSuchElementException error) {
                    System.out.print("No line was found!");
                }
            }
        }
    }
}
