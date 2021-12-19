package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class SignInTest {
    private static MainPage mainPage;
    private static SignInPage signInPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("signInPage"));

        mainPage = new MainPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void signInTest(){
        signInPage.enterEmail(TestResources.getProperty("email"));
        signInPage.signIn();
        Assert.assertEquals(TestResources.getProperty("username"), mainPage.getUserName());
    }

    @AfterClass
    public static void teardown(){
        mainPage.logout();
        driver.quit();
    }
}
