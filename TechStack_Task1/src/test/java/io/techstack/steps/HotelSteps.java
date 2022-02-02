package io.techstack.steps;

import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.components.DriverWrapper;
import io.techstack.pages.EnterYourInfoToBookTheRoomPage;
import io.techstack.pages.FinalStepPage;
import io.techstack.pages.HotelPage;
import io.techstack.valueObjects.User;

import static org.junit.Assert.assertTrue;

public class HotelSteps {
    private static HotelPage hotelPage;
    private static EnterYourInfoToBookTheRoomPage enterYourInfoToBookTheRoomPage;
    private static FinalStepPage finalStepPage;
    private static DriverWrapper driver;

    public HotelSteps(DriverWrapper driver) {
        this.driver = driver;
        hotelPage = new HotelPage(driver);
    }

    public static void whenUnloggedinUserBookingARoom() {
        User user = User.builder().withFirstName("Firstname").withLastName("Lastname").withEmail("testegmail@gmail.com").build();
        WaitUtils.waitForElementToBeVisible(driver, hotelPage.getHotelGallery());
        hotelPage = new HotelPage(driver);
        enterYourInfoToBookTheRoomPage = hotelPage.handleDropDownListAndSubmitReserve();
        finalStepPage = enterYourInfoToBookTheRoomPage.fillTheBookForm(user);
    }

    public static void thenSuccessfulBannerIsDisplayed() {
        assertTrue(finalStepPage.getSuccessfulBanner().isDisplayed());
    }
}
