package io.techstack.tests.searchPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.SearchResultPage;
import io.techstack.steps.SearchPageSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SortAndFilterTests {
    private static SearchResultPage searchResultPage;
    private static SearchPageSteps searchPageSteps;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
        searchPageSteps = new SearchPageSteps(driver);
    }

    @Test
    public void sortByLowerPriceTest() {
        SearchPageSteps.givenUserClickOnSortFromLowestPrice();
        SearchPageSteps.thenButtonSortFromLowestPriceIsEnable();
    }

    @Test
    public void filterSetYourBudgetTest() {
        SearchPageSteps.givenUserUseFilterSetYourOwnBudget();
        SearchPageSteps.thenBoundariesOfBudgetIsDispayed();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
