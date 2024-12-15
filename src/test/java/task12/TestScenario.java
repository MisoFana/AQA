package task12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScenario {

    WebDriver driver;
    IframePage iframePage;
    IframeUtils iframeUtils;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://superogshmal.pp.ua");
        iframePage = new IframePage(driver);
        iframeUtils = new IframeUtils(driver);
    }

    @Test
    public void testIframe() {
        WebElement iframe = iframePage.getIframeElement();
        iframeUtils.switchToIframe(iframe);
        iframePage.clickButtonInsideIframe();
        iframeUtils.switchToDefaultContent();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
