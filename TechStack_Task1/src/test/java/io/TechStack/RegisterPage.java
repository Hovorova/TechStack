package io.TechStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button")
    private WebElement submitButton;
    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void enterEmail (String input){
        username.sendKeys(input);
    }
    public void Register(){
        submitButton.click();
    }
}
