import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CarTest {

    private ByteArrayOutputStream output;

    @BeforeMethod
    public void PrepareData() {
        output = new ByteArrayOutputStream();
        PrintStream streamOut = new PrintStream(output);
        System.setOut(streamOut);
    }

    @Test(testName = "turnOnEngine")
    public void turnOnEngineTrue() {
        Car car = new Car();
        car.getCarCurrentState();
        car.turnOnEngine();
        car.getCarCurrentState();
        String expectedOutput = "Engine:Off\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "turnOffEngineTrue")
    public void turnOffEngineTrue() {
        Car car = new Car();
        car.getCarCurrentState();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.turnOffEngine();
        car.getCarCurrentState();
        String expectedOutput = "Engine:Off\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:Off\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "turnOffEngineTrueChangeGear")
    public void turnOffEngineTrueChangeGear() {
        Car car = new Car();
        car.turnOnEngine();
        car.setGear("1");
        car.getCarCurrentState();
        car.setGear("0");
        car.getCarCurrentState();
        car.turnOffEngine();
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:1\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:Off\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "turnOffEngineTrueChangeSpeed")
    public void turnOffEngineTrueChangeSpeed() {
        Car car = new Car();
        car.turnOnEngine();
        car.setGear("1");
        car.setSpeed("5");
        car.getCarCurrentState();
        car.setGear("0");
        car.setSpeed("0");
        car.getCarCurrentState();
        car.turnOffEngine();
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:5\r\nDirection:Forward\r\nGear:1\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:Off\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "turnOffEngineFalseChangeGear")
    public void turnOffEngineFalseChangeGear() {
        Car car = new Car();
        car.turnOnEngine();
        car.setGear("1");
        car.getCarCurrentState();
        car.turnOffEngine();
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:1\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "turnOffEngineFalseChangeSpeed")
    public void turnOffEngineFalseChangeSpeed() {
        Car car = new Car();
        car.turnOnEngine();
        car.setGear("1");
        car.setSpeed("5");
        car.getCarCurrentState();
        car.turnOffEngine();
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:5\r\nDirection:Forward\r\nGear:1\r\n" +
                                "Engine:On\r\nSpeed:5\r\nDirection:Forward\r\nGear:1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeGearTrue0To-1")
    public void changeGearTrue0ToBack() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("-1");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Back\r\nGear:-1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeGearTrue0To1")
    public void changeGearTrue0To1() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("1");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }
    @Test(testName = "changeGearFalse0To2")
    public void changeGearFalse0To2() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("2");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeGearTrue1To3")
    public void changeGearTrue0To2() {
        Car car = new Car();
        car.turnOnEngine();
        car.setGear("1");
        car.setSpeed("30");
        car.getCarCurrentState();
        car.setGear("3");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:30\r\nDirection:Forward\r\nGear:1\r\n" +
                                "Engine:On\r\nSpeed:30\r\nDirection:Forward\r\nGear:3\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeGearTrue-1To1")
    public void changeGearTrueBackTo1() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("-1");
        car.getCarCurrentState();
        car.setGear("1");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Back\r\nGear:-1\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeGearTrueTo0")
    public void changeGearTrueTo0() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("1");
        car.setSpeed("25");
        car.setGear("2");
        car.setSpeed("45");
        car.getCarCurrentState();
        car.setGear("0");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:45\r\nDirection:Forward\r\nGear:2\r\n" +
                                "Engine:On\r\nSpeed:45\r\nDirection:Forward\r\nGear:0\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeGearFalse-1To1")
    public void changeGearFalseBackTo1() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("-1");
        car.setSpeed("5");
        car.getCarCurrentState();
        car.setGear("1");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:5\r\nDirection:Back\r\nGear:-1\r\n" +
                                "Engine:On\r\nSpeed:5\r\nDirection:Back\r\nGear:-1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeSpeedFalseOn0")
    public void changeSpeedFalseOn0() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setSpeed("5");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeSpeedFalseOn1")
    public void changeSpeedFalseOn1() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("1");
        car.setSpeed("35");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }

    @Test(testName = "changeSpeedTrue")
    public void changeSpeedTrue() {
        Car car = new Car();
        car.turnOnEngine();
        car.getCarCurrentState();
        car.setGear("-1");
        car.setSpeed("5");
        car.getCarCurrentState();
        car.setSpeed("0");
        car.setGear("1");
        car.setSpeed("15");
        car.getCarCurrentState();
        String expectedOutput = "Engine:On\r\nSpeed:0\r\nDirection:Forward\r\nGear:0\r\n" +
                                "Engine:On\r\nSpeed:5\r\nDirection:Back\r\nGear:-1\r\n" +
                                "Engine:On\r\nSpeed:15\r\nDirection:Forward\r\nGear:1\r\n";
        Assert.assertEquals(output.toString(), expectedOutput);
    }
}
