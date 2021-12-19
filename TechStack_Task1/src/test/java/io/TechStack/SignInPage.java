package io.TechStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement email;
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button")
    private WebElement continueWithEmailButton;
    private WebDriver driver;

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void enterEmail(String input){
        email.sendKeys(input);
    }
    public void signIn(){
        continueWithEmailButton.click();
    }
}
