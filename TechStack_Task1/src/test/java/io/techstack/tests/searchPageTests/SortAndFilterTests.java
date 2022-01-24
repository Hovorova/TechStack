package io.techstack.tests.searchPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class SortAndFilterTests {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void sortByLowerPriceTest() {
        WaitUtils.waitForElementToBeClickable(driver, searchResultPage.getSortFromLowestPrice());
        searchResultPage.getSortFromLowestPrice().click();
        assertTrue(searchResultPage.getSortFromLowestPrice().isEnabled());
    }

    @Test
    public void filterSetYourBudgetTest() {
        searchResultPage.setBudget();
        assertTrue(searchResultPage.getSelectedBudgetInfo().isDisplayed());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
