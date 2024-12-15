package test;

import main.com.aqa.pages.HomePage;
import main.com.aqa.pages.LoginPage;
import main.config.BrowserType;
import main.config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        BrowserType browser = BrowserType.CHROME;
        DriverFactory.setDriver(browser);
        WebDriver driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.get("https://automationexercise.com/login");
    }

    @Test
    public void testGoToLogin() {
        homePage.login();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, boolean expectedOutcome) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        boolean loginSuccess = homePage.isLoginSuccessful();
        assertEquals(expectedOutcome, loginSuccess);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"shun228123@gmail.com", "123123123", false},
        };
    }

    @Test()
    public void testLogout() {
        homePage.logout();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
