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

public class ChangingSearchParamTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        WaitUtils.implicitWait(driver);
    }

    @Test
    public void changingSearchParam() {
        driver.get(TestResources.getProperty("searchResultPage"));
        WaitUtils.waitForElementToBeVisible(driver, driver.findElement(By.xpath(".//form[@id='frm']")));
        driver.get(TestResources.getProperty("afterChangingParamPage"));
        searchResultPage = new SearchResultPage(driver);

        String cityName = "Kyiv";
        searchResultPage.changeParam(cityName);
        Assert.assertTrue(driver.findElement(By.xpath(".//h1[@class='_30227359d _0db903e42']")).getText().contains(cityName));
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
