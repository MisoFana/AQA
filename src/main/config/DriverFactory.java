package main.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static void setDriver(BrowserType browserType) {
        if (driverPool.get() == null) {
            switch (browserType) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
            WebDriver driver = driverPool.get();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            throw new IllegalStateException("Driver is not set! Call setDriver() first.");
        }
        return driverPool.get();
    }

    public static void quitDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
