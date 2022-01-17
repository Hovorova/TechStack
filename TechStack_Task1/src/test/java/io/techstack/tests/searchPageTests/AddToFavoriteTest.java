package io.techstack.tests.searchPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToFavoriteTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        WaitUtils.implicitWait(driver);
    }

    @Test
    public void addToFavTest() {
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
        WebElement addToFavoriteButton = driver.findElement(By.xpath(".//button[@data-testid='wishlist-button']"));
        // WaitUtils.fluentWaitElementToBeVisible(driver, addToFavoriteButton);
        addToFavoriteButton.click();
        WebElement savedToFavoritteMessage = driver.findElement(By.xpath(".//div[@data-testid='wishlist-popover-content']"));
        // WaitUtils.fluentWaitElementToBeVisible(driver, savedToFavoritteMessage );
        Assert.assertTrue(savedToFavoritteMessage.isDisplayed());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
