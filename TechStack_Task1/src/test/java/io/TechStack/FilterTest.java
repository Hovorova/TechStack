package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FilterTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;
    private static Actions action;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("searchResultPage"));

        action = new Actions(driver);

        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void FilterTest(){
        searchResultPage.SetBudget();
        String DoesUserSetBudget = searchResultPage.ConfirmUserSetBudget().toString();
        Assert.assertEquals(TestResources.getProperty("confirm"), DoesUserSetBudget);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
