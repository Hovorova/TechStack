package io.TechStack;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SelectRoomForBookingTest {
    private static HotelPage hotelPage;
    private static EnterYourInfoToBookTheRoomPage enterYourInfoToBookTheRoomPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", TestResources.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(TestResources.getProperty("hotelPage"));

        hotelPage = new HotelPage(driver);
        enterYourInfoToBookTheRoomPage = new EnterYourInfoToBookTheRoomPage(driver);
    }

    @Test
    public void SelectRoomTest() {
        hotelPage.HandleDropDownListAndSubmitReserve();
        String DoesBookFormAppear = enterYourInfoToBookTheRoomPage.ConfirmUserHasSelectedTheRoom().toString();
        Assert.assertEquals(TestResources.getProperty("confirm"), DoesBookFormAppear);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
