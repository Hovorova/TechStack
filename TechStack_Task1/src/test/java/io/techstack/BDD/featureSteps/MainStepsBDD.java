package io.techstack.BDD.featureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.MainPage;
import io.techstack.steps.MainSteps;

public class MainStepsBDD extends BaseSteps{
    private BaseSteps baseSteps;
    private static MainPage mainPage;
    private static MainSteps mainSteps;
    String cityName ="Kharkiv";

    public MainStepsBDD(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }

    @Given("User is on the main page")
    public void userIsOnTheMainPage() {
        baseSteps.getDriver().get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(getDriver());
        mainSteps = new MainSteps(baseSteps.getDriver());
    }

    @When("User enters correct data to search fields")
    public void userEntersCorrectDataToSearchFields() {
        MainSteps.whenUserEnterCorrectDataInSearchInput(cityName, "2022-02-25", "2022-02-27");
    }

    @Then("Search result page is appears")
    public void searchResultPageIsAppears() {
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
