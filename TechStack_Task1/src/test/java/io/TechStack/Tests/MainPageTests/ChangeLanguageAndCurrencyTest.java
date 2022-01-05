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
    }

    @Test
    public void ChangeLanguageTestToEng(){
        driver.get(TestResources.getProperty("mainPage"));
        mainPage =  new MainPage(driver);
        mainPage.ChangeLanguageToEng();
        Assert.assertEquals(TestResources.getProperty("titleLanguage"), driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")).getText());
    }

    @Test
    public void ChangeCurrencyToEuro(){
        driver.get(TestResources.getProperty("mainPage"));
        mainPage =  new MainPage(driver);
        mainPage.ChangeCurrencyToEuro();
        Assert.assertEquals("EUR\n" + "Выберите валюту. Текущая валюта — Евро", driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[1]/button")).getText());

    }

    @Test
    public void ChangeLanguageTest(){
        driver.get(TestResources.getProperty("mainPage"));
        mainPage =  new MainPage(driver);
        mainPage.ChangeLanguage();
        Assert.assertEquals(TestResources.getProperty("polski"), driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")).getText());

    }

    @Test
    public void ChangeCurrencyTest(){
        driver.get(TestResources.getProperty("mainPage"));
        mainPage =  new MainPage(driver);
        mainPage.ChangeCurrency();
        Assert.assertEquals("USD\n" + "Выберите валюту. Текущая валюта — Доллар США", driver.findElement(By.xpath("//*[@id=\"b2indexPage\"]/header/nav[1]/div[2]/div[1]/button")).getText());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
