package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductPage;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 1️⃣ Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "E:\\crome driver\\chromedriver-win64\\chromedriver.exe");

        // 2️⃣ Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 3️⃣ Open Daraz.pk
        driver.get("https://www.daraz.pk/");

        // 4️⃣ Initialize Page Objects
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        // 5️⃣ Search for electronics
        homePage.enterSearch("electronics");
        homePage.clickSearch();
        Thread.sleep(3000);

        // 6️⃣ Apply filters
        searchResultsPage.selectBrand();
        searchResultsPage.selectFreeDelivery();
        searchResultsPage.setPriceRange("500", "5000");
        Thread.sleep(3000);

        // 7️⃣ Open first product safely
        searchResultsPage.openFirstProduct();
        Thread.sleep(3000);

        // 8️⃣ Print delivery option
        System.out.println("Delivery Option: " + productPage.getDeliveryOption());

        // 9️⃣ Close browser
        driver.quit();
    }
}
