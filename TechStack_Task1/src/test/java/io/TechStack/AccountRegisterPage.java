package io.TechStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegisterPage {
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/form/button")
    private WebElement confirmRegisterButton;
    @FindBy(xpath = "/html/body/div")
    private WebElement proofYouAreNotRobot;

    private WebDriver driver;

    public AccountRegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void EnterPassword(){
        password.sendKeys("test123!test321");
        confirmRegisterButton.click();
    }
    public Boolean ConfirmRegister(){
        if(proofYouAreNotRobot.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
