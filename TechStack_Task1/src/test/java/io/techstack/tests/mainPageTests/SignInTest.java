package io.techstack.tests.mainPageTests;

import io.techstack.beforeActionAndTestResources.DriverHelper;
import io.techstack.beforeActionAndTestResources.TestResources;
import io.techstack.pages.MainPage;
import io.techstack.steps.MainSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignInTest {
    private static MainPage mainpage;
    private static MainSteps mainSteps;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
        mainSteps = new MainSteps(driver);
        driver.get(TestResources.getProperty("mainPage"));
        mainpage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        MainSteps.givenUserSignInWithTheCreatedAccount();
        MainSteps.thenUserNameIsDisplayedInTheTopOfThePage();
    }

    @Test
    public void destinationBetweenButtonShouldBeEquals() {
        MainSteps.givenUserIsOnMainPage();
        MainSteps.thenPickThreeButtonsAndCheckIfDistanceBetweenThemIsEquals(mainpage.getSignInButton(), mainpage.getRegisterButton(), mainpage.getListYourProperty());
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
