package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.MainPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ChangeLanguageAndCurrencyTest {
    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(driver);
        WaitUtils.implicitWait(driver);
    }

    @Test
    public void changeLanguageTest() {
        mainPage.changeLanguage("Polski");
        String currentLanguage = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")).getText();
        assertEquals(TestResources.getProperty("polski"), currentLanguage);

    }

    @Test
    public void changeCurrencyTest() {
        mainPage.changeCurrency("Dollar");
        String currentCurrency = driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[1]/button")).getText();
        assertEquals("USD\n" + "Выберите валюту. Текущая валюта — Доллар США", currentCurrency);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
