package io.techstack.pages;

import io.techstack.components.DriverWrapper;
import io.techstack.components.buttons.Button;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SignInPage {
    @FindBy(xpath = ".//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement continueWithEmailButton;

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountSignInPage enterEmail(String input) {
        DriverWrapper wrapper = new DriverWrapper();
        email.sendKeys(input);
        wrapper.<Button>getComponent(driver, Button.class, "submit").click();
        return new AccountSignInPage(driver);
    }
}
