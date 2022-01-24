package io.techstack.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AccountSignInPage {

    @FindBy(xpath = ".//button[contains(@class,'sign-in-without-pass')]")
    private WebElement sendPassword;

    private WebDriver driver;

    public AccountSignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
