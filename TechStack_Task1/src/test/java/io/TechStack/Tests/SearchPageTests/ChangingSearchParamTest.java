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

public class ChangingSearchParamTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void ChangingSearchParam() {
        driver.get(TestResources.getProperty("searchResultPage"));
        driver.get(TestResources.getProperty("afterChangingParamPage"));
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.ChangeParam();
        Assert.assertTrue(searchResultPage.verifyChangeParam());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
