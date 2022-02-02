package io.techstack.pages;

import io.techstack.components.DriverWrapper;
import io.techstack.components.buttons.Button;
import io.techstack.components.inputs.Input;
import lombok.Getter;
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

    @FindBy(xpath = ".//iframe[@title='Human verification challenge']")
    private WebElement pressAndHoldButtonImNotARobot;

    private DriverWrapper driver;

    public AccountSignInPage(DriverWrapper driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MainPage enterPassword(String password){
        driver.getComponent(Input.class, "password").sendKeys(password);
        driver.getComponent(Button.class, "submit").click();
        return new MainPage(driver);
    }

    public void handleImNotARobot(){
        if(pressAndHoldButtonImNotARobot.isDisplayed()){
            Actions action = new Actions(driver);
            action.clickAndHold(pressAndHoldButtonImNotARobot).build().perform();
        }
    }
}
