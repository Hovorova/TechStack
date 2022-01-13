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
import org.openqa.selenium.*;

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
        WebElement SignInButton = driver.findElement(By.cssSelector("#b2indexPage > header > nav.bui-header__bar > div.bui-group.bui-button-group.bui-group--inline.bui-group--align-end.bui-group--vertical-align-middle > div:nth-child(6) > a"));
        if(SignInButton.getCssValue("background-color").equals ("rgba(255, 255, 255, 1)")) {
            Assert.assertEquals(new Point(1159, 18), mainpage.getLocationOfSignInButton());
            Assert.assertEquals(new Dimension(138, 36), mainpage.getSizeOfSignInButton());
        }
        else {
            System.out.println("The SignIn button is not expected color");
        }
    }

    @Test
    public void DistanitionBetweenButtonIsEquals(){
        Assert.assertTrue(mainpage.DistanceBetweenButtons());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
