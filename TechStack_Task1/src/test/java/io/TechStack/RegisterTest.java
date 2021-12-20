package io.TechStack;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Ignore
public class RegisterTest {
    private static RegisterPage registerPage;
    private static AccountRegisterPage accountRegisterPage;

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("registerPage"));
        driver.get(TestResources.getProperty("accountRegisterPage"));

        registerPage = new RegisterPage(driver);
        accountRegisterPage = new AccountRegisterPage(driver);
    }

    @Test
    public void RegisterTest() {
        registerPage.enterEmail(TestResources.getProperty("email"));
        accountRegisterPage.EnterPassword();
        String DoesMessageYouAreNotRobotAppears = accountRegisterPage.ConfirmRegister().toString();
        Assert.assertEquals(TestResources.getProperty("confirm"), DoesMessageYouAreNotRobotAppears);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
