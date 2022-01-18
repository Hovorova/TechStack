package io.techstack.tests.bookingARoomTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.EnterYourInfoToBookTheRoomPage;
import io.techstack.pages.FinalStepPage;
import io.techstack.pages.HotelPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SelectRoomForBookingAndFillingFormTest {
    private static HotelPage hotelPage;
    private static EnterYourInfoToBookTheRoomPage enterYourInfoToBookTheRoomPage;
    private static FinalStepPage finalStepPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        WaitUtils.implicitWait(driver);
    }

    @Test
    public void selectRoomTest() {
        driver.get(TestResources.getProperty("hotelPage"));
        hotelPage = new HotelPage(driver);
        enterYourInfoToBookTheRoomPage = new EnterYourInfoToBookTheRoomPage(driver);
        hotelPage.handleDropDownListAndSubmitReserve();
        assertTrue(enterYourInfoToBookTheRoomPage.confirmUserHasSelectedTheRoom());
    }

    @Test
    public void fillingBookingFormTest() {
        driver.get(TestResources.getProperty("bookFormPage"));
        enterYourInfoToBookTheRoomPage = new EnterYourInfoToBookTheRoomPage(driver);
        finalStepPage = new FinalStepPage(driver);
        enterYourInfoToBookTheRoomPage.fillTheBookForm();
        assertTrue(finalStepPage.confirmUserFillBookForm());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
