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
    }

    @Test
    public void searchTest() {
        searchResultPage = new SearchResultPage(driver);
        mainPage.changeLanguage("English");
        mainPage.search("Kharkiv");
        assertTrue(driver.findElement(By.xpath(".//h1[@class='_30227359d _0db903e42']")).getText().contains("Kharkiv"));
    }

    @Test
    public void tagnameOfCityInputTest() {
        assertTrue(mainPage.elementInputCityTagnameAndAttribute());
    }

    @Test
    public void tagName() {
        WebElement cityInput = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        assertEquals("input", mainPage.getElementTagName(cityInput));
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
