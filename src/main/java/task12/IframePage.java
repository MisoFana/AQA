package task12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class IframePage {

    @FindBy(id = "iframeId")
    private WebElement iframeElement;

    @FindBy(id = "buttonInIframe")
    private WebElement buttonInIframe;

    private final WebElementWrapper buttonWrapper;

    public IframePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebElementWrapper iframeWrapper = new WebElementWrapper(iframeElement);
        buttonWrapper = new WebElementWrapper(buttonInIframe);
    }

    public void clickButtonInsideIframe() {
        buttonWrapper.click();
    }

    public WebElement getIframeElement() {
        return iframeElement;
    }

    public WebElementWrapper getButtonWrapper() {
        return buttonWrapper;
    }
}
