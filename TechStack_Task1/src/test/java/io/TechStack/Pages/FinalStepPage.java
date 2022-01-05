package io.TechStack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalStepPage {
    @FindBy(xpath = "//*[@id=\"bookStage3Inc\"]/div[1]/div[2]")
    private WebElement adressForm;

    private WebDriver driver;

    public FinalStepPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public Boolean ConfirmUserFillBookForm() {
        if (adressForm.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
