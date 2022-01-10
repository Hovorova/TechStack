package io.TechStack.Tests.BookingARoomTests;

import io.TechStack.BeforeActionAndTestResources.DriverHelper;
import io.TechStack.BeforeActionAndTestResources.TestResources;
import io.TechStack.Pages.EnterYourInfoToBookTheRoomPage;
import io.TechStack.Pages.FinalStepPage;
import io.TechStack.Pages.HotelPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SelectRoomForBookingAndFillingFormTest {
    private static HotelPage hotelPage;
    private static EnterYourInfoToBookTheRoomPage enterYourInfoToBookTheRoomPage;
    private static FinalStepPage finalStepPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void SelectRoomTest() {
        driver.get(TestResources.getProperty("hotelPage"));
        hotelPage = new HotelPage(driver);
        enterYourInfoToBookTheRoomPage = new EnterYourInfoToBookTheRoomPage(driver);
        hotelPage.handleDropDownListAndSubmitReserve();
        String DoesBookFormAppear = enterYourInfoToBookTheRoomPage.ConfirmUserHasSelectedTheRoom().toString();
        Assert.assertEquals(TestResources.getProperty("confirm"), DoesBookFormAppear);
    }

    @Test
    public void FillingBookingFormTest(){
        driver.get(TestResources.getProperty("bookFormPage"));
        enterYourInfoToBookTheRoomPage = new EnterYourInfoToBookTheRoomPage(driver);
        finalStepPage = new FinalStepPage(driver);
        enterYourInfoToBookTheRoomPage.FillTheBookForm();
        Assert.assertTrue(finalStepPage.ConfirmUserFillBookForm());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
