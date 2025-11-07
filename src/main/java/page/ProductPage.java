package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By deliveryOption = By.cssSelector(".delivery-option-item__title");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getDeliveryOption() {
        return driver.findElement(deliveryOption).getText();
    }
}
