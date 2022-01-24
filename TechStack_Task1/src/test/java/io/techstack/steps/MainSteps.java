package io.techstack.steps;

import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.AccountSignInPage;
import io.techstack.pages.MainPage;
import io.techstack.pages.SignInPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MainSteps {
    private static SignInPage signInPage;
    private static AccountSignInPage accountSignInPage;
    private static MainPage mainpage;
    private static WebDriver driver;

    public MainSteps(WebDriver driver) {
        this.driver = driver;
        mainpage = new MainPage(driver);
    }

    public static void givenUserSignInWithTheCreatedAccount() {
        driver.get(TestResources.getProperty("mainPage"));
        signInPage = mainpage.signIn();
        accountSignInPage = signInPage.enterEmail(TestResources.getProperty("email"));
        WaitUtils.waitForElementToBeVisible(driver, accountSignInPage.getPasswordInput());
        mainpage = accountSignInPage.enterPassword(TestResources.getProperty("password"));
    }

    public static void thenUserNameIsDisplayedInTheTopOfThePage() {
        assertTrue(accountSignInPage.getSendPassword().isDisplayed() || mainpage.IsUserSignedIn("Firstname Lastname"));
    }
}