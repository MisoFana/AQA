package task20;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {
    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Emulator");
        options.setApp("/home/pacansrayona/app.apk");
        options.setAutomationName("UiAutomator2");

        AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), options);

        try {
            WebElement firstNumber = driver.findElement(AppiumBy.id("calculator:id/digit_5"));
            firstNumber.click();

            WebElement operator = driver.findElement(AppiumBy.id("calculator:id/op_mul"));
            operator.click();

            WebElement secondNumber = driver.findElement(AppiumBy.id("calculator:id/digit_3"));
            secondNumber.click();

            WebElement equalButton = driver.findElement(AppiumBy.id("calculator:id/eq"));
            equalButton.click();

            WebElement result = driver.findElement(AppiumBy.id("calculator:id/result"));
            String resultText = result.getText();

            if (resultText.equals("15")) {
                System.out.println("Test Passed: 5 * 3 = " + resultText);
            } else {
                System.out.println("Test Failed: Expected 15, but got " + resultText);
            }
        } finally {
            driver.quit();
        }
    }
}
