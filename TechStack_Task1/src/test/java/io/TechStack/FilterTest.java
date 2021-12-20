package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FilterTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;
    private static JavascriptExecutor js;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("searchResultPage"));
        js = (JavascriptExecutor) driver;


        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void FilterTest(){
        js.executeScript("window.scrollBy(0,1000)");
        searchResultPage.setFilterValue();
        Assert.assertEquals(TestResources.getProperty("isActive"), searchResultPage.DoesCheckboxValueIsActive().toString());
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
