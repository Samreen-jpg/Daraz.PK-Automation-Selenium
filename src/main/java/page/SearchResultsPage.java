package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    WebDriver driver;

    By brandCheckbox = By.cssSelector("input[businessvalue='joyclick-125860050']");
    By freeDeliveryCheckbox = By.cssSelector("input[businessvalue='Free_Shipping']");
    By minPriceInput = By.cssSelector("input[placeholder='Min']");
    By maxPriceInput = By.cssSelector("input[placeholder='Max']");
    By priceSubmit = By.cssSelector("svg[data-icon='caret-right']");
    By firstProduct = By.cssSelector("img[type='product']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBrand() {
        driver.findElement(brandCheckbox).click();
    }

    public void selectFreeDelivery() {
        driver.findElement(freeDeliveryCheckbox).click();
    }

    public void setPriceRange(String min, String max) {
        driver.findElement(minPriceInput).clear();
        driver.findElement(minPriceInput).sendKeys(min);
        driver.findElement(maxPriceInput).clear();
        driver.findElement(maxPriceInput).sendKeys(max);
        driver.findElement(priceSubmit).click();
    }

    public void openFirstProduct() {
        WebElement product = driver.findElement(firstProduct);
        // Scroll element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        // Click using JavaScript to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
    }
}
