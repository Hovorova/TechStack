package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EnteringInfoFormFillingTest {
    private static EnterYourInfoToBookTheRoomPage enterYourInfoToBookTheRoomPage;
    private static FinalStepPage finalStepPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("bookFormPage"));

        enterYourInfoToBookTheRoomPage = new EnterYourInfoToBookTheRoomPage(driver);
        finalStepPage = new FinalStepPage(driver);
    }

    @Test
    public void SelectRoomForBookibgTest(){
        enterYourInfoToBookTheRoomPage.FillTheBookForm();
        String DoesAdressFormAppear = finalStepPage.ConfirmUserFillBookForm().toString();
        Assert.assertEquals(TestResources.getProperty("confirm"),DoesAdressFormAppear );
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
