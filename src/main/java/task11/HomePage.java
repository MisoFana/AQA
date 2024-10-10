package task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    private final By loggedInUser = By.id("loggedInUser");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserLoggedIn() {
        WebElement userElement = driver.findElement(loggedInUser);
        return userElement.isDisplayed();
    }
}

