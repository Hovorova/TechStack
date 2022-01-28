package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.MainPage;
import io.techstack.steps.MainSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ChangeLanguageAndCurrencyTest {
    private static MainPage mainPage;
    private static MainSteps mainSteps;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(driver);
        mainSteps = new MainSteps(driver);
    }

    @Test
    public void changeLanguageTest() {
        String language = "Polski";
        MainSteps.givenUserChangesLanguage(language);
        MainSteps.thenUserHasChangedLanguage(language);

    }

    @Test
    public void changeCurrencyTest() {
        MainSteps.givenUserChangesCurrency("Dollar");
        MainSteps.thenUserHasChangedCurrency();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
