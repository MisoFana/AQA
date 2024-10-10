package task10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void testRadioButtonInteraction() {
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
        WebElement noRadio = driver.findElement(By.id("noRadio"));

        yesRadio.click();
        impressiveRadio.click();

        Assert.assertTrue(yesRadio.isDisplayed());
        Assert.assertTrue(impressiveRadio.isDisplayed());
        Assert.assertFalse(noRadio.isEnabled());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
