package io.techstack.tests.searchPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

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
        searchResultPage.getAddToFavouriteIcon().click();
        Assert.assertTrue(searchResultPage.getSuccesfullyAddedToFavoritesBanner().isDisplayed());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
