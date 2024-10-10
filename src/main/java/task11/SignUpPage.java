package task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    WebDriver driver;

    private final By emailField = By.id("email");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By signUpButton = By.id("signUp");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUp() {
        driver.findElement(signUpButton).click();
    }
}
