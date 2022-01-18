package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SignInPage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement email;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement continueWithEmailButton;

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterEmail(String input) {
        email.sendKeys(input);
    }
}
