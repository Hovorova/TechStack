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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

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
    }

    @Test
    public void signInTest() {
        driver.get(TestResources.getProperty("signInPage"));
        driver.get(TestResources.getProperty("accountSignInPage"));
        accountSignInPage = new AccountSignInPage(driver);
        signInPage = new SignInPage(driver);
        signInPage.enterEmail(TestResources.getProperty("email"));
        if(driver.getCurrentUrl() == TestResources.getProperty("signInEnterPassword")){
            driver.findElement(By.xpath(".//input[@name='new_password']")).sendKeys("testPassword123");
            driver.findElement(By.xpath(".//input[@name='confirmed_password']")).sendKeys("testPassword123");
            assertTrue(driver.findElement(By.xpath(".//div[@class='bui-avatar-block']")).isDisplayed());
        }else {
            signInPage.signIn();
            assertTrue(accountSignInPage.confirmSignIn());
        }
    }

    @Test
    public void destinationBetweenButtonShouldBeEquals() {
        ArrayList<WebElement> mainMenuButtons = new ArrayList<WebElement>();
        WebElement signInButton = mainpage.getSignInButton();
        WebElement listYourPropertyButton = mainpage.getListYourProperty();
        WebElement registerButton = mainpage.getRegisterButton();
        mainMenuButtons.add(signInButton);
        mainMenuButtons.add(listYourPropertyButton);
        mainMenuButtons.add(registerButton);
        WaitUtils.waitForAllElementsToBeVisible(driver, mainMenuButtons);
        if (signInButton.getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) {
            assertTrue(mainpage.isDistanceBetweenButtonsEqual(signInButton, listYourPropertyButton, registerButton));
        }
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
