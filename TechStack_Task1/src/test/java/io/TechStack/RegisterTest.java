package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Date;

public class RegisterTest {
    private static MainPage mainPage;
    private static RegisterPage registerPage;

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("registerPage"));

        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void RegisterTest(){
        registerPage.enterEmail(TestResources.getProperty("email"));
        registerPage.Register();
        Assert.assertEquals(TestResources.getProperty("username"), mainPage.getUserName());
    }

    @AfterClass
    public static void teardown(){
        mainPage.logout();
        driver.quit();
    }

}
