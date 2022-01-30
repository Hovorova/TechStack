package io.techstack.BDD.featureSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.AccountSignInPage;
import io.techstack.pages.MainPage;
import io.techstack.pages.SearchResultPage;
import io.techstack.pages.SignInPage;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MainSteps {
    private  static WebDriver driver;
    private static MainPage mainPage;
    private static SearchResultPage searchResultPage;
    private static SignInPage signInPage;
    private static AccountSignInPage accountSignInPage;
    String cityName ="Kharkiv";

    @Given("User is on the main page")
    public void userIsOnTheMainPage() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainPage = new MainPage(driver);
    }

    @When("User enters correct data to search fields")
    public void userEntersCorrectDataToSearchFields() {
        mainPage.searchInput(cityName);
        driver.findElement(By.xpath(mainPage.createXpathForCheckInAndCheckOutDate("2022-02-25"))).click();
        driver.findElement(By.xpath(mainPage.createXpathForCheckInAndCheckOutDate("2022-02-27"))).click();
        searchResultPage = mainPage.confirmSearch();
    }

    @Then("Search result page is appears")
    public void searchResultPageIsAppears() {
        assertTrue(searchResultPage.getTitleWithCityName().getText().contains(cityName));
        driver.close();
    }

    @When("User sign in")
    public void userSignIn() {
        signInPage = mainPage.signIn();
        accountSignInPage = signInPage.enterEmail(TestResources.getProperty("email"));
        WaitUtils.waitForElementToBeVisible(driver, accountSignInPage.getSendPassword());
        mainPage = accountSignInPage.enterPassword(TestResources.getProperty("password"));
    }

    @Then("Username is on the top of the page")
    public void usernameIsOnTheTopOfThePage() {
        assertTrue(accountSignInPage.getSendPassword().isDisplayed() || mainPage.IsUserSignedIn("Firstname Lastname"));
        driver.close();
    }

    @When("User changes language to {string}")
    public void userChangesLanguageToLanguage(String language) {
        mainPage.changeLanguage(language);
    }

    @Then("Current language is {string}")
    public void currentLanguageIsLanguage(String language) {
        assertTrue(mainPage.confirmTheLanguageHasChanged(language));
        driver.close();
    }

    @After
    public void teardown(){
        driver.close();
    }
}
