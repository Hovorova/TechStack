package io.TechStack;

import com.google.common.base.Verify;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v95.page.Page;

import javax.swing.*;
import java.time.Duration;

public class SearchPlacesTest {
    private static MainPage mainPage;
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(TestResources.getProperty("mainPage"));

        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void SearchTest(){
        mainPage.ChangeLanguage();
        mainPage.Search();
        Assert.assertEquals(TestResources.getProperty("correctSearch"), searchResultPage.getCurrentStatusOfPage());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
