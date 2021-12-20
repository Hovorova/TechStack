package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChangingSearchParamTest {
    private static SearchResultPage searchResultPage;
    private static ChangeSearchParamPage changeSearchParamPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("searchResultPage"));
        driver.get(TestResources.getProperty("afterChangingParamPage"));

        searchResultPage = new SearchResultPage(driver);
        changeSearchParamPage = new ChangeSearchParamPage(driver);
    }

    @Test
    public void ChangingSearchParam() {
        searchResultPage.ChangeParam();
        changeSearchParamPage.getTitleAfterChangingParam();
        Assert.assertEquals(TestResources.getProperty("titleAfterChanges"), changeSearchParamPage.getTitleAfterChangingParam());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
