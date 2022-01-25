package io.techstack.tests.bookingARoomTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.EnterYourInfoToBookTheRoomPage;
import io.techstack.pages.FinalStepPage;
import io.techstack.pages.HotelPage;
import io.techstack.steps.HotelSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SelectRoomForBookingAndFillingFormTest {
    private static HotelSteps hotelSteps;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        hotelSteps = new HotelSteps(driver);
        driver.get(TestResources.getProperty("hotelPage"));
    }

    @Test
    public void selectRoomTest() {
        HotelSteps.givenUnloggedinUserBookingARoom();
        HotelSteps.thenSuccessfulBannerIsDisplayed();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
