package io.TechStack.Tests.MainPageTests;

import io.TechStack.BeforeActionAndTestResources.DriverHelper;
import io.TechStack.BeforeActionAndTestResources.TestResources;
import io.TechStack.Pages.MainPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeLanguageAndCurrencyTest {
    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainPage =  new MainPage(driver);
    }

    @Test
    public void ChangeLanguageTest(){
        mainPage.ChangeLanguage("Polski");
        String currentLanguage =  driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")).getText();
        Assert.assertEquals(TestResources.getProperty("polski"),currentLanguage);

    }

    @Test
    public void ChangeCurrencyTest(){
        mainPage.ChangeCurrency("Dollar");
        String currentCurrency = driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[1]/button")).getText();
        Assert.assertEquals("USD\n" + "Выберите валюту. Текущая валюта — Доллар США", currentCurrency);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
