package io.techstack.tests.searchPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.pages.SearchResultPage;
import io.techstack.steps.SearchPageSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ChangingSearchParamTest {
    private static SearchResultPage searchResultPage;
    private static SearchPageSteps searchPageSteps;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        searchResultPage = new SearchResultPage(driver);
        searchPageSteps = new SearchPageSteps(driver);
    }

    @Test
    public void changingSearchParam() {
        String cityName = "Kyiv";
        SearchPageSteps.changingSearchParamOnSearchResultPage(cityName);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
