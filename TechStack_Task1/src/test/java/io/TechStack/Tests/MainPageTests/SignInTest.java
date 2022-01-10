package io.TechStack.Tests.MainPageTests;

import io.TechStack.BeforeActionAndTestResources.DriverHelper;
import io.TechStack.BeforeActionAndTestResources.TestResources;
import io.TechStack.Pages.AccountSignInPage;
import io.TechStack.Pages.MainPage;
import io.TechStack.Pages.SignInPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class SignInTest {
    private static SignInPage signInPage;
    private static AccountSignInPage accountSignInPage;
    private static MainPage mainpage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void signInTest(){
        driver.get(TestResources.getProperty("signInPage"));
        driver.get(TestResources.getProperty("accountSignInPage"));
        accountSignInPage = new AccountSignInPage(driver);
        signInPage = new SignInPage(driver);
        signInPage.enterEmail(TestResources.getProperty("email"));
        signInPage.signIn();
        Assert.assertTrue(accountSignInPage.ConfirmSignIn());
    }

    @Test
    public void getSizeAndLocationOfSignInButtonTest(){
        driver.get(TestResources.getProperty("mainPage"));
        mainpage = new MainPage(driver);
        if(mainpage.getCssValueOfSignInButton().equals ("rgba(255, 255, 255, 1)")) {
            Assert.assertEquals(new Point(1159, 18), mainpage.getLocationOfSignInButton());
            Assert.assertEquals(new Dimension(138, 36), mainpage.getSizeOfSignInButton());
        }
        else {
            System.out.println("The SignIn button is not expected color");
        }
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
