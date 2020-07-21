import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Car {

    private Map<String, String> car;
    private Map<String, Integer[]> relationGearSpeed;

    public Car() {
        car = new HashMap<>();
        car.put("Engine:", "Off");
        car.put("Direction:", "Forward");
        car.put("Speed:", "0");
        car.put("Gear:", "0");

        relationGearSpeed = new HashMap<>();
        relationGearSpeed.put("-1", new Integer[]{0, 20});
        relationGearSpeed.put("0", new Integer[]{0, 0});
        relationGearSpeed.put("1", new Integer[]{0, 30});
        relationGearSpeed.put("2", new Integer[]{20, 50});
        relationGearSpeed.put("3", new Integer[]{30, 60});
        relationGearSpeed.put("4", new Integer[]{40, 90});
        relationGearSpeed.put("5", new Integer[]{50, 150});
    }

    private static Integer convertStringToInt(String string) {
        Integer result = null;
        try {
            result = Integer.parseInt(string);
        } catch (NumberFormatException exception) {
            System.err.println("Input valid parameter. Gear -1..5 or speed 0 - 150.");
        }
        return result;
    }

    private Boolean matchingGearSpeed(String gear, Integer speed) {
        Boolean isMatchGearSpeed = false;
        switch (gear) {
            case "-1": {
                if(speed >= relationGearSpeed.get("-1")[0] && speed <= relationGearSpeed.get("-1")[1]) {
                    isMatchGearSpeed = true;
                }
                break;
            }
            case "0": {
                if(speed >= relationGearSpeed.get("0")[0] && speed <= relationGearSpeed.get("0")[1]) {
                    isMatchGearSpeed = true;
                }
                break;
            }
            case "1": {
                if(speed >= relationGearSpeed.get("1")[0] && speed <= relationGearSpeed.get("1")[1]) {
                    isMatchGearSpeed = true;
                }
                break;
            }
            case "2": {
                if(speed >= relationGearSpeed.get("2")[0] && speed <= relationGearSpeed.get("2")[1]) {
                    isMatchGearSpeed = true;
                }
                break;
            }
            case "3": {
                if(speed >= relationGearSpeed.get("3")[0] && speed <= relationGearSpeed.get("3")[1]) {
                    isMatchGearSpeed = true;
                }
                break;
            }
            case "4": {
                if(speed >= relationGearSpeed.get("4")[0] && speed <= relationGearSpeed.get("4")[1]) {
                    isMatchGearSpeed = true;
                }
                break;
            }
            case "5": {
                if(speed >= relationGearSpeed.get("5")[0] && speed <= relationGearSpeed.get("5")[1]) {
                    isMatchGearSpeed = true;
                }
                break;
            }
            default: {
                System.out.println();
            }
        }
        return isMatchGearSpeed;
    }

    private Boolean  matchingGearCarParameter(String gear) {
        Boolean isMatchGearCarParameter = false;
        switch (gear) {
            case "-1": {
                if(car.get("Speed:").equals("0")) {
                    isMatchGearCarParameter = true;
                }
                break;
            }
            case "0": {
                isMatchGearCarParameter = true;
                car.put("Gear:", "0");
                break;
            }
            case "1": {
                if(car.get("Direction:").equals("Back") && car.get("Speed:").equals("0")) {
                    isMatchGearCarParameter = true;
                    car.put("Direction:", "Forward");
                }
                if(car.get("Direction:").equals("Forward")) {
                    isMatchGearCarParameter = matchingGearSpeed(gear, convertStringToInt(car.get("Speed:")));
                }
                break;
            }
            case "2": {
                if(car.get("Direction:").equals("Forward")) {
                    isMatchGearCarParameter = matchingGearSpeed(gear, convertStringToInt(car.get("Speed:")));
                }
                break;
            }
            default: {
                isMatchGearCarParameter = matchingGearSpeed(gear, convertStringToInt(car.get("Speed:")));
            }
        }
        return isMatchGearCarParameter;
    }

    public void getCarCurrentState() {
        car.forEach((key, value) -> System.out.println(key + value));
    }


    public Boolean turnOnEngine() {
        car.put("Engine:", "On");
        return true;
    }

    public Boolean turnOffEngine() {
        if(car.get("Speed:").equals("0") && car.get("Gear:").equals("0")) {
            car.put("Engine:", "Off");
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean setSpeed(String speed) {
        Boolean isSetSpeed = matchingGearSpeed(car.get("Gear:"), convertStringToInt(speed));
        if (isSetSpeed) {
            car.put("Speed:", speed);
        }
        return isSetSpeed;
    }

    public Boolean setGear(String gear) {
        Boolean isSetGear = false;
        Boolean isMatchingGearCarParameter = matchingGearCarParameter(gear);
        if (isMatchingGearCarParameter) {
            if(gear.equals("-1")) {
                car.put("Direction:", "Back");
            }
            if(gear.equals("1")) {
                car.put("Direction:", "Forward");
            }
            car.put("Gear:", gear);
            isSetGear = true;
        }
        return isSetGear;
    }
}
