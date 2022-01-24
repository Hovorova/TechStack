package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.MainPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ChangeLanguageAndCurrencyTest {
    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(driver);
    }

    @Test
    public void changeLanguageTest() {
        mainPage.changeLanguage("Polski");
        assertEquals(TestResources.getProperty("polski"), mainPage.getSearchButton().getText());

    }

    @Test
    public void changeCurrencyTest() {
        mainPage.changeCurrency("Dollar");
        assertEquals("USD\n" + "Choose your currency. Your current currency is U.S. dollar", mainPage.getChangeCurrencyButton().getText());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
