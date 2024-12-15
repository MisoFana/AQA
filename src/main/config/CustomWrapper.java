package main.config;

import org.openqa.selenium.WebElement;

public class CustomWrapper {

    private final WebElement element;

    public CustomWrapper(WebElement element) {
        this.element = element;
    }

    public void click() {
        if (element != null && element.isDisplayed()) {
            element.click();
        }
    }

    public String getText() {
        if (element != null && element.isDisplayed()) {
            return element.getText();
        }
        return null;
    }

    public void sendKeys(String text) {
        if (element != null && element.isDisplayed()) {
            element.sendKeys(text);
        }
    }

    public boolean isDisplayed() {
        return element != null && element.isDisplayed();
    }
}

