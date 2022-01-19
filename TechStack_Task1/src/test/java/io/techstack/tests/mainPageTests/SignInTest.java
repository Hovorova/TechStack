package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.beforeActionAndTestResources.WaitUtils;
import io.techstack.pages.AccountSignInPage;
import io.techstack.pages.MainPage;
import io.techstack.pages.SignInPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class SignInTest {
    private static SignInPage signInPage;
    private static AccountSignInPage accountSignInPage;
    private static MainPage mainpage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        driver.get(TestResources.getProperty("mainPage"));
        mainpage = new MainPage(driver);
        WaitUtils.implicitWait(driver);
    }

    @Test
    public void signInTest() {
        driver.get(TestResources.getProperty("signInPage"));
        driver.get(TestResources.getProperty("accountSignInPage"));
        accountSignInPage = new AccountSignInPage(driver);
        signInPage = new SignInPage(driver);
        signInPage.enterEmail(TestResources.getProperty("email"));
        signInPage.getContinueWithEmailButton().click();
        assertTrue(accountSignInPage.getLinkSentUnit().isSelected() || accountSignInPage.getSendPassword().isDisplayed());
    }

    @Test
    public void destinationBetweenButtonShouldBeEquals() {
        WebElement signInButton = mainpage.getSignInButton();
        WebElement listYourPropertyButton = mainpage.getListYourProperty();
        WebElement registerButton = mainpage.getRegisterButton();
        if (signInButton.getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) {
            assertTrue(mainpage.isDistanceBetweenButtonsEqual(signInButton, listYourPropertyButton, registerButton));
        }
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
