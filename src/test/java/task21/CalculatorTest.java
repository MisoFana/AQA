package task21;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CalculatorTest {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        Robot robot = new Robot();

        Runtime.getRuntime().exec("gnome-calculator");
        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ASTERISK);
        robot.keyRelease(KeyEvent.VK_ASTERISK);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_3);
        robot.keyRelease(KeyEvent.VK_3);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_EQUALS);
        robot.keyRelease(KeyEvent.VK_EQUALS);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }
}
