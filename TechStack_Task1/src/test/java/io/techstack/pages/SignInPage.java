package io.techstack.pages;

import io.techstack.components.DriverWrapper;
import io.techstack.components.buttons.Button;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SignInPage {
    @FindBy(xpath = ".//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement continueWithEmailButton;

    private DriverWrapper driver;

    public SignInPage(DriverWrapper driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AccountSignInPage enterEmail(String input) {
        email.sendKeys(input);
        driver.getComponent(Button.class, "submit").click();
        return new AccountSignInPage(driver);
    }
}
