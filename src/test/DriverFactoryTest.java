package test;

import main.config.BrowserType;
import main.config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverFactoryTest {

    @Test
    public void testChromeDriver() {
        DriverFactory.setDriver(BrowserType.CHROME);
        WebDriver driver = DriverFactory.getDriver();

        try {
            driver.get("https://automationexercise.com");
            boolean isGoogleLogoPresent = driver.findElement(By.id("hplogo")).isDisplayed();
            Assert.assertTrue(isGoogleLogoPresent, "Google logo is not displayed!");
        } finally {
            DriverFactory.quitDriver();
        }
    }

    @Test
    public void testFirefoxDriver() {
        DriverFactory.setDriver(BrowserType.FIREFOX);
        WebDriver driver = DriverFactory.getDriver();

        try {
            driver.get("https://www.google.com");
            boolean isGoogleLogoPresent = driver.findElement(By.id("hplogo")).isDisplayed();
            Assert.assertTrue(isGoogleLogoPresent, "Google logo is not displayed!");
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
