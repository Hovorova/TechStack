package io.techstack.tests.searchPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ChangingSearchParamTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void changingSearchParam() {
        driver.get(TestResources.getProperty("searchResultPage"));
        driver.get(TestResources.getProperty("afterChangingParamPage"));
        searchResultPage = new SearchResultPage(driver);

        String cityName = "Kyiv";
        searchResultPage.changeParam(cityName);
        Assert.assertTrue(searchResultPage.verifyChangeParam(cityName));
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
