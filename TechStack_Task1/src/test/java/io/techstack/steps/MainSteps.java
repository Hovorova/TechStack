package io.techstack.steps;

import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.components.DriverWrapper;
import io.techstack.pages.AccountSignInPage;
import io.techstack.pages.MainPage;
import io.techstack.pages.SearchResultPage;
import io.techstack.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainSteps {
    private static SignInPage signInPage;
    private static AccountSignInPage accountSignInPage;
    private static SearchResultPage searchResultPage;
    private static MainPage mainpage;
    private static DriverWrapper driver;

    public MainSteps(DriverWrapper driver) {
        this.driver = driver;
        mainpage = new MainPage(driver);
    }

    public static void whenUserSignInWithTheCreatedAccount() {
        driver.get(TestResources.getProperty("mainPage"));
        signInPage = mainpage.signIn();
        accountSignInPage = signInPage.enterEmail(TestResources.getProperty("email"));
        WaitUtils.waitForElementToBeVisible(driver, accountSignInPage.getPasswordInput());
        mainpage = accountSignInPage.enterPassword(TestResources.getProperty("password"));
    }

    public static void thenUserNameIsDisplayedInTheTopOfThePage() {
        assertTrue(accountSignInPage.getSendPassword().isDisplayed() || mainpage.IsUserSignedIn("Firstname Lastname"));
    }

    public static void whenUserChangesLanguage(String language) {
        driver.get(TestResources.getProperty("mainPage"));
        mainpage = new MainPage(driver);
        mainpage.changeLanguage(language);
    }

    public static void thenUserHasChangedLanguage(String language) {
        assertTrue(mainpage.confirmTheLanguageHasChanged(language));
    }

    public static void whenUserChangesCurrency(String currency) {
        driver.get(TestResources.getProperty("mainPage"));
        mainpage = new MainPage(driver);
        mainpage.changeCurrency(currency);
    }

    public static void thenUserHasChangedCurrency() {
        assertEquals("USD\n" + "Choose your currency. Your current currency is U.S. dollar", mainpage.getChangeCurrencyButton().getText());
    }

    public static void whenUserEnterCorrectDataInSearchInput(String cityName, String dateCheckIn, String dateCheckOut) {
        driver.get(TestResources.getProperty("mainPage"));
        mainpage = new MainPage(driver);
        if (mainpage.elementInputCityTagnameAndAttribute()) {
            searchResultPage = mainpage.search(cityName, dateCheckIn, dateCheckOut);
        }
    }

    public static void thenPageWithSearchResultAppears(String cityName) {
        assertTrue(searchResultPage.getTitleWithCityName().getText().contains(cityName));
    }

    public static void whenUserIsOnMainPage() {
        driver.get(TestResources.getProperty("mainPage"));
        mainpage = new MainPage(driver);
        WaitUtils.waitForElementToBeVisible(driver, mainpage.getMainMenu());
    }

    public static void thenPickThreeButtonsAndCheckIfDistanceBetweenThemIsEquals(WebElement button1, WebElement button2, WebElement button3) {
        assertTrue(mainpage.isDistanceBetweenButtonsEqual(button1, button2, button3));
    }
}