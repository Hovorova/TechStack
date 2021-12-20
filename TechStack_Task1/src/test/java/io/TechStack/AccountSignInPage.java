package io.TechStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSignInPage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div")
    private WebElement linkSentUnit;

    private WebDriver driver;

    public AccountSignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean ConfirmSignIn(){
        if(linkSentUnit.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
