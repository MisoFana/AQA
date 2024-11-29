package main.com.aqa.business;

import main.com.aqa.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBO {

    private final LoginPage loginPage;

    public LoginBO(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }
}
