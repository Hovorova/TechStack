package io.TechStack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSignInPage {
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div")
    private WebElement linkSentUnit;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]")
    private WebElement sendPassword;

    private WebDriver driver;

    public AccountSignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean ConfirmSignIn(){
        return (linkSentUnit.isSelected() || sendPassword.isDisplayed());
    }
}
