package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By searchInput = By.id("q");
    By searchButton = By.cssSelector(".search-box__button--1oH7");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearch(String text) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(text);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
