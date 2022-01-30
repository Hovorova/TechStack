package io.techstack.BDD.featureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.EnterYourInfoToBookTheRoomPage;
import io.techstack.pages.FinalStepPage;
import io.techstack.pages.HotelPage;
import io.techstack.valueObjects.User;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class HotelSteps {
    private  static WebDriver driver;
    private static HotelPage hotelPage;
    private static EnterYourInfoToBookTheRoomPage enterYourInfoToBookTheRoomPage;
    private static FinalStepPage finalStepPage;

    @Given("User is on the hotel page")
    public void userIsOnTheHotelPage() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("hotelPage"));
        hotelPage = new HotelPage(driver);
    }

    @When("User pick a room and fill UserInfo form")
    public void userPickARoomAndFillUserInfoForm() {
        User user = User.builder().withFirstName("Firstname").withLastName("Lastname").withEmail("testegmail@gmail.com").build();
        WaitUtils.waitForElementToBeVisible(driver, hotelPage.getHotelGallery());
        enterYourInfoToBookTheRoomPage = hotelPage.handleDropDownListAndSubmitReserve();
        finalStepPage = enterYourInfoToBookTheRoomPage.fillTheBookForm(user);
    }

    @Then("User is on the finalStep page and succesfulbanner is displayed")
    public void userIsOnTheFinalStepPageAndSuccessfulbannerIsDisplayed() {
        assertTrue(finalStepPage.getSuccessfulBanner().isDisplayed());
        driver.close();
    }
    @After
    public void teardown(){
        driver.close();
    }
}
