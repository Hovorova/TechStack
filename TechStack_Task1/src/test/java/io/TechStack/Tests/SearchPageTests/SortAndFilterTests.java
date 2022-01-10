package io.TechStack.Tests.SearchPageTests;

import io.TechStack.BeforeActionAndTestResources.DriverHelper;
import io.TechStack.BeforeActionAndTestResources.TestResources;
import io.TechStack.Pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SortAndFilterTests {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void SortByLowerPriceTest() {
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.SortByPrice();
        Assert.assertTrue(searchResultPage.ButtonFromLowestPriceIsEnabled());
    }

    @Test
    public void FilterSetYourBudgetTest() {
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.SetBudget();
        Assert.assertTrue(searchResultPage.ConfirmUserSetBudget());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
        }
}
