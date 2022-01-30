package io.techstack.BDD.featureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchResultSteps {
    private  static WebDriver driver;
    private static SearchResultPage searchResultPage;

    @Given("User is on the search result page")
    public void userIsOnTheSearchResultPage() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("searchResultPage"));
        searchResultPage = new SearchResultPage(driver);
    }

    @When("User add hotel to the favorites")
    public void userAddHotelToTheFavorites(){
        searchResultPage.getAddToFavouriteIcon().click();
    }

    @Then("Succesfulbanner is displayed")
    public void succesfulbannerIsDisplayed(){
        WaitUtils.fluentWaitElementToBeVisible(driver, searchResultPage.getSuccesfullyAddedToFavoritesBanner());
        assertTrue(searchResultPage.getSuccesfullyAddedToFavoritesBanner().isDisplayed());
        driver.close();
    }

    @When("User click on sort from lowest price button")
    public void userClickOnSortFromLowestPriceButton(){
        WaitUtils.waitForElementToBeClickable(driver, searchResultPage.getSortFromLowestPrice());
        searchResultPage.getSortFromLowestPrice().click();
    }

    @Then("Sort from lowest price button is enabled")
    public void sortFromLowestPriceButton(){
        assertTrue(searchResultPage.getSortFromLowestPrice().isEnabled());
        driver.close();
    }
}
