package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.MainPage;
import io.techstack.pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SearchTest {
    private static MainPage mainPage;
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(driver);
        WaitUtils.waitForElementToBeVisible(driver, mainPage.getMainMenu());
    }

    @Test
    public void searchTest() {
        if (mainPage.elementInputCityTagnameAndAttribute()) {
            mainPage.searchInput("Kharkiv");
            driver.findElement(By.xpath(mainPage.createXpathForCheckInAndCheckOutDate("2022-01-28"))).click();
            driver.findElement(By.xpath(mainPage.createXpathForCheckInAndCheckOutDate("2022-01-30"))).click();
            searchResultPage = mainPage.confirmSearch();
            assertTrue(searchResultPage.getTitleWithCityName().getText().contains("Kharkiv"));
        }
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
