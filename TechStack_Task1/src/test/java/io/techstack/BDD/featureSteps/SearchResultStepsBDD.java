package io.techstack.BDD.featureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.SearchResultPage;
import io.techstack.steps.SearchPageSteps;

public class SearchResultStepsBDD extends BaseSteps {
    private BaseSteps baseSteps;
    private static SearchResultPage searchResultPage;
    private static SearchPageSteps searchPageSteps;

    public SearchResultStepsBDD(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        searchResultPage = new SearchResultPage(getDriver());
        searchPageSteps = new SearchPageSteps(baseSteps.getDriver());
    }

    @Given("User is on the search result page")
    public void userIsOnTheSearchResultPage() {
        baseSteps.getDriver().get(TestResources.getProperty("searchResultPage"));
    }

    @When("User add hotel to the favorites")
    public void userAddHotelToTheFavorites(){
        SearchPageSteps.whenUserAddsHotelToFavorites();
    }

    @Then("Succesfulbanner is displayed")
    public void succesfulbannerIsDisplayed(){
        SearchPageSteps.thenSuccessfulBannerIsDisplayed();
    }

    @When("User click on sort from lowest price button")
    public void userClickOnSortFromLowestPriceButton(){
        SearchPageSteps.whenUserClickOnSortFromLowestPrice();
    }

    @Then("Sort from lowest price button is enabled")
    public void sortFromLowestPriceButton(){
        SearchPageSteps.thenButtonSortFromLowestPriceIsEnable();
    }
}
