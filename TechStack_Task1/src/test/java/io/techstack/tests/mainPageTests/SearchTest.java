package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.MainPage;
import io.techstack.pages.SearchResultPage;
import io.techstack.steps.MainSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchTest {
    private static MainPage mainPage;
    private static SearchResultPage searchResultPage;
    private static MainSteps mainSteps;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(driver);
        mainSteps = new MainSteps(driver);
        WaitUtils.waitForElementToBeVisible(driver, mainPage.getMainMenu());
    }

    @Test
    public void searchTest() {
        String cityName = "Kharkiv";
        MainSteps.givenUserEnterCorrectDataInSearchInput(cityName);
        MainSteps.thenPageWithSearchResultAppears(cityName);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
