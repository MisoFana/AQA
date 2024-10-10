package task11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void signUpTest() {
        User newUser = new User("ivan@example.com", "ivan", "ivan123");

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterEmail(newUser.getEmail());
        signUpPage.enterUsername(newUser.getUsername());
        signUpPage.enterPassword(newUser.getPassword());
        signUpPage.clickSignUp();

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

