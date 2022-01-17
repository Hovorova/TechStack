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

public class AddToFavoriteTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void addToFavTest() {
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
        WebElement addToFavoriteButton = searchResultPage.getAddToFavouriteButton();
        WaitUtils.fluentWaitElementToBeVisible(driver, addToFavoriteButton);
        addToFavoriteButton.click();
        WebElement savedToFavoriteMessage = searchResultPage.getSuccesfullyAddedToFavoritesBanner();
        WaitUtils.fluentWaitElementToBeVisible(driver, savedToFavoriteMessage );
        Assert.assertTrue(savedToFavoriteMessage.isDisplayed());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
