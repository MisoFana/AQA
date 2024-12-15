package main.com.aqa.pages;

import main.config.CustomWrapper;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        CustomWrapper loginWrapper = new CustomWrapper(loginButton);
        loginWrapper.click();
    }

    public boolean isLoginSuccessful() {
        try {
            CustomWrapper logoutWrapper = new CustomWrapper(logoutButton);

            return logoutWrapper.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        CustomWrapper logoutWrapper = new CustomWrapper(logoutButton);
        logoutWrapper.click();
    }
}
