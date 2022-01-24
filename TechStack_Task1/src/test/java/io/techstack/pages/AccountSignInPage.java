package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AccountSignInPage {

    @FindBy(xpath = ".//button[contains(@class,'sign-in-without-pass')]")
    private WebElement sendPassword;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement submitPasswordButton;

    @FindBy(xpath = ".//iframe[@title='Human verification challenge']")
    private WebElement pressAndHoldButtonImNotARobot;

    private WebDriver driver;

    public AccountSignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MainPage enterPassword(String password){
        passwordInput.sendKeys(password);
        submitPasswordButton.click();
        return new MainPage(driver);
    }

    public void handleImNotARobot(){
        if(pressAndHoldButtonImNotARobot.isDisplayed()){
            Actions action = new Actions(driver);
            action.clickAndHold(pressAndHoldButtonImNotARobot).build().perform();
        }
    }
}