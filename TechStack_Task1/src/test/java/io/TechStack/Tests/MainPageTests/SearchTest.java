package io.TechStack.Tests.MainPageTests;

import io.TechStack.BeforeActionAndTestResources.DriverHelper;
import io.TechStack.BeforeActionAndTestResources.TestResources;
import io.TechStack.Pages.MainPage;
import io.TechStack.Pages.SearchResultPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchTest {
    private static MainPage mainPage;
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void SearchTest(){
        driver.get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        mainPage.ChangeLanguage("English");
        mainPage.Search();
        String searchResult = driver.findElement(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[1]/div/div/div/nav/ol/li[5]/span/a/span")).getText();
        Assert.assertEquals(TestResources.getProperty("correctSearch"), searchResult);
    }

    @Test
    public void CheckTagnameOfWhereAreYouGoingFieldTest(){
        driver.get(TestResources.getProperty("mainPage"));
        mainPage =  new MainPage(driver);
        Assert.assertEquals(true, mainPage.IsInputWhereAreYouGoingFieldTagname());
        Assert.assertEquals(true, mainPage.IsInputWhereareYouGoingFieldAttribute());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
