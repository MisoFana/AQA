package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframeUtils {

    WebDriver driver;

    public IframeUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToIframe(WebElement iframe) {
        driver.switchTo().frame(iframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
