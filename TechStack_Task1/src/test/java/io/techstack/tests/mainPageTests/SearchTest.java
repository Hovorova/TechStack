package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.components.DriverWrapper;
import io.techstack.pages.MainPage;
import io.techstack.steps.MainSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchTest {
    private static MainPage mainPage;
    private static MainSteps mainSteps;
    private static DriverWrapper driver;

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
        MainSteps.whenUserEnterCorrectDataInSearchInput(cityName, "2022-01-28", "2022-01-30");
        MainSteps.thenPageWithSearchResultAppears(cityName);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
