package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductPage;

public class DarazTest {
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "E:\\crome driver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.daraz.pk/");
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void searchAndFilterProduct() throws InterruptedException {
        // Search for electronics
        homePage.enterSearch("electronics");
        homePage.clickSearch();
        Thread.sleep(3000);

        // Apply filters
        searchResultsPage.selectBrand();
        searchResultsPage.selectFreeDelivery();
        searchResultsPage.setPriceRange("500", "5000");
        Thread.sleep(3000);

        // Open first product (fixed for click interception)
        searchResultsPage.openFirstProduct();
        Thread.sleep(3000);

        // Print delivery option
        System.out.println("Delivery Option: " + productPage.getDeliveryOption());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
