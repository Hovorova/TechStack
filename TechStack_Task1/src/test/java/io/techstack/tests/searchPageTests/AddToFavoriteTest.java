package io.techstack.tests.searchPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.steps.SearchPageSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AddToFavoriteTest {
    private static SearchPageSteps searchPageSteps;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        searchPageSteps = new SearchPageSteps(driver);
    }

    @Test
    public void addToFavTest() {
        SearchPageSteps.whenUserAddsHotelToFavorites();
        SearchPageSteps.thenSuccessfulBannerIsDisplayed();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
