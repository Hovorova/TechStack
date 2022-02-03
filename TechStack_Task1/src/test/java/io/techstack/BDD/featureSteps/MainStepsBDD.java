package io.techstack.BDD.featureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.steps.MainSteps;

public class MainStepsBDD extends BaseSteps {
    private BaseSteps baseSteps;
    private static MainSteps mainSteps;

    public MainStepsBDD(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        mainSteps = new MainSteps(baseSteps.getDriver());
    }

    @Given("User is on the main page")
    public void userIsOnTheMainPage() {
        baseSteps.getDriver().get(TestResources.getProperty("mainPage"));
    }

    @When("User enters correct data to search fields: {string}, {string} and {string}")
    public void userEntersCorrectDataToSearchFieldsCityNameDateCheckInAndDateCheckOut(String cityName, String dateCheckIn, String dateCheckOut) {
        MainSteps.whenUserEnterCorrectDataInSearchInput(cityName, dateCheckIn, dateCheckOut);
    }

    @Then("Search result page is appears with {string} in title")
    public void searchResultPageIsAppearsWithCityNameInTitle(String cityName) {
        MainSteps.thenPageWithSearchResultAppears(cityName);
    }

    @When("User sign in")
    public void userSignIn() {
        MainSteps.whenUserSignInWithTheCreatedAccount();
    }

    @Then("Username is on the top of the page")
    public void usernameIsOnTheTopOfThePage() {
        MainSteps.thenUserNameIsDisplayedInTheTopOfThePage();
    }

    @When("User changes language to {string}")
    public void userChangesLanguageToLanguage(String language) {
        MainSteps.whenUserChangesLanguage(language);
    }

    @Then("Current language is {string}")
    public void currentLanguageIsLanguage(String language) {
        MainSteps.thenUserHasChangedLanguage(language);
    }
}
