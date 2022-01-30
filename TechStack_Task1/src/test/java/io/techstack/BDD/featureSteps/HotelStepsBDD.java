package io.techstack.BDD.featureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.HotelPage;
import io.techstack.steps.HotelSteps;

public class HotelStepsBDD extends BaseSteps {
    private BaseSteps baseSteps;
    private static HotelPage hotelPage;
    private static HotelSteps hotelSteps;

    public HotelStepsBDD(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @Given("User is on the hotel page")
    public void userIsOnTheHotelPage() {
        baseSteps.getDriver().get(TestResources.getProperty("hotelPage"));
        hotelPage = new HotelPage(getDriver());
        hotelSteps = new HotelSteps(baseSteps.getDriver());
    }

    @When("User pick a room and fill UserInfo form")
    public void userPickARoomAndFillUserInfoForm() {
        HotelSteps.whenUnloggedinUserBookingARoom();
    }

    @Then("User is on the finalStep page and succesfulbanner is displayed")
    public void userIsOnTheFinalStepPageAndSuccessfulbannerIsDisplayed() {
        HotelSteps.thenSuccessfulBannerIsDisplayed();
    }
}
