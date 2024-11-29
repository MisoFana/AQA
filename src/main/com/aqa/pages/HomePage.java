package main.com.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    private final By logoutButton = By.xpath("//a[@href='/logout']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoutButtonDisplayed() {
        WebElement logout = driver.findElement(logoutButton);
        return logout.isDisplayed();
    }
}
