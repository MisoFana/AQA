package task12;

import org.openqa.selenium.WebElement;

public class WebElementWrapper {

    private final WebElement element;

    public WebElementWrapper(WebElement element) {
        this.element = element;
    }

    public void click() {
        System.out.println("Clicking on element: " + element.toString());
        element.click();
    }

    public void sendKeys(String text) {
        System.out.println("Sending text: " + text + " to element: " + element.toString());
        element.sendKeys(text);
    }

    public String getText() {
        String text = element.getText();
        System.out.println("Getting text: " + text + " from element: " + element.toString());
        return text;
    }
}

