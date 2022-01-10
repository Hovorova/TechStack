package io.TechStack.Tests.SearchPageTests;

import io.TechStack.BeforeActionAndTestResources.DriverHelper;
import io.TechStack.BeforeActionAndTestResources.TestResources;
import io.TechStack.Pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class AddToFavoriteTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void AddToFavTest(){
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.AddToFavorites();
        Assert.assertTrue(driver.findElement(By.linkText("My next trip")).isDisplayed());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
