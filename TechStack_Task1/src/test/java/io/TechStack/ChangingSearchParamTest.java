package io.TechStack;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChangingSearchParamTest {
    private static SearchResultPage searchResultPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("searchResultPage"));

        searchResultPage = new SearchResultPage(driver);
    }
    @Test
    public void ChangingSearchParam(){
        searchResultPage.ChangeParam();
        Assert.assertEquals(TestResources.getProperty("titleAfterChanges"), searchResultPage.getTitleAfterChangingParam());
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
