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
    private static SignInPage signInPage;
    private static AccountSignInPage accountSignInPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("signInPage"));
        driver.get(TestResources.getProperty("accountSignInPage"));

        accountSignInPage = new AccountSignInPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void signInTest(){
        signInPage.enterEmail(TestResources.getProperty("email"));
        signInPage.signIn();
        String DoesMessageAppearce = accountSignInPage.ConfirmSignIn().toString();
        Assert.assertEquals(TestResources.getProperty("confirm"),DoesMessageAppearce );
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
