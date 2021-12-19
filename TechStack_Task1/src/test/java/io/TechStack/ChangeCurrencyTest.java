package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChangeCurrencyTest {
    private static MainPage mainPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("mainPage"));

        mainPage = new MainPage(driver);
    }

    @Test
    public void ChangeCurrencyTest(){
        mainPage.ChangeCurrency();
        Assert.assertEquals(TestResources.getProperty("currentCurrency"), mainPage.getCurrentCurrency());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
